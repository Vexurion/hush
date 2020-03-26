package edu.cnm.deepdive.hush.service;
import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.hush.model.dao.HushDao;
import edu.cnm.deepdive.hush.model.dao.UserDao;
import edu.cnm.deepdive.hush.model.entity.Hush;
import edu.cnm.deepdive.hush.model.entity.User;
import edu.cnm.deepdive.hush.service.HushDatabase.Converters;
import java.util.Date;

@Database(
    entities ={Hush.class, User.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class HushDatabase extends RoomDatabase {

  private static final String DB_NAME = "hush_db";

  private static Application context;

  public abstract HushDao getHushDao();

  public abstract UserDao getUserDao();

  public static HushDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public static void setContext(Application context) {
    HushDatabase.context = context;
  }

  private static class InstanceHolder {

    private static final HushDatabase INSTANCE = Room.databaseBuilder(
        context, HushDatabase.class, DB_NAME)
        .build();
  }

  public static class Converters {

    @TypeConverter
    public static Long fromDate(Date date) {
      return (date != null) ? date.getTime() : null;
    }

    @TypeConverter
    public static Date fromLong(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }

}
