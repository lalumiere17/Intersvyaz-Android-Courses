package com.example.sveta.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "First Application";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        CharSequence text = "30 minutes past";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "Выполнился метод onCreate");

        Button buttonBattery = findViewById(R.id.buttonBattery);
        buttonBattery.setOnClickListener(buttonBatteryListener);

        Button buttonLocation = findViewById(R.id.buttonLocation);
        buttonLocation.setOnClickListener(buttonLocationListener);

        Button buttonAPI = findViewById(R.id.buttonAPI);
        buttonAPI.setOnClickListener(buttonAPIListener);
    }

    View.OnClickListener buttonBatteryListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, BatteryActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener buttonLocationListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, LocationActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener buttonAPIListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, APIActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Выполнился метод onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Выполнился метод onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Выполнился метод onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Выполнился метод onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Выполнился метод onPause");
    }

}
