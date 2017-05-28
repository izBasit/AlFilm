package alfilm.iz.me.alfilm.data;

import alfilm.iz.me.alfilm.data.models.MovieList;
import io.reactivex.Observable;

/**
 * Created by jarvis on 28/05/17.
 */

public interface DataSource {

    Observable<MovieList> fetchMovies(int pageNo);
}
