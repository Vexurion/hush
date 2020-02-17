package edu.cnm.deepdive.hush.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.hush.model.entity.Hush;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Dao
public interface HushDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Hush hush);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Hush> hushes);
  //Question on whether this inserts a list of hushes?

  @Update
  Single<Integer> update(Hush hush);

  @Delete
  Single<Integer> delete(Hush... hushes);

  @Query("SELECT * FROM Hush WHERE date = :date")
  Maybe<Hush> select(Date date);

  @Query("SELECT * FROM Hush ORDER BY longitude_id = :longitude_id")
  LiveData<List<Hush>> select(double longitude_id);

}