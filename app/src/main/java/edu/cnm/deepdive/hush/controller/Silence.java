package edu.cnm.deepdive.hush.controller;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.hush.R;

public class Silence extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    audio.setRingerMode(0);
  }
}
