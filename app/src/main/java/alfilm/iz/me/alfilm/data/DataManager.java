package alfilm.iz.me.alfilm.data;

import alfilm.iz.me.alfilm.data.local.AppConstants;
import alfilm.iz.me.alfilm.data.local.Preferences;
import alfilm.iz.me.alfilm.data.models.MovieList;
import alfilm.iz.me.alfilm.data.remote.AlFilmService;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class responsible for managing data. Be it Local or Remote.
 */
@Singleton public class DataManager {

  private final AlFilmService alFilmService;

  private final Preferences preferences;

  @Inject public DataManager(AlFilmService alFilmService, Preferences preferences) {
    this.alFilmService = alFilmService;
    this.preferences = preferences;
  }

  public Preferences getPreferences() {
    return preferences;
  }

  public Observable<MovieList> fetchMovies(int pageNo) {
    return alFilmService.getMovies(AppConstants.API_KEY, AppConstants.LANGUAGE, pageNo);
  }
}
