package alfilm.iz.me.alfilm.ui.movie_list;

import alfilm.iz.me.alfilm.R;
import alfilm.iz.me.alfilm.data.models.Result;
import alfilm.iz.me.alfilm.ui.adapters.MovieListAdapter;
import alfilm.iz.me.alfilm.ui.base.BaseActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import timber.log.Timber;

import java.util.List;

import javax.inject.Inject;

public class MovieListActivity extends BaseActivity implements MovieView {

    private static final int VISIBILITY_THRESHOLD = 5;

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    @BindView(R.id.tvEmptyMessage)
    TextView tvEmptyMessage;

    @Inject
    MovieListPresenter presenter;

    private LinearLayoutManager layoutManager;

    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        activityComponent().inject(this);
        presenter.attachView(this);

        layoutManager = new LinearLayoutManager(this);
        rvMovies.setLayoutManager(layoutManager);
        rvMovies.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //After the list is scrolled, check the last visible position in the list. If the position is the threshold value load the bottom tweets.
                int totalItemCount = movieListAdapter.getItemCount();
                int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                Timber.d("Total item count %d , last item %d", totalItemCount, lastVisibleItem);

                if (totalItemCount <= (lastVisibleItem + VISIBILITY_THRESHOLD)) {
                    Timber.d("Fetching movies ");
                    presenter.fetchMovies();
                }
            }
        });

        presenter.fetchMovies();
    }

    @Override
    protected String getScreenName() {
        return getString(R.string.movie_list);
    }

    @Override
    protected void doDestroy() {
        presenter.detachView();
        presenter = null;
    }

    @DebugLog
    @Override
    public void loadMovies(List<Result> movies, MovieListAdapter.MovieCallback callback) {

        rvMovies.setVisibility(View.VISIBLE);
        tvEmptyMessage.setVisibility(View.GONE);
        movieListAdapter = new MovieListAdapter(movies, callback);
        rvMovies.setAdapter(movieListAdapter);
    }

    @DebugLog
    @Override
    public void updateMovies() {
        movieListAdapter.notifyDataSetChanged();
    }


}
