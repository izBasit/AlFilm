package alfilm.iz.me.alfilm.ui.movie_list;

import alfilm.iz.me.alfilm.R;
import alfilm.iz.me.alfilm.data.DataManager;
import alfilm.iz.me.alfilm.ui.base.BasePresenter;
import alfilm.iz.me.alfilm.ui.movie_detail.MovieDetailActivity;
import alfilm.iz.me.alfilm.utils.RxUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import timber.log.Timber;

public class MovieListPresenter extends BasePresenter<MovieView> {

  private int pageNo = 0;

  private DataManager dataManager;

  private boolean isLoading = false;

  @Inject public MovieListPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
    disposables = RxUtils.getNewCompositeSubIfUnsubscribed(disposables);
  }

  @Override protected void onViewDetached() {

  }

  void fetchMovies() {

    if (isLoading) return;

    pageNo++;

    getMvpView().showProgressbar(getMvpView().getStringValue(R.string.loading_movies));

    isLoading = true;
    disposables.add(dataManager.fetchMovies(pageNo)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(movies -> {
        isLoading = false;
        getMvpView().dismissProgressbar(); // dismiss progressbar
        getMvpView().loadMovies(movies.getResults(), (result, position) -> {   // sending data to load adapter in UI
          EventBus.getDefault().postSticky(result);
          getMvpView().redirectToClass(MovieDetailActivity.class, false);
        });
      }, throwable -> {
        isLoading = false;
        Timber.w("Error in api ", throwable);
        getMvpView().dismissProgressbar();
        getMvpView().onFailure(throwable.getMessage());
      }));
  }
}
