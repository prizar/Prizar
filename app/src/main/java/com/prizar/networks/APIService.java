package com.prizar.networks;


import com.prizar.model.draws.DrawDateResult;
import com.prizar.model.drawsearch.DrawList;
import com.prizar.model.drawsearch.DrawSearchResult;
import com.prizar.model.login.LoginResult;
import com.prizar.model.login.SignupResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/api/login")
    @FormUrlEncoded
    Call<LoginResult> saveData(@Field("email") String userID, @Field("password") String password, @Field("device_type") String device_type, @Field("fcm_token") String fcm_token);

    @POST("/api/register")
    @FormUrlEncoded
    Call<SignupResult> saveData(@Field("first_name") String FirstName,@Field("email") String Email, @Field("personal_phone") String PersonalPhone, @Field("password") String Password, @Field("password_confirmation") String PasswordConfirmation);

    @POST("/api/draw_result")
    @FormUrlEncoded
    Call<DrawSearchResult> saveData(@Field("draw_id") String draw_id, @Field("denomination_id") String denomination_id, @Field("search_type") String search_type, @Field("from") String from, @Field("to") String to,@Field("comma_seperated") String comma_seperated);

    @POST("/api/draws")
    @FormUrlEncoded
    Call<DrawDateResult> saveList( @Field("denomination_id") String denomination_id);

    // @POST("/api/draw_result")
    //@FormUrlEncoded
   // Call<DrawList> saveData(@Field("city") String city, @Field("denominations") String denominations, @Field("draw_date") String draw_date, @Field("prize_number") String prize_number);

}
