package com.example.tpintegrador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.widget.Toast;

public class UsbActivado extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_STATE");
        boolean conectado=(intent.getExtras().getBoolean("connected"));

        if (conectado) {
            Toast.makeText(context, "Telefono conectado mediante USB, llamando a emergencias", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:" + "2664583060"));

            context.startActivity(i);
        }
        else {
            Toast.makeText(context, "No se puede realizar la llamada", Toast.LENGTH_LONG).show();
        }

    }

}
