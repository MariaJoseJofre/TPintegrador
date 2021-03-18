package com.example.tpintegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private UsbActivado usbAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) ;

        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1004);

    }

    @Override
    protected void onResume() {
        super.onResume();
        usbAct = new UsbActivado();
        registerReceiver(usbAct, new IntentFilter("android.hardware.usb.action.USB_STATE"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(usbAct);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}