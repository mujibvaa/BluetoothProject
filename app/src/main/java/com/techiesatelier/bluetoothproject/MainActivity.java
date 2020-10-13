package com.techiesatelier.bluetoothproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

    }



    public void enablebluetooth(View view) {

        if (bluetoothAdapter != null) {

            Toast.makeText(this, "Supported", Toast.LENGTH_SHORT).show();

            if (!bluetoothAdapter.isEnabled()) {

                Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(i, 1);


            }
        } else {
            Toast.makeText(this, "Not Supported", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1) {


            if (requestCode == RESULT_OK){


                Toast.makeText(this,"Turned On",Toast.LENGTH_SHORT).show();


            }


            if (requestCode == RESULT_CANCELED){

                Toast.makeText(this,"Not On",Toast.LENGTH_SHORT).show();
            }
        }
    }







    public void disablebluetooth(View view){


    }
}