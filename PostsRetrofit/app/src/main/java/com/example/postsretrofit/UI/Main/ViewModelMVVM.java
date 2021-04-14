package com.example.postsretrofit.UI.Main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.postsretrofit.Pojo.PostViewModel;
import com.example.postsretrofit.Pojo.PostViewModel.*;
import com.example.postsretrofit.RestApi.PostInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelMVVM extends ViewModel
{
   MutableLiveData<ArrayList<PostViewModel>> arrayListMutableLiveData=new MutableLiveData<>();
   PostInstance postInstance=PostInstance.GetInstance();
    public ViewModelMVVM() {

    }
    public void GetPosts()
    {
        postInstance.getPosts().enqueue(new Callback<ArrayList<PostViewModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostViewModel>> call, Response<ArrayList<PostViewModel>> response) {
                arrayListMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PostViewModel>> call, Throwable t) {

            }
        });

    }
}
