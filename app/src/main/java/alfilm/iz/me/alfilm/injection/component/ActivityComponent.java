package alfilm.iz.me.alfilm.injection.component;

import alfilm.iz.me.alfilm.injection.PerActivity;
import alfilm.iz.me.alfilm.injection.module.ActivityModule;
import alfilm.iz.me.alfilm.ui.movie_detail.MovieDetailActivity;
import alfilm.iz.me.alfilm.ui.movie_list.MovieListActivity;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(MovieListActivity movieListActivity);

  void inject(MovieDetailActivity movieDetailActivity);
}