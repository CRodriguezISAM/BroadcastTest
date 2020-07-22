package com.zurdorod.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();
  NfcAdapter mAdapter;
  PendingIntent mPendingIntent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        final Intent i = new Intent();
        i.putExtra("dato", !TextUtils.isEmpty(((EditText) findViewById(R.id.edittext)).getText()) ? ((EditText) findViewById(R.id.edittext)).getText().toString() : "");
        /* Al cambiar el action a sidemu.denuncias.<nombre_broadcast> (el id de nuestra app) solo es posible recibirla en dicha app */
        i.setAction("pruebas.broadcast");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        MainActivity.this.sendBroadcast(i);
      }
    });

  }

}