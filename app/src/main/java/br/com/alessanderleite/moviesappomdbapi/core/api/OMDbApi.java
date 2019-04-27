package br.com.alessanderleite.moviesappomdbapi.core.api;

import br.com.alessanderleite.moviesappomdbapi.models.Movie;
import br.com.alessanderleite.moviesappomdbapi.models.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OMDbApi {

    @GET("/")
    Call<SearchResponse> searchByTitle(@Query("s") String title);

    @GET("/")
    Call<Movie> searchByOMDbId(@Query("i") String omdbId);
}
