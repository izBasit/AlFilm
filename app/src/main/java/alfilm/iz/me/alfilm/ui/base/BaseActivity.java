package alfilm.iz.me.alfilm.ui.base;

import alfilm.iz.me.alfilm.AlFilmApp;
import alfilm.iz.me.alfilm.injection.component.ActivityComponent;
import alfilm.iz.me.alfilm.injection.component.DaggerActivityComponent;
import alfilm.iz.me.alfilm.injection.module.ActivityModule;
import alfilm.iz.me.alfilm.utils.StringHelper;
import alfilm.iz.me.alfilm.utils.ToastHelper;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hugo.weaving.DebugLog;
import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

  protected ActionBar actionBar;
  private Unbinder unbinder;
  private ActivityComponent activityComponent;

  private ProgressDialog progressDialog;

  @Override public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    unbinder = ButterKnife.bind(this);

    Timber.d("In base");
    actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(getScreenName());
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    doDestroy();

    if (unbinder != null) {
      unbinder.unbind();
    }
  }



  @Override public void onBackPressed() {
    super.onBackPressed();
    finish();
  }

  public ActivityComponent activityComponent() {
    if (activityComponent == null) {
      activityComponent = DaggerActivityComponent.builder()
        .activityModule(new ActivityModule(this))
        .applicationComponent(AlFilmApp.get(this).getComponent())
        .build();
    }
    return activityComponent;
  }

  protected abstract String getScreenName();

  protected abstract void doDestroy();

  public void onSuccess(String message) {
    runOnUiThread(() -> {
      ToastHelper.showSuccessToast(this, message);
    });
  }

  public void onFailure(String message) {
    runOnUiThread(() -> {
      ToastHelper.showErrorToast(this, message);
    });
  }

  public void redirectToClass(Class clazz, boolean finishPresent) {
    runOnUiThread(() -> {
      Intent intent = new Intent(this, clazz);
      startActivity(intent);
      if (finishPresent) finish();
    });
  }

  public void finishActivity() {
    runOnUiThread(this::finish);
  }

  public String getStringValue(@StringRes int res) {
    return StringHelper.getString(this.getApplicationContext(), res);
  }

  public String getStringValue(@StringRes int res, Object... message) {
    return StringHelper.getString(this.getApplicationContext(), res, message);
  }

  @DebugLog public void showProgressbar(String message) {

    if (message == null || message.isEmpty()) {
      message = "Loading...";
    }
    String finalMessage = message;
    runOnUiThread(() -> {
      progressDialog = new ProgressDialog(this);
      progressDialog.setMessage(finalMessage);
      progressDialog.show();
    });
  }

  @DebugLog public void dismissProgressbar() {
    runOnUiThread(() -> {
      if (progressDialog != null) progressDialog.dismiss();
    });
  }
}
