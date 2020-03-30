package edu.cnm.deepdive.hush.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.hush.model.entity.User;
import edu.cnm.deepdive.hush.model.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;

public class MainViewModel extends AndroidViewModel {

  private final UserRepository userRepository;
  private final MutableLiveData<Set<String>> permissions;
  private final MutableLiveData<Throwable> throwable;

  public MainViewModel(@NonNull Application application) {
    super(application);
    userRepository = new UserRepository(application);
    permissions = new MutableLiveData<>(new HashSet<>());
    throwable = new MutableLiveData<>();
  }

  public LiveData<Set<String>> getPermissions() {
    return permissions;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void grant(String permission) {
    Set<String> permissions = this.permissions.getValue();
    if (permissions.add(permission)) {
      this.permissions.setValue(permissions);
    }
  }

  public void revoke(String permission) {
    Set<String> permissions = this.permissions.getValue();
    if (permissions.remove(permission)) {
      this.permissions.setValue(permissions);
    }
  }
}
