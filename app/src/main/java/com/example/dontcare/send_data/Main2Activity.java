package com.example.dontcare.send_data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView T;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        T = findViewById(R.id.call);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if(Intent.ACTION_SEND.equals(intentAction) && intentType != null){
            if(intentType.equals("text/plain")){
                handleReceivedText(callingIntent);
            }
        }
    }

    private void handleReceivedText(Intent intent){
        String intentText = intent.getStringExtra(Intent.EXTRA_TEXT);

        if(T != null){
            T.setText(intentText);
        }
    }


}
