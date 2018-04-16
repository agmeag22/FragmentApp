package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */


public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{
    private Planet[] planets;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        String[] pname = getResources().getStringArray(R.array.Planets);
        String[] pradius = getResources().getStringArray(R.array.Planets_radius);
        String[] pgravity = getResources().getStringArray(R.array.Planets_gravity);
        String[] pmass = getResources().getStringArray(R.array.Planets_Mass);
        planets = new Planet[getResources().getStringArray(R.array.Planets).length];
        TypedArray pimage=getResources().obtainTypedArray(R.array.images);
        for (int n=0; n<getResources().getStringArray(R.array.Planets).length;n++ ) {
        planets[n]=new Planet(pname[n],pradius[n],pgravity[n],pmass[n],pimage.getResourceId(n,0));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND);
            newIntent.setType("*/*");
            Bundle bundle=new Bundle();
            bundle.putSerializable("PLANET",planets[i]);
            newIntent.putExtras(bundle);
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            Bundle bundle = new Bundle();
            bundle.putSerializable("PLANET", planets[i]);
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
