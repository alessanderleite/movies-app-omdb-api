package br.com.alessanderleite.moviesappomdbapi.feature.search.viewholder;

public interface CardMovieViewHolderContract {
    void setTitle(String title);
    void setYear(String year);
    void setMovieThumbnail(String poster);
    void resertViews();
}
