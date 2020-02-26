package edu.cnm.deepdive.hush.model.repository;

import android.app.Application;
import edu.cnm.deepdive.hush.services.HushDatabase;

public class UserRepository {

    private final HushDatabase database;
    private static Application context;
    private UserRepository() {
      if (context == null) {
        throw new IllegalStateException();
      }
      database = HushDatabase.getInstance();
    }
    public HushDatabase getDatabase() {
      return database;
    }
    public static Application getContext() {
      return context;
    }
    public static void setContext(Application context) {
      UserRepository.context = context;
    }
    private static class InstanceHolder {
    private static final UserRepository INSTANCE = new UserRepository();
    }


}
