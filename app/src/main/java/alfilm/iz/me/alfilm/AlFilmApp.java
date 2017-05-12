package alfilm.iz.me.alfilm;

import alfilm.iz.me.alfilm.injection.component.ApplicationComponent;
import alfilm.iz.me.alfilm.injection.component.DaggerApplicationComponent;
import alfilm.iz.me.alfilm.injection.module.ApplicationModule;
import android.app.Application;
import android.content.Context;
import timber.log.Timber;


public class AlFilmApp extends Application {

  private ApplicationComponent applicationComponent;

  public static AlFilmApp get(Context context) {
    return (AlFilmApp) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    applicationComponent =
      DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    applicationComponent.inject(this);
  }

  public ApplicationComponent getComponent() {
    return applicationComponent;
  }

  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    this.applicationComponent = applicationComponent;
  }
}
