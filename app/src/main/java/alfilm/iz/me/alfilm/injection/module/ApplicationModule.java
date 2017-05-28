package alfilm.iz.me.alfilm.injection.module;

import alfilm.iz.me.alfilm.data.local.Preferences;
import alfilm.iz.me.alfilm.data.remote.AlFilmService;
import alfilm.iz.me.alfilm.injection.ApplicationContext;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    AlFilmService provideAlFilmService() {
        return AlFilmService.Creator.newAlFilmService();
    }
}