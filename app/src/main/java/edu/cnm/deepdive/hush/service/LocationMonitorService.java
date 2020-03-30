package edu.cnm.deepdive.hush.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class LocationMonitorService extends Service {

  public LocationMonitorService() {
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(getClass().getName(), "Service starting");
    //TODO Check current location vs hush locations.
    stopSelf();
    return START_STICKY_COMPATIBILITY;
  }
}
