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
import com.leonel.crimeapp.models.PrecHistory;
import com.leonel.crimeapp.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewMap extends Fragment implements OnMapReadyCallback {

    private List<PrecHistory> prec_history;

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
        getPrecHistoryList(mMap);
    }

    private void getPrecHistoryList(final GoogleMap mMap) {
        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Loading", "Please wait for the load", false, false);

        Call<List<PrecHistory>> call = ApiClient.get().getPrecHistory();

        call.enqueue(new Callback<List<PrecHistory>>() {
            @Override
            public void onFailure(Call<List<PrecHistory>> call, Throwable t) {
                Log.d("REST", "Error Occurred: " + t.getMessage());
                loading.dismiss();
            }

            @Override
            public void onResponse(Call<List<PrecHistory>> call, Response<List<PrecHistory>> response) {
                Log.d("REST", "Successfully response fetched");
                loading.dismiss();

                prec_history = response.body();

                if (prec_history.size() > 0) {
                    Log.d("REST", prec_history.toString());


                    for (int i = 0; i < prec_history.size(); i++) {
                        PrecHistory item = prec_history.get(i);
                        // Add markers.
                        LatLng marker = new LatLng(item.getLat(), item.getLng());
                        if (item.getIcono().equals("N/A")) {
                            mMap.addMarker(new MarkerOptions().position(marker).title(item.getNombre()).icon(BitmapDescriptorFactory.fromResource(R.drawable.base)));
                        } else {
                            mMap.addMarker(new MarkerOptions().position(marker).title(item.getNombre()).icon(BitmapDescriptorFactory.fromResource(getResources().getIdentifier(item.getIcono(), "drawable", getActivity().getApplicationContext().getPackageName()))));
                        }
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
