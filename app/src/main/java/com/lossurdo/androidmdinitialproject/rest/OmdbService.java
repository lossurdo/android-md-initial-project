package com.lossurdo.androidmdinitialproject.rest;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Interface de exemplo para consulta à
 * API do IMDB via OMDB REST.
 *
 * Created by lossurdo on 29/12/15.
 */
public interface OmdbService {

    // http://www.omdbapi.com/?t=game+of+thrones&y=&plot=short&r=json
    @GET("/?y=&plot=short&r=json")
    Call<Seriado> consultaSeriadoPorTitulo(@Query("t") String title);

}
