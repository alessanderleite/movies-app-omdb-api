package br.com.alessanderleite.moviesappomdbapi.feature.search;

import java.util.List;

import br.com.alessanderleite.moviesappomdbapi.core.base.BasePresenter;
import br.com.alessanderleite.moviesappomdbapi.core.base.BaseView;
import br.com.alessanderleite.moviesappomdbapi.feature.details.DetailsContract;
import br.com.alessanderleite.moviesappomdbapi.models.Card;

public interface SearchContract {

    interface View extends BaseView<DetailsContract.Presenter> {

        void showMovies(List<Card> results);

        void cleanSearch();

        void hideKeyboard();

        void showError();

        void showLoading();
    }

    interface Presenter extends BasePresenter {
        void onSearchedMovie(String movie);
    }
}
