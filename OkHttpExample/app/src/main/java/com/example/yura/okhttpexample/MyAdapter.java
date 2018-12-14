package com.example.yura.okhttpexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<RepositoryEntity> repositoryList;

    public MyAdapter(Context context, List<RepositoryEntity> data) {
        this.context=context;
        this.layoutInflater = LayoutInflater.from(context);
        this.repositoryList=data;
    }

    public void setRepositoryList(List<RepositoryEntity> repositoryList){
        this.repositoryList=repositoryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=layoutInflater.inflate(R.layout.recyclerview_items,viewGroup,false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textViewId.setText(repositoryList.get(i).getId().toString());
        viewHolder.textViewTitle.setText(repositoryList.get(i).getFull_name().toString());
    }

    @Override
    public int getItemCount() {
        if(repositoryList.size()>100){
            return 100;
        }else {
            return repositoryList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewId;
        TextView textViewTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewId=itemView.findViewById(R.id.tv_id);
            textViewTitle=itemView.findViewById(R.id.tv_title);
        }
    }
}
