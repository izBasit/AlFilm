package alfilm.iz.me.alfilm.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import alfilm.iz.me.alfilm.data.DataSource;
import alfilm.iz.me.alfilm.data.models.MovieList;
import alfilm.iz.me.alfilm.data.remote.RemoteDataSource;
import io.reactivex.Observable;

/**
 * Created by jarvis on 29/05/17.
 * The Model in MVP which asks the backend for data
 */

@Singleton
public class DataRepository implements DataSource {


    private RemoteDataSource remoteDataSource;


    @Inject
    DataRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    /*
     * Asking backend for data
     */
    @Override
    public Observable<MovieList> fetchMovies(int pageNo) {
        return remoteDataSource.fetchMovies(pageNo);
    }
}
