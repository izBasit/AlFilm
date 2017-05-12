package alfilm.iz.me.alfilm.ui.movie_detail;

import alfilm.iz.me.alfilm.R;
import alfilm.iz.me.alfilm.ui.base.BaseActivity;
import android.os.Bundle;
import javax.inject.Inject;

public class MovieDetailActivity extends BaseActivity implements MovieDetailView {

  @Inject MovieDetailPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_detail);


    activityComponent().inject(this);
    presenter.attachView(this);
  }

  @Override protected String getScreenName() {
    return getString(R.string.movie_info);
  }

  @Override protected void doDestroy() {

  }
}
