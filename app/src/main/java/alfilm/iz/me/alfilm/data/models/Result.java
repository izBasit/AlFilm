package alfilm.iz.me.alfilm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Result {

  @SerializedName("poster_path") @Expose private String posterPath;
  @SerializedName("adult") @Expose private boolean adult;
  @SerializedName("overview") @Expose private String overview;
  @SerializedName("release_date") @Expose private String releaseDate;
  @SerializedName("genre_ids") @Expose private List<Long> genreIds = null;
  @SerializedName("id") @Expose private long id;
  @SerializedName("original_title") @Expose private String originalTitle;
  @SerializedName("original_language") @Expose private String originalLanguage;
  @SerializedName("title") @Expose private String title;
  @SerializedName("backdrop_path") @Expose private String backdropPath;
  @SerializedName("popularity") @Expose private double popularity;
  @SerializedName("vote_count") @Expose private long voteCount;
  @SerializedName("video") @Expose private boolean video;
  @SerializedName("vote_average") @Expose private double voteAverage;

  public String getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public boolean isAdult() {
    return adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public List<Long> getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(List<Long> genreIds) {
    this.genreIds = genreIds;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOriginalTitle() {
    return originalTitle;
  }

  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  public double getPopularity() {
    return popularity;
  }

  public void setPopularity(double popularity) {
    this.popularity = popularity;
  }

  public long getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(long voteCount) {
    this.voteCount = voteCount;
  }

  public boolean isVideo() {
    return video;
  }

  public void setVideo(boolean video) {
    this.video = video;
  }

  public double getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(double voteAverage) {
    this.voteAverage = voteAverage;
  }

  @Override public String toString() {
    return "Result{"
      + "posterPath='"
      + posterPath
      + '\''
      + ", adult="
      + adult
      + ", overview='"
      + overview
      + '\''
      + ", releaseDate='"
      + releaseDate
      + '\''
      + ", genreIds="
      + genreIds
      + ", id="
      + id
      + ", originalTitle='"
      + originalTitle
      + '\''
      + ", originalLanguage='"
      + originalLanguage
      + '\''
      + ", title='"
      + title
      + '\''
      + ", backdropPath='"
      + backdropPath
      + '\''
      + ", popularity="
      + popularity
      + ", voteCount="
      + voteCount
      + ", video="
      + video
      + ", voteAverage="
      + voteAverage
      + '}';
  }
}