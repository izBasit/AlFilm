package alfilm.iz.me.alfilm.utils;

import alfilm.iz.me.alfilm.data.remote.AlFilmService;
import alfilm.iz.me.alfilm.injection.ApplicationContext;
import android.content.Context;
import android.support.annotation.StringRes;
import hugo.weaving.DebugLog;
import java.util.Locale;

public class StringHelper {

  @DebugLog
  public static String getString(@ApplicationContext Context context, @StringRes int res) {
    return context.getString(res);
  }

  @DebugLog public static String getString(@ApplicationContext Context context, @StringRes int res,
    Object... message) {
    return String.format(Locale.getDefault(), getString(context, res), message);
  }

  @DebugLog public static String getImagePath(String path) {

    String baseUrl = AlFilmService.IMG_ENDPOINT;
    String size = "/t/p/w500";

    StringBuilder sb = new StringBuilder(3);
    sb.append(baseUrl).append(size).append(path);
    return sb.toString();
  }
}
