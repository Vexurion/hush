package edu.cnm.deepdive.hush;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class HushApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }

}
