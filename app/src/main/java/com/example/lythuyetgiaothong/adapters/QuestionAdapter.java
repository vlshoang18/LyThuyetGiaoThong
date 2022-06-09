package com.example.lythuyetgiaothong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.models.Question;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
private Context context;
        List<Question> questions;

    public QuestionAdapter(Context context, List<Question> questions) {
        this.context = context;
        this.questions = questions;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_question,parent,false);
        return new QuestionAdapter.QuestionViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Question currenItem = questions.get(position);
        String urlnull ="";
        if
        (currenItem.getImage().getUrl().equals(urlnull)){
            ((QuestionViewHolder)holder).img.setVisibility(View.GONE);
        }
        else {
            ((QuestionViewHolder)holder).img.setVisibility(View.VISIBLE);
            Picasso.with(context).load(currenItem.getImage().getUrl()).error(R.drawable.background).fit().centerInside().into(((QuestionViewHolder)holder).img);

        }

        ((QuestionViewHolder)holder).itemTitle.setText(currenItem.getQuestion());
        ((QuestionViewHolder)holder).answer.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        ((QuestionViewHolder)holder).answer.setItemAnimator(new DefaultItemAnimator());
        AnswerAdapter answerAdapter = new AnswerAdapter( context,currenItem.getAnswer());
        ((QuestionViewHolder)holder).answer.setAdapter(answerAdapter);
        }
@Override
public int getItemCount() {
        if (questions != null){
        return questions.size();
        }
        return 0;
        }

public class QuestionViewHolder extends RecyclerView.ViewHolder {
    private TextView itemTitle;
    private RecyclerView answer;
    private ImageView img;
    public QuestionViewHolder(@NonNull View itemView) {
        super(itemView);
        itemTitle = itemView.findViewById(R.id.tv_quest);
        answer = itemView.findViewById(R.id.answer);
        img = itemView.findViewById(R.id.image);
    }
}


}
