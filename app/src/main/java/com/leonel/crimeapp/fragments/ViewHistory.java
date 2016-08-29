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
import com.leonel.crimeapp.adapters.HistoryAdapter;
import com.leonel.crimeapp.models.PrecHistory;
import com.leonel.crimeapp.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * History Fragment. Consolidated view of crimes and events.
 *
 * @author APIPlug
 * @version v1.0
 */
public class ViewHistory extends Fragment {


    private List<PrecHistory> prec_history;
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

        getPrecHistoryList();

        return view;
    }


    private void getPrecHistoryList() {
        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Loading", "Please wait while we load data", false, false);

        Call<List<PrecHistory>> call = ApiClient.get().getPrecHistory();

        call.enqueue(new Callback<List<PrecHistory>>() {
            @Override
            public void onFailure(Call<List<PrecHistory>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

                loading.dismiss();
            }

            @Override
            public void onResponse(Call<List<PrecHistory>> call, Response<List<PrecHistory>> response) {
                Log.d("APIPlug", "Successfully response fetched");

                loading.dismiss();

                prec_history = response.body();

                if (prec_history.size() > 0) {
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

        HistoryAdapter adapter = new HistoryAdapter(getActivity(), prec_history);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PrecHistory clickedObj = (PrecHistory) parent.getItemAtPosition(position);

                //Detail Activity
                /*
                Intent detail = new Intent(getContext(), PrecHistoryDetail.class);
                detail.putExtra("prec_historyObject", clickedObj);
                startActivity(detail);
                */
            }
        });

    }


}
