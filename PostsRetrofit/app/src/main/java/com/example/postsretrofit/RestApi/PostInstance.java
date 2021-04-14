package com.example.postsretrofit.RestApi;

import com.example.postsretrofit.Pojo.PostViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostInstance
{
   final private String BaseUrl="https://jsonplaceholder.typicode.com/";
   private ApiInterface apiInterface;
   private static PostInstance postInstance;

   public PostInstance()
   {
       Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl).
               addConverterFactory(GsonConverterFactory.create()).build();
       apiInterface=retrofit.create(ApiInterface.class);
   }
   public Call<ArrayList<PostViewModel>> getPosts()
   {
       return apiInterface.GetPosts();
   }
   public static PostInstance GetInstance()
   {
       if (postInstance==null)
       {
           postInstance=new PostInstance();
       }
       return postInstance;
   }
}
