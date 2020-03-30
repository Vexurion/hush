package edu.cnm.deepdive.hush.model.repository;

import android.content.Context;
import edu.cnm.deepdive.hush.service.HushDatabase;

public class UserRepository {

    private final HushDatabase database;
    private final Context context;

    public UserRepository(Context context) {
      this.context = context;
      database = HushDatabase.getInstance();
      //TODO Connect to Doa's
    }

    //TODO Create methods that invoke dao methods.
}
