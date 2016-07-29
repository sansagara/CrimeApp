package com.leonel.crimeapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.leonel.crimeapp.R;

public class ViewMap extends Fragment implements OnMapReadyCallback {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_map, container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap mMap) {

        // Add markers.
        LatLng chacao = new LatLng(10.468553, -66.960406);
        mMap.addMarker(new MarkerOptions().position(chacao).title("Robo Simple en Chacao").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng petare = new LatLng(10.485408, -66.799761);
        mMap.addMarker(new MarkerOptions().position(petare).title("Asalto en Petare").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng guarenas = new LatLng(10.4708273, -66.6210537);
        mMap.addMarker(new MarkerOptions().position(guarenas).title("Saqueo en Guarenas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng candelaria = new LatLng(10.503625, -66.905279);
        mMap.addMarker(new MarkerOptions().position(candelaria).title("Secuestro en La Candelaria").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        //Center Camera on Caracas
        LatLng caracas = new LatLng(10.468553,-66.960406);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(caracas, 10));

    }
}
