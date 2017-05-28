package alfilm.iz.me.alfilm.ui.movie_list;

import alfilm.iz.me.alfilm.data.models.Result;
import alfilm.iz.me.alfilm.ui.adapters.MovieListAdapter;
import alfilm.iz.me.alfilm.ui.base.MvpView;
import java.util.List;

public interface MovieView extends MvpView {

  void loadMovies(List<Result> movies, MovieListAdapter.MovieCallback callback);

  void updateMovies();
}
