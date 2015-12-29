package com.lossurdo.androidmdinitialproject.util.infra;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Call;
import retrofit.CallAdapter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Classe utilizada em conjunto com a API Retrofit
 * para consultas REST simplificadas.
 *
 * Created by lossurdo on 29/12/15.
 */
public class RestUtil {

    /**
     *
     * @param url URL Base da consulta REST
     * @param clazz Interface que implementa as
     *              anotações da API Retrofit
     * @return
     */
    public static final Object create(String url, Class clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

}
