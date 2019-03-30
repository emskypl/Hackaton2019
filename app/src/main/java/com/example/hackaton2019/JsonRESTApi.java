package com.example.hackaton2019;

import java.util.List;

import connect_model.Komentarze;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import connect_model.Uzytkonwik;
import connect_model.Zgloszenia;
import testing.Post;

public interface JsonRESTApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    //Users
    @GET("user")
    Call<List<Uzytkonwik>> getUsers();

    @GET("user/readUser/{id}")
    Call<List<Uzytkonwik>> getUsers(@Path("id") int id);

    @POST("user/create")
    Call<Uzytkonwik> createPost(@Body Uzytkonwik uzytkonwik);





    //Notifications
    @GET("notification/{id}")
    Call<Zgloszenia> getNotification(@Path("id") int id);

    @GET("notification/allNotifications")
    Call<List<Zgloszenia>> getAllNotifications();

    @GET("notification/readBest25scored")
    Call<List<Zgloszenia>> getReadBest25Scored();

    @GET("notification/readSolvedNotifications")
    Call<List<Zgloszenia>> getSolvedNotifications();



    //Comments
    @GET("comment/{id}")
    Call<Komentarze> getComments(@Path("id") int id);

    @GET("comment/readCommentByTheBest")
    Call<List<Komentarze>> getCommentByTheBest();

    @GET("comment/readCommentsFromTheNewest")
    Call<List<Komentarze>> getCommentByTheNewest();

    @GET("comment/readCommentsFromTheOldest")
    Call<List<Komentarze>> getCommentByTheOldest();


}
