/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;


import java.util.Locale;

/** Main {@code Activity} class for the Camera app. */
public class CameraActivity extends Activity {

  public static TextToSpeech myTTS;
  private SpeechRecognizer mySpeechRecognizer;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);
    if (null == savedInstanceState) {
      getFragmentManager()
          .beginTransaction()
          .replace(R.id.container, Camera2BasicFragment.newInstance())
          .commit();
    }
    initializeTextToSpeech();
  }

  private void initializeTextToSpeech() {
    myTTS=new TextToSpeech(this, new TextToSpeech.OnInitListener(){
      @Override
      public void onInit(int status) {
        if(myTTS.getEngines().size()==0){
          Toast.makeText(CameraActivity.this,"No TTS Engine", Toast.LENGTH_LONG).show();
          finish();
        }           else {
          myTTS.setLanguage(Locale.ENGLISH);
          speak("Welcome to Netra");
        }
      }

    });
  }

  public static void speak(String s) {
    if(Build.VERSION.SDK_INT >= 21){
      myTTS.speak(s,TextToSpeech.QUEUE_FLUSH,null,null);

    }else{
      myTTS.speak(s,TextToSpeech.QUEUE_FLUSH,null);
    }
  }

  public  void speak2(String s) {
    if(Build.VERSION.SDK_INT >= 21){
      myTTS.speak(s,TextToSpeech.QUEUE_FLUSH,null,null);

    }else{
      myTTS.speak(s,TextToSpeech.QUEUE_FLUSH,null);
    }
  }


  public void  convert(View v){
      startActivity(new Intent(CameraActivity.this, ExchangeRate.class));
    }



}

