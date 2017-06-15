package com.example.android.tweet_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/15/2017.
 */

public class TweetRecyclerAdapter extends RecyclerView.Adapter<TweetRecyclerAdapter.TweetViewHolder> {

    ArrayList<String> tweetsArrayList;
    Context context;

    public TweetRecyclerAdapter(ArrayList<String> tweetsArrayList, Context context) {
        this.tweetsArrayList = tweetsArrayList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        String this_tweets=tweetsArrayList.get(position);
        if(this_tweets.length()>10){
            return 0;
        }
        return 1;
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        if(viewType==0){
            layout=R.layout.small_size;

        }
        else{
            layout=R.layout.large_size;
        }
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(layout,parent,false);
        TweetViewHolder tweetViewHolder=new TweetViewHolder(itemView);

        return tweetViewHolder;
    }



    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {

        String this_tweets=tweetsArrayList.get(position);
        holder.tv_tweet.setText(this_tweets);
    }

    @Override
    public int getItemCount() {
        return tweetsArrayList.size();
    }

    static class  TweetViewHolder extends RecyclerView.ViewHolder{

        TextView tv_tweet;

        public TweetViewHolder(View itemView) {
            super(itemView);
            tv_tweet=(TextView)itemView.findViewById(R.id.tv_large_size);
        }
    }
}
