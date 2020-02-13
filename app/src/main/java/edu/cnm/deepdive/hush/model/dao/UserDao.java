package edu.cnm.deepdive.hush.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.hush.model.entity.Hush;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Hush hush);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Hush> husher);

  @Update
  Single<Integer> update(Hush hush);

  @Delete
  Single<Integer> delete(Hush... husher);

  @Query("SELECT * FROM Hush ORDER BY date")
  LiveData<List<Hush>> select();
}
