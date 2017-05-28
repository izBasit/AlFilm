package alfilm.iz.me.alfilm.data.remote;

import alfilm.iz.me.alfilm.BuildConfig;
import alfilm.iz.me.alfilm.data.models.MovieList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlFilmService {

  String ENDPOINT = "https://api.themoviedb.org";
  String IMG_ENDPOINT = "https://image.tmdb.org";

  @GET("/3/movie/now_playing") Observable<MovieList> getMovies(@Query("api_key") String apiKey,
    @Query("language") String language, @Query("page") int pageNo);




  class Creator {

    public static AlFilmService newAlFilmService() {
      // Setting up Gson
      final Gson gson =
        new GsonBuilder().excludeFieldsWithoutExposeAnnotation().disableHtmlEscaping().create();

      final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
      logging.setLevel(
        BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

      // Setting up HttpClient with interceptors for logging and failure.
      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

      Retrofit retrofit = new Retrofit.Builder() //
        .client(client) //
        .baseUrl(ENDPOINT) //
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

      return retrofit.create(AlFilmService.class);
    }
  }
}
