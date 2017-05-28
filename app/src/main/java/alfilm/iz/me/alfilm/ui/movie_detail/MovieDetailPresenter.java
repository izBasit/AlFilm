package alfilm.iz.me.alfilm.ui.movie_detail;

import alfilm.iz.me.alfilm.data.models.Result;
import alfilm.iz.me.alfilm.ui.base.BasePresenter;

import javax.inject.Inject;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import timber.log.Timber;

public class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

    @Inject
    MovieDetailPresenter() {
    }

    @Override
    public void attachView(MovieDetailView mvpView) {
        super.attachView(mvpView);

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onViewDetached() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true)
    public void handleEvent(Result result) {

        EventBus.getDefault().removeStickyEvent(result);
        Timber.d(result.toString());
    }
}
