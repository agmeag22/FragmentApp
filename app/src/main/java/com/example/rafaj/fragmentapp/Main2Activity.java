package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ImageView view_image;
    TextView text_name;
    TextView text_radius;
    TextView text_gravity;
    TextView text_mass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        view_image = findViewById(R.id.image);
        text_name = findViewById(R.id.name);
        text_radius = findViewById(R.id.radius);
        text_gravity = findViewById(R.id.gravity);
        text_mass = findViewById(R.id.mass);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null){

                handleReceivedText(callingIntent);

        }

    }

    private void handleReceivedText(Intent intent){
        Bundle bundle = intent.getExtras();
        Planet intentText = (Planet) bundle.getSerializable("PLANET");

        if (text_name != null){
            view_image.setImageResource(intentText.getImage());
            text_name.setText(intentText.getName());
            text_radius.setText(intentText.getSize());
            text_gravity.setText(intentText.getGravity());
            text_mass.setText(intentText.getMass());
            Log.d("hola", String.valueOf(text_name));

        }
    }
}
