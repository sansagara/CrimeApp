package com.leonel.crimeapp.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.leonel.crimeapp.R;
import com.leonel.crimeapp.adapters.CrimeHistoryAdapter;
import com.leonel.crimeapp.models.PrecCrimen;
import com.leonel.crimeapp.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * PrecCrimen Fragment
 *
 * @author APIPlug
 * @version v1.0
 */
public class ViewHistory extends Fragment {


    private List<PrecCrimen> prec_crimen;
    private ListView listView;


    public ViewHistory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewHistory newInstance() {
        ViewHistory fragment = new ViewHistory();
        Bundle args = new Bundle();
        //If your fragment needs params add them in here
        //args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //If your fragment needs params add them in here
            //mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_history, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        getPrecCrimenList();

        return view;
    }


    private void getPrecCrimenList() {
        final ProgressDialog loading = ProgressDialog.show(getActivity(), getContext().getString(R.string.loading_title), getContext().getString(R.string.loading_please_wait), false, false);

        Call<List<PrecCrimen>> call = ApiClient.get().getPrecCrimen();

        call.enqueue(new Callback<List<PrecCrimen>>() {
            @Override
            public void onFailure(Call<List<PrecCrimen>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

                loading.dismiss();
            }

            @Override
            public void onResponse(Call<List<PrecCrimen>> call, Response<List<PrecCrimen>> response) {
                Log.d("APIPlug", "Successfully response fetched");

                loading.dismiss();

                prec_crimen = response.body();

                if (prec_crimen.size() > 0) {
                    showList();
                } else {
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

    //Our method to show list
    private void showList() {
        Log.d("APIPlug", "Show List");

        CrimeHistoryAdapter adapter = new CrimeHistoryAdapter(getActivity(), prec_crimen);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PrecCrimen clickedObj = (PrecCrimen) parent.getItemAtPosition(position);

                //Detail Activity
                /*
                Intent detail = new Intent(getContext(), PrecCrimenDetail.class);
                detail.putExtra("prec_crimenObject", clickedObj);
                startActivity(detail);
                */
            }
        });

    }


}
