package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;//code of the window

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting links to the buttons
        Button button1 = findViewById(R.id.buttonActF);
        Button button2 = findViewById(R.id.buttonActS);

        button1.setOnClickListener(l -> { //setting listener on the first button by the View.setOnClickListener() method
                    Intent intent = new Intent(this, SecondActivity.class);
                    startActivityForResult(intent, REQUEST_CODE); //context method for opening the activity
        });

        button2.setOnClickListener(l -> { //setting listener on the second button for realization of implicit intent
            Uri address = Uri.parse("https://opu.ua/"); //setting uri address
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address); //creating an intent with the override ACTION_VIEW action
            if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openLinkIntent);
            } else {
                Log.d("Intent", "Error!");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "User has gone out of the activity", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {

                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        TextView nameResult = findViewById(R.id.result);
                        nameResult.setText(text);
                    }
                }
            }
        }
    }
}
