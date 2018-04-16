package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    ImageView view_image;
    TextView text_name;
    TextView text_radius;
    TextView text_gravity;
    TextView text_mass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        view_image = view.findViewById(R.id.image);
        text_name = view.findViewById(R.id.name);
        text_radius = view.findViewById(R.id.radius);
        text_gravity = view.findViewById(R.id.gravity);
        text_mass = view.findViewById(R.id.mass);

        Bundle bundle = this.getArguments();


        Planet intentText = (Planet) bundle.getSerializable("PLANET");

        if (bundle != null){
            view_image.setImageResource(intentText.getImage());
            text_name.setText(intentText.getName());
            text_radius.setText(intentText.getSize());
            text_gravity.setText(intentText.getGravity());
            text_mass.setText(intentText.getMass());
            Log.d("hola", String.valueOf(text_name));

        }

        return view;
    }


}
