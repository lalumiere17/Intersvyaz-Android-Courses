package com.example.sveta.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battery);
        Context context = getApplicationContext();

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        TextView textCharging = (TextView) findViewById(R.id.chargingStatus);
        TextView textPercent = (TextView) findViewById(R.id.batteryStatus);
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING;
        if (isCharging == true)
        {
            textCharging.setText("Charging");
        }
        else
        {
            textCharging.setText("Not charging");
        }
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        textPercent.setText(String.valueOf((level / (float) scale)*100)+"%");
    }


}
