package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //getting links to the button and EditText element
        EditText editNumber = findViewById(R.id.editText);
        Button confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(v -> { //setting listener on the confirm button by the View.setOnClickListener() method

            String text = editNumber.getText().toString(); //read field information
            Intent intent = new Intent(); //create an empty intent
            intent.putExtra("result", text); //add data to the intent
            setResult(RESULT_OK, intent); //result settings
            finish(); // finish the activity
        });
    }
}
