package com.example.lythuyetgiaothong.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.QuestionAdapter;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.QuestionCategoryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    //    private List<Question> list;
    private QuestionAdapter questionAdapter;
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvCount;
    private ImageView imgChange;
    private ImageView imgChanged;

//    boolean barIsShowing = true;

    //    public void fade(View view){
//        Log.i("Info","selected");
//        ImageView view1 = findViewById(R.id.img_change);
//        ImageView view2 = findViewById(R.id.img_changed);
//        if (barIsShowing){
//            barIsShowing = false;
//            view1.animate().alpha(0).setDuration(500);
//            view2.animate().alpha(1).setDuration(500);
//        }else{
//            barIsShowing = true;
//            view1.animate().alpha(1).setDuration(500);
//            view2.animate().alpha(0).setDuration(500);
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        initUi();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String id = (String) b.get("Keychapter");
        getData(id);

        mRecyclerView = findViewById(R.id.rcv_question);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        questionAdapter = new QuestionAdapter(Question1Activity.this, list);
//        mRecyclerView.setAdapter(questionAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    int position = getCurrentItem();
//                    tvCount.setText("Question " + (position+1) + " / " + list.size());
//                }
                int position = getCurrentItem();
                tvCount.setText("Question " + (position+1) + " / " + questionAdapter.getItemCount());
            }
        });
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview();
            }
        });
        tvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog(Gravity.BOTTOM);

            }   // on click den cau hoi
        });
    }

    private void initUi() {
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        tvCount = findViewById(R.id.tv_count);

    }


    public boolean hasPreview() {
        return getCurrentItem() > 0;
    }

    public boolean hasNext() {
        return mRecyclerView.getAdapter() != null &&
                getCurrentItem() < (mRecyclerView.getAdapter().getItemCount() - 1);
    }

    public void preview() {
        int position = getCurrentItem();
        if (position > 0)
            setCurrentItem(position - 1, true);
    }

    public void next() {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        if (adapter == null)
            return;

        int position = getCurrentItem();
        int count = adapter.getItemCount();
        if (position < (count - 1))
            setCurrentItem(position + 1, true);
    }
    //search c??u h???i
    public void dialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_question);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);
        ImageView imgGo = dialog.findViewById(R.id.btn_go);
        EditText edtPage = dialog.findViewById(R.id.edt_page_go);
        TextView tvPage = dialog.findViewById(R.id.tv_page);
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        tvPage.setText("/ "+ String.valueOf(adapter.getItemCount()));
        imgGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter == null)
                    return;
                String edt = String.valueOf(edtPage.getText());
                String n = "";
                int count = adapter.getItemCount();
                if (edt.equals(n))
                {
                    Toast.makeText(QuestionActivity.this,"Ch??a ch???n c??u c???n ?????n",Toast.LENGTH_SHORT).show();
                }
                else {
                    int position =Integer.parseInt(edt);
                    if (position < (count))
                    {
                        setCurrentItem(position-1, false);
                        dialog.dismiss();
                    }
                    else {
                        position = count;
                        setCurrentItem(position-1,false);
                        dialog.dismiss();
                        Toast.makeText(QuestionActivity.this,count +" l?? c??u cu???i r???i",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dialog.show();
    }
    private int getCurrentItem() {
        return ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                .findFirstVisibleItemPosition();
    }

    private void setCurrentItem(int position, boolean smooth) {
        if (smooth)
            mRecyclerView.smoothScrollToPosition(position);
        else
            mRecyclerView.scrollToPosition(position);
    }

    private void getData(String id) {

        Call<QuestionCategoryResponse> responseDTOCall = (Call<QuestionCategoryResponse>) ApiClient.apiQuestion().getChapter(id);
        responseDTOCall.enqueue(new Callback<QuestionCategoryResponse>() {
            @Override
            public void onResponse(Call<QuestionCategoryResponse> call, Response<QuestionCategoryResponse> response) {
                questionAdapter = new QuestionAdapter(QuestionActivity.this,response.body().getData());
                mRecyclerView.setAdapter(questionAdapter);
            }
            @Override
            public void onFailure(Call<QuestionCategoryResponse> call, Throwable t) {
                Toast.makeText(QuestionActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}