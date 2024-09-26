package com.example.goalalerts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface FootballAPI {

    @Headers({
            "x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key:e04ed5fafb36458801e55d5cc415892f"  // Asegúrate de que la API Key esté bien formateada (sin espacios)
    })
    @GET("fixtures")
    Call<LiveMatchesResponse> getLiveMatches(@Query("live") String live);
}
