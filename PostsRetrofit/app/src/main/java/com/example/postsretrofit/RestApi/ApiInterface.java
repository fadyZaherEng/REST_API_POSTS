package com.example.postsretrofit.RestApi;

import com.example.postsretrofit.Pojo.PostViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("posts")
    Call<ArrayList<PostViewModel>> GetPosts();
}
