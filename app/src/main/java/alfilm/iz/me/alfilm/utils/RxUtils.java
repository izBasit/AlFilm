package alfilm.iz.me.alfilm.utils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxUtils {

    public static void unsubscribeIfNotNull(Disposable subscription) {
        if (subscription != null) {
            subscription.dispose();
        }
    }

    public static CompositeDisposable getNewCompositeSubIfUnsubscribed(CompositeDisposable subscription) {
        if (subscription == null || subscription.isDisposed()) {
            return new CompositeDisposable();
        }

        return subscription;
    }
}