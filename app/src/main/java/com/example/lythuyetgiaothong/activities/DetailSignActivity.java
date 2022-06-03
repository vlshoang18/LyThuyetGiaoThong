package com.example.lythuyetgiaothong.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.SignDetailModel;
import com.example.lythuyetgiaothong.models.SignModel;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSignActivity extends AppCompatActivity {

private  TextView tv_name;
private  TextView tv_description;
private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsign);
         initUi(); // khoi tao ham giao dien
        Intent iin= getIntent();
        Bundle b = iin.getExtras();


    getIn4(iin,b);


    }
    private void getIn4(Intent intent, Bundle b){
        String id = (String) b.get("Key_1");
        Call<SignDetailModel> responseDTOCall = (Call<SignDetailModel>) ApiClient.getapiSign().getsigndetail(id);
        responseDTOCall.enqueue(new Callback<SignDetailModel>() {
            @Override
            public void onResponse(Call<SignDetailModel> call, Response<SignDetailModel> response) {
                tv_name.setText(response.body().getData().get(0).getName());
//                String url = response.body().getData().get(0).getUrl();
                Picasso.with(DetailSignActivity.this)
                        .load(response.body().getData().get(0).getImage().getUrl()).fit().centerInside().into(image);
//                Picasso.with(context)
//                        .load(
//                                response.body().getData().get(0).getImage().getUrl()). // cái này là dữ liệu api trả về
//                        error(R.drawable.background). // cái này là option muôn hay k cũng dược, nếu mà ảnh load
//                        // về lỗi thì nó hiện 1 hình mình set cứng.
//                                fit().centerInside().
//                        into((holder).img);// cái này là đẩy dữ liệu ảnh lên image view trong item.
                tv_description.setText(response.body().getData().get(0).getDescription());
            }
            @Override
            public void onFailure(Call<SignDetailModel> call, Throwable t) {
                Toast.makeText(DetailSignActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });

    }


//    private void bundle() {
//        Bundle bd = getIntent().getExtras();
//        //kiem tra bien ben man 1 neu trung thi xuat edt con k thi null
//        if(bd != null)
//
//        {
//            String ten =bd.getString("Key_1");
//            tv.setText(ten);
//        }
//    }

    private void initUi() {

        tv_name = findViewById(R.id.tv_name);
        tv_description = findViewById(R.id.tv_description);
        image = findViewById(R.id.imagedetail);
    }

}