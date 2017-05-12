package alfilm.iz.me.alfilm.utils;

import android.content.Context;
import android.widget.Toast;
import es.dmoral.toasty.Toasty;

public class ToastHelper {

  public static void showSuccessToast(Context context, String message) {
    Toasty.success(context, message, Toast.LENGTH_SHORT, true).show();
  }

  public static void showErrorToast(Context context, String message) {
    Toasty.error(context, message, Toast.LENGTH_SHORT, true).show();
  }

  public static void showInfoToast(Context context, String message) {
    Toasty.info(context, message, Toast.LENGTH_SHORT, true).show();
  }

  public static void showWarningToast(Context context, String message) {
    Toasty.warning(context, message, Toast.LENGTH_SHORT, true).show();
  }

  public static void showNormalToast(Context context, String message) {
    Toasty.normal(context, message, Toast.LENGTH_SHORT).show();
  }
}
