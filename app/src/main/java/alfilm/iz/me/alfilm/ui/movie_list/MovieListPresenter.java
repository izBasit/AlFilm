package alfilm.iz.me.alfilm.ui.movie_list;

import alfilm.iz.me.alfilm.R;
import alfilm.iz.me.alfilm.data.DataRepository;
import alfilm.iz.me.alfilm.data.models.Result;
import alfilm.iz.me.alfilm.ui.base.BasePresenter;
import alfilm.iz.me.alfilm.ui.movie_detail.MovieDetailActivity;
import alfilm.iz.me.alfilm.utils.RxUtils;
import hugo.weaving.DebugLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MovieListPresenter extends BasePresenter<MovieView> {

    private int pageNo = 0;

    private DataRepository dataRepository;

    private boolean isLoading = false;

    private List<Result> movieList;

    @Inject
    MovieListPresenter(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        disposables = RxUtils.getNewCompositeSubIfUnsubscribed(disposables);

        movieList = new ArrayList<>();
    }

    @Override
    protected void onViewDetached() {
        movieList = null;
        pageNo = 0;
    }

    @DebugLog
    void fetchMovies() {

        if (isLoading) return;

        pageNo++;

        getMvpView().showProgressbar(getMvpView().getStringValue(R.string.loading_movies));

        isLoading = true;
        disposables.add(dataRepository.fetchMovies(pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    isLoading = false;
                    getMvpView().dismissProgressbar(); // dismiss progressbar

                    Timber.d("Item count before adding %d", movieList.size());
                    movieList.addAll(movies.getResults());
                    Timber.d("Item count after adding %d", movieList.size());
                    // If its the first page load movies along with adapter
                    if (pageNo == 1) {

                        getMvpView().loadMovies(movieList, (result, position) -> {   // sending data to load adapter in UI
                            EventBus.getDefault().postSticky(result);
                            getMvpView().redirectToClass(MovieDetailActivity.class, false);
                        });
                        return;
                    }

                    // Rest of the time just update
                    getMvpView().updateMovies();

                }, throwable -> {
                    isLoading = false;
                    Timber.w("Error in api ", throwable);
                    getMvpView().dismissProgressbar();
                    getMvpView().onFailure(throwable.getMessage());
                }));
    }
}
