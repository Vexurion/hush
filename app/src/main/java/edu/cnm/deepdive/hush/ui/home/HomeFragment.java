package edu.cnm.deepdive.hush.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import edu.cnm.deepdive.hush.R;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

  private HomeViewModel homeViewModel;
  private GoogleMap map;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    homeViewModel =
        ViewModelProviders.of(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);
    SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
        .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);

    return root;
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    map = googleMap;
    // Add a marker in Sydney and move the camera
    LatLng sydney = new LatLng(-34, 151);
    map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
    map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
  }

}