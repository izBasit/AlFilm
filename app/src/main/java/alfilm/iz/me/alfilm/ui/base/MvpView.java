package alfilm.iz.me.alfilm.ui.base;

import android.support.annotation.StringRes;

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {

  void showProgressbar(String message);

  void dismissProgressbar();

  void onSuccess(String message);

  void onFailure(String message);

  void redirectToClass(Class clazz, boolean finishPresent);

  void finishActivity();

  String getStringValue(@StringRes int val);

  String getStringValue(@StringRes int val, Object... message);
}