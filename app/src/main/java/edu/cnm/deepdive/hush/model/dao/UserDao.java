package edu.cnm.deepdive.hush.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.hush.model.entity.User;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {

 @Insert
 Single<Long> insert(User user);

 @Insert
 Single<List<Long>> insert(Collection<User> users);

 @Delete
 Single<Integer> delete(User user);

 @Delete
 Single<Integer> delete(Collection<User> users);

 @Query("SELECT * FROM User ORDER BY user_id ASC")
 LiveData<List<User>> getAllId();

 @Query("SELECT * FROM User WHERE oauth_key = :oauthKey")
 Maybe<User> getByOauth(String oauthKey);


}