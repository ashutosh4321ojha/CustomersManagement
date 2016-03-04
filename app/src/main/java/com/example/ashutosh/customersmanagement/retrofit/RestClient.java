package com.example.ashutosh.customersmanagement.retrofit;


import com.example.ashutosh.customersmanagement.config.Config;

import retrofit.RestAdapter;

public class RestClient {
    private static ApiService apiService = null;

    public static ApiService getApiService() {
        if (apiService == null) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Config.getBaseURL())
                    .build();




            apiService = restAdapter.create(ApiService.class);
        }
        return apiService;
    }


}
