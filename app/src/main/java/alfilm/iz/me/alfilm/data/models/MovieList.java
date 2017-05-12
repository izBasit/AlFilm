package alfilm.iz.me.alfilm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MovieList {

  @SerializedName("page") @Expose private long page;
  @SerializedName("results") @Expose private List<Result> results = null;
  @SerializedName("dates") @Expose private Dates dates;
  @SerializedName("total_pages") @Expose private long totalPages;
  @SerializedName("total_results") @Expose private long totalResults;

  public long getPage() {
    return page;
  }

  public void setPage(long page) {
    this.page = page;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }

  public Dates getDates() {
    return dates;
  }

  public void setDates(Dates dates) {
    this.dates = dates;
  }

  public long getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(long totalPages) {
    this.totalPages = totalPages;
  }

  public long getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(long totalResults) {
    this.totalResults = totalResults;
  }
}