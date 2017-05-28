package alfilm.iz.me.alfilm.data.remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import alfilm.iz.me.alfilm.data.DataSource;
import alfilm.iz.me.alfilm.data.local.AppConstants;
import alfilm.iz.me.alfilm.data.models.MovieList;
import io.reactivex.Observable;

/**
 * Created by jarvis on 29/05/17.
 */

@Singleton
public class RemoteDataSource implements DataSource {

    private final AlFilmService alFilmService;

    @Inject
    RemoteDataSource(AlFilmService alFilmService) {
        this.alFilmService = alFilmService;
    }

    /*
        Backend getting data from remote service
     */
    @Override
    public Observable<MovieList> fetchMovies(int pageNo) {
        return alFilmService.getMovies(AppConstants.API_KEY, AppConstants.LANGUAGE, pageNo);
    }
}
