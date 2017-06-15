package com.example.android.tweet_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> tweetsArrayList;
    RecyclerView recyclerView;
    EditText et_tweet;
    Button btnAdd;
    TweetRecyclerAdapter tweetRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tweetsArrayList=new ArrayList<>();
        et_tweet=(EditText)findViewById(R.id.et_tweet);
        btnAdd=(Button)findViewById(R.id.btn_Add);
        recyclerView=(RecyclerView)findViewById(R.id.rv_tweet);
        tweetRecyclerAdapter=new TweetRecyclerAdapter(tweetsArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(tweetRecyclerAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }
    public void addItem(){
        String item=et_tweet.getText().toString().trim();
        tweetsArrayList.add(item);
        tweetRecyclerAdapter.notifyDataSetChanged();
        et_tweet.setText("");
    }
}
