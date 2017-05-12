package alfilm.iz.me.alfilm.data.local;

import alfilm.iz.me.alfilm.injection.ApplicationContext;
import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton final public class Preferences {

  private final String PREF_FILE_NAME = "me.iz.alfilm.preferences";

  private final SharedPreferences preferences;

  @Inject public Preferences(@ApplicationContext Context context) {
    preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
  }

  public boolean getBoolean(String key) {
    return preferences.getBoolean(key, false);
  }

  public boolean getBoolean(String key, boolean defaultValue) {
    return preferences.getBoolean(key, defaultValue);
  }

  public void saveBoolean(String key, boolean bool) {
    preferences.edit().putBoolean(key, bool).apply();
  }

  public void saveString(String key, String s) {
    preferences.edit().putString(key, s).apply();
  }

  public void saveInteger(String key, Integer integer) {
    preferences.edit().putInt(key, integer).apply();
  }

  public void clear() {
    preferences.edit().clear().apply();
  }

  public void remove(String key) {
    preferences.edit().remove(key).apply();
  }

  public String getString(String key) {
    return preferences.getString(key, "");
  }

  public String getString(String key, String defVal) {
    return preferences.getString(key, defVal);
  }

  public int getInteger(String key) {
    return getInteger(key, 0);
  }

  public int getInteger(String key, int defVal) {
    return preferences.getInt(key, defVal);
  }

  public void clearSharedPrefs() {
    clear();
  }

  public void saveLong(String key, long value) {
    preferences.edit().putLong(key, value).apply();
  }

  public long getLong(String key) {
    return preferences.getLong(key, 0L);
  }
}