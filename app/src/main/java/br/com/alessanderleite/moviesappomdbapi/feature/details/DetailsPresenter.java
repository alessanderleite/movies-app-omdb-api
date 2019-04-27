package br.com.alessanderleite.moviesappomdbapi.feature.details;

import br.com.alessanderleite.moviesappomdbapi.core.api.OMDbApiService;
import br.com.alessanderleite.moviesappomdbapi.models.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View view;
    private OMDbApiService apiService;
    private String imdbId;

    public DetailsPresenter(DetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        view.showLoading();
    }

    @Override
    public void stop() {

    }

    @Override
    public void loadApi(OMDbApiService service) {
        apiService = service;
    }

    @Override
    public void onSearchMovie(String movie) {
        this.imdbId = imdbId;
        view.showLoading();
        Call<Movie> movieCallback = apiService.getOMDbApi().searchByOMDbId(imdbId);
        movieCallback.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                view.setPoster(movie.getPoster());
                view.setThumbnail(movie.getPoster());
                view.setTitle(movie.getActors());
                view.setYearAndRuntime(movie.getYear(), movie.getRuntime());
                view.setIMDbRating(movie.getImdbRating());
                view.setPlot(movie.getPlot());
                view.setDirector(movie.getDirector());
                view.setActors(movie.getActors());
                view.setProduction(movie.getProduction());
                view.setWriters(movie.getWriter());

                view.dismissLoading();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                view.showError();
            }
        });
    }
}
