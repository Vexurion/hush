package edu.cnm.deepdive.hush;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.hush.service.HushDatabase;
import io.reactivex.schedulers.Schedulers;

public class HushApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    HushDatabase.setContext(this);
    HushDatabase.getInstance().getHushDao().delete().subscribeOn(Schedulers.io()).subscribe();
  }

}
