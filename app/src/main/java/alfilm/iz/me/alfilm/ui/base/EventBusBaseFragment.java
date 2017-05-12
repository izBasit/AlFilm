package alfilm.iz.me.alfilm.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import timber.log.Timber;

/**
 * Base Fragment with event bus configurations
 */
abstract class EventBusBaseFragment extends Fragment {
  private final String TAG = getClass().getSimpleName();

  public EventBusBaseFragment() {
  }

  @Subscribe public void onEvent(Object obj) {
    Timber.v("Event received...");
  }

  @Override public void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    EventBus.getDefault().register(this);
  }

  @Override public void onDestroy() {
    Log.d(TAG, "On Destroy of fragment");
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }
}