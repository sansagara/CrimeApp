package com.leonel.crimeapp.rest;

import com.leonel.crimeapp.models.PrecBanda;
import com.leonel.crimeapp.models.PrecCrimen;
import com.leonel.crimeapp.models.PrecEvento;
import com.leonel.crimeapp.models.PrecHistory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * APIPlug Endpoint Definitions
 *
 * @author APIPlug
 * @version v1.0
 */
public interface APIPlug {

    /*
    These methods defines our API endpoints.
    All REST methods such as GET,POST,UPDATE,DELETE can be stated in here.
    */
    @GET("banda")
    Call<List<PrecBanda>> getPrecBanda();

    @GET("crimen")
    Call<List<PrecCrimen>> getPrecCrimen();

    @GET("evento")
    Call<List<PrecEvento>> getPrecEvento();

    @GET("consolidado")
    Call<List<PrecHistory>> getPrecHistory();
}