package alfilm.iz.me.alfilm.injection.module;

import alfilm.iz.me.alfilm.injection.ActivityContext;
import android.app.Activity;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }

}