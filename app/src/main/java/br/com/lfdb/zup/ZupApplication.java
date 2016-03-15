package br.com.lfdb.zup;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import br.com.lfdb.zup.track.GoogleAnalyticsTracker;
import net.danlew.android.joda.JodaTimeAndroid;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ZupApplication extends MultiDexApplication {

  static Context context;

  @Override public void onCreate() {
    super.onCreate();

    JodaTimeAndroid.init(this);
    new Thread(() -> {
      CalligraphyConfig.initDefault(
          new CalligraphyConfig.Builder().setDefaultFontPath("fonts/OpenSans-Regular.ttf")
              .setFontAttrId(R.attr.fontPath)
              .build());
    }).start();

    GoogleAnalyticsTracker.init(this);

    context = this.getApplicationContext();
  }

  public static Context getContext() {
    return context;
  }
}
