package br.com.alessanderleite.moviesappomdbapi.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie implements Parcelable {
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Released")
    private String released;
    @SerializedName("Runtime")
    private String runtime;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Director")
    private String director;
    @SerializedName("Writer")
    private String writer;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Language")
    private String language;
    @SerializedName("Country")
    private String country;
    @SerializedName("Awards")
    private String awards;
    @SerializedName("Poster")
    private String poster;
    @SerializedName("Ratings")
    private List<Rating> ratings;
    @SerializedName("Metascore")
    private String metascore;
    @SerializedName("imdbRating")
    private String imdbRating;
    @SerializedName("imdbVotes")
    private String imdbVotes;
    @SerializedName("imdbID")
    private String imdbId;
    @SerializedName("Type")
    private String type;
    @SerializedName("DVD")
    private String dvd;
    @SerializedName("BoxOffice")
    private String boxOffice;
    @SerializedName("Production")
    private String production;
    @SerializedName("Website")
    private String website;
    @SerializedName("Response")
    private String response;

    protected Movie(Parcel in) {
        title = in.readString();
        year = in.readString();
        rated = in.readString();
        released = in.readString();
        runtime = in.readString();
        genre = in.readString();
        director = in.readString();
        writer = in.readString();
        actors = in.readString();
        plot = in.readString();
        language = in.readString();
        country = in.readString();
        awards = in.readString();
        poster = in.readString();
        ratings = in.createTypedArrayList(Rating.CREATOR);
        metascore = in.readString();
        imdbRating = in.readString();
        imdbVotes = in.readString();
        imdbId = in.readString();
        type = in.readString();
        dvd = in.readString();
        boxOffice = in.readString();
        production = in.readString();
        website = in.readString();
        response = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(rated);
        dest.writeString(released);
        dest.writeString(runtime);
        dest.writeString(genre);
        dest.writeString(director);
        dest.writeString(writer);
        dest.writeString(actors);
        dest.writeString(plot);
        dest.writeString(language);
        dest.writeString(country);
        dest.writeString(awards);
        dest.writeString(poster);
        dest.writeString(metascore);
        dest.writeString(imdbRating);
        dest.writeString(imdbVotes);
        dest.writeString(imdbId);
        dest.writeString(type);
        dest.writeString(dvd);
        dest.writeString(boxOffice);
        dest.writeString(production);
        dest.writeString(website);
        dest.writeString(response);
    }
}
