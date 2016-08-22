package com.leonel.crimeapp.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.leonel.crimeapp.models.PrecCrimen;
import com.leonel.crimeapp.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewMap extends Fragment implements OnMapReadyCallback {

    private List<PrecCrimen> prec_crimen;

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
        getPrecCrimenList(mMap);
    }

    private void getPrecCrimenList(final GoogleMap mMap) {
        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Loading", "Please wait for the load", false, false);

        Call<List<PrecCrimen>> call = ApiClient.get().getPrecCrimen();

        call.enqueue(new Callback<List<PrecCrimen>>() {
            @Override
            public void onFailure(Call<List<PrecCrimen>> call, Throwable t) {
                Log.d("REST", "Error Occurred: " + t.getMessage());
                loading.dismiss();
            }

            @Override
            public void onResponse(Call<List<PrecCrimen>> call, Response<List<PrecCrimen>> response) {
                Log.d("REST", "Successfully response fetched");
                loading.dismiss();

                prec_crimen = response.body();

                if (prec_crimen.size() > 0) {
                    Log.d("REST", prec_crimen.toString());


                    for (int i = 0; i < prec_crimen.size(); i++) {
                        PrecCrimen crimen = prec_crimen.get(i);
                        // Add markers.
                        LatLng marker = new LatLng(crimen.getNu_lat(), crimen.getNu_long());
                        mMap.addMarker(new MarkerOptions().position(marker).title(crimen.getTx_movil()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

                    }

                    //Center Camera on Caracas
                    LatLng caracas = new LatLng(10.468553, -66.960406);
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(caracas, 10));


                } else {
                    Log.d("REST", "No item found");
                }
            }
        });
    }



}
