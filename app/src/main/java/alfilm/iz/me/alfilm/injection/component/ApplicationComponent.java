package alfilm.iz.me.alfilm.injection.component;

import alfilm.iz.me.alfilm.AlFilmApp;
import alfilm.iz.me.alfilm.data.DataRepository;
import alfilm.iz.me.alfilm.data.local.Preferences;
import alfilm.iz.me.alfilm.data.remote.AlFilmService;
import alfilm.iz.me.alfilm.data.remote.RemoteDataSource;
import alfilm.iz.me.alfilm.injection.ApplicationContext;
import alfilm.iz.me.alfilm.injection.module.ApplicationModule;

import android.app.Application;
import android.content.Context;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


    void inject(AlFilmApp alFilmApplication);

    @ApplicationContext
    Context context();

    DataRepository dataRepository();

}

