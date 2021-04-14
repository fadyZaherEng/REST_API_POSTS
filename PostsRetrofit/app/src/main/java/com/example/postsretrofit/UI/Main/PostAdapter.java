package com.example.postsretrofit.UI.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postsretrofit.Pojo.PostViewModel;
import com.example.postsretrofit.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Viewholder> {
   ArrayList<PostViewModel> Posts=new ArrayList<>();
   Context context;

    public PostAdapter( Context context) {
        this.context = context;
    }
    public void setList(ArrayList<PostViewModel> Posts)
    {
        this.Posts=Posts;
    }
    public void addItem(PostViewModel postViewModel)
    {
        Posts.add(postViewModel);
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_post_layout,null,false);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.id.setText(String.valueOf(Posts.get(position).getUserId()));
        holder.title.setText(Posts.get(position).getTitle());
        holder.body.setText(Posts.get(position).getBody());
    }


    @Override
    public int getItemCount() {
        return Posts.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView id,title,body;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.UserID);
            title=itemView.findViewById(R.id.UserTitle);
            body=itemView.findViewById(R.id.UserBody);
        }
    }
}
