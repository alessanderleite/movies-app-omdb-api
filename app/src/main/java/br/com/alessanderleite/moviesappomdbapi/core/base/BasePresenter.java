package br.com.alessanderleite.moviesappomdbapi.core.base;

import br.com.alessanderleite.moviesappomdbapi.core.api.OMDbApiService;

public interface BasePresenter {
    void start();

    void stop();

    void loadApi(OMDbApiService service);
}
