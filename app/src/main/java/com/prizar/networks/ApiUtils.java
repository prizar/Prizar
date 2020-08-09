package com.prizar.networks;

public class ApiUtils {
    public ApiUtils() {
    }

    public static final String BASE_URL="https://pb.dressbeat.com";
    public static APIService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
