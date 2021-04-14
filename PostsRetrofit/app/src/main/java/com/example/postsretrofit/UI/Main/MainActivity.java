package com.example.postsretrofit.UI.Main;
import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.postsretrofit.Pojo.PostViewModel;
import com.example.postsretrofit.R;
import com.example.postsretrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ViewModelMVVM viewModel;
ArrayList<PostViewModel>Posts;
PostAdapter postAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        Posts=new ArrayList<>();
        postAdapter=new PostAdapter(this);
        binding.PostsRV.setAdapter(postAdapter);
        binding.PostsRV.setLayoutManager(new LinearLayoutManager(this));

        viewModel= ViewModelProviders.of(this).get(ViewModelMVVM.class);

        //view model
        viewModel.GetPosts();
        viewModel.arrayListMutableLiveData.observe(this, new Observer<ArrayList<PostViewModel>>() {
            @Override
            public void onChanged(ArrayList<PostViewModel> postViewModels) {
                postAdapter.setList(postViewModels);
                postAdapter.notifyDataSetChanged();
            }
        });

    }
}