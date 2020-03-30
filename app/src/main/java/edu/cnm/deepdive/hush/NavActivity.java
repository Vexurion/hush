package edu.cnm.deepdive.hush;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import edu.cnm.deepdive.hush.controller.PermissionsFragment;
import edu.cnm.deepdive.hush.service.LocationMonitorService;
import edu.cnm.deepdive.hush.viewmodel.MainViewModel;
import java.util.LinkedList;
import java.util.List;

public class NavActivity extends AppCompatActivity implements PermissionsFragment.OnAcknowledgeListener {

  private AppBarConfiguration appBarConfiguration;
  private static final int LOCATION_SERVICE_REQUEST_CODE = 200;
  private static final int PERMISSIONS_REQUEST_CODE = 100;
  private MainViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    checkPermissions();
    scheduleService();
    setContentView(R.layout.activity_nav);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    NavigationView navigationView = findViewById(R.id.nav_view);
    appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.nav_home, R.id.nav_location_list, R.id.nav_history)
        .setDrawerLayout(drawer)
        .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.nav, menu);
    return true;
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
        || super.onSupportNavigateUp();
  }

  @Override
  public void onAcknowledge(String[] permissionsToRequest) {
    ActivityCompat.requestPermissions(this, permissionsToRequest, PERMISSIONS_REQUEST_CODE);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == PERMISSIONS_REQUEST_CODE) {
      for (int i = 0; i < permissions.length; i++) {
        String permission = permissions[i];
        int result = grantResults[i];
        if (result == PackageManager.PERMISSION_GRANTED) {
          viewModel.grant(permission);
        } else {
          viewModel.revoke(permission);
        }
      }
    } else {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
  }

  private void scheduleService(){
    AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(getApplicationContext(), LocationMonitorService.class);
    PendingIntent pending = PendingIntent.getService(getApplicationContext(), LOCATION_SERVICE_REQUEST_CODE, intent, 0);
    manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60_000, pending);
  }

  private void checkPermissions() {
    String[] permissions = null;
    try {
      PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),
          PackageManager.GET_META_DATA | PackageManager.GET_PERMISSIONS);
      permissions = info.requestedPermissions;
    } catch (NameNotFoundException e) {
      throw new RuntimeException(e);
    }
    List<String> permissionsToRequest = new LinkedList<>();
    List<String> permissionsToExplain = new LinkedList<>();
    for (String permission : permissions) {
      if (ContextCompat.checkSelfPermission(this, permission)
          != PackageManager.PERMISSION_GRANTED) {
        permissionsToRequest.add(permission);
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
          permissionsToExplain.add(permission);
        }
      } else {
        viewModel.grant(permission);
      }
    }
    if (!permissionsToExplain.isEmpty()) {
      explainPermissions(
          permissionsToExplain.toArray(new String[0]), permissionsToRequest.toArray(new String[0]));
    } else if (!permissionsToRequest.isEmpty()) {
      onAcknowledge(permissionsToRequest.toArray(new String[0]));
    }
  }

  private void explainPermissions(String[] permissionsToExplain, String[] permissionsToRequest) {
    PermissionsFragment fragment =
        PermissionsFragment.createInstance(permissionsToExplain, permissionsToRequest);
    fragment.show(getSupportFragmentManager(), fragment.getClass().getName());
  }

}
