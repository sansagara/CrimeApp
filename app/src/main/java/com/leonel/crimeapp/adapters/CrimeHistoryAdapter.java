package com.leonel.crimeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.leonel.crimeapp.R;
import com.leonel.crimeapp.models.PrecCrimen;

import java.util.List;

/**
 * Custom ArrayAdapter PrecCrimen Adapter for displaying list items in listview
 *
 * @author API Plug
 * @version v1.0
 */
public class CrimeHistoryAdapter extends ArrayAdapter<PrecCrimen> {

    public CrimeHistoryAdapter(Context context, List<PrecCrimen> prec_crimen) {
        super(context, 0, prec_crimen);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        PrecCrimen prec_crimen = getItem(position);

        ViewHolder viewHolder; //check for cache
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_history_crime, parent, false);
            viewHolder.id_crimen = (TextView) convertView.findViewById(R.id.id_crimen);
            viewHolder.nu_lat = (TextView) convertView.findViewById(R.id.nu_lat);
            viewHolder.nu_long = (TextView) convertView.findViewById(R.id.nu_long);
            viewHolder.tx_obs = (TextView) convertView.findViewById(R.id.tx_obs);
            viewHolder.in_status_proc = (TextView) convertView.findViewById(R.id.in_status_proc);
            viewHolder.fe_crimen = (TextView) convertView.findViewById(R.id.fe_crimen);
            viewHolder.fe_proc = (TextView) convertView.findViewById(R.id.fe_proc);
            viewHolder.id_delito = (TextView) convertView.findViewById(R.id.id_delito);
            viewHolder.co_usr = (TextView) convertView.findViewById(R.id.co_usr);
            viewHolder.tx_movil = (TextView) convertView.findViewById(R.id.tx_movil);
            viewHolder.id_rut_esc = (TextView) convertView.findViewById(R.id.id_rut_esc);
            viewHolder.id_prq = (TextView) convertView.findViewById(R.id.id_prq);
            viewHolder.id_stat_crimen = (TextView) convertView.findViewById(R.id.id_stat_crimen);
            viewHolder.tx_direccion = (TextView) convertView.findViewById(R.id.tx_direccion);
            viewHolder.tx_descripcion = (TextView) convertView.findViewById(R.id.tx_descripcion);
            viewHolder.co_clima = (TextView) convertView.findViewById(R.id.co_clima);
            viewHolder.nu_temperatura = (TextView) convertView.findViewById(R.id.nu_temperatura);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the prec_crimen object
        viewHolder.id_crimen.setText(prec_crimen.getId_crimen() + "");
        viewHolder.nu_lat.setText(Double.toString(prec_crimen.getNu_lat()));
        viewHolder.nu_long.setText(Double.toString(prec_crimen.getNu_long()));
        viewHolder.tx_obs.setText(prec_crimen.getTx_obs());
        viewHolder.in_status_proc.setText(prec_crimen.getIn_status_proc());
        viewHolder.fe_crimen.setText(prec_crimen.getFe_crimen());
        viewHolder.fe_proc.setText(prec_crimen.getFe_proc());
        viewHolder.id_delito.setText(prec_crimen.getId_delito() + "");
        viewHolder.co_usr.setText(prec_crimen.getCo_usr());
        viewHolder.tx_movil.setText(prec_crimen.getTx_movil());
        viewHolder.id_rut_esc.setText(prec_crimen.getId_rut_esc() + "");
        viewHolder.id_prq.setText(prec_crimen.getId_prq() + "");
        viewHolder.id_stat_crimen.setText(prec_crimen.getId_stat_crimen() + "");
        viewHolder.tx_direccion.setText(prec_crimen.getTx_direccion());
        viewHolder.tx_descripcion.setText(prec_crimen.getTx_descripcion());
        viewHolder.co_clima.setText(prec_crimen.getCo_clima());
        viewHolder.nu_temperatura.setText(prec_crimen.getNu_temperatura());

        /*
        If your item has image you could load it dynamically with Picasso
        if(prec_crimen.getImagePath()!=""){
            Picasso.with(getContext())
                    .load(prec_crimen.getImagePath())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(viewHolder.imageView);
        }
        */

        // Return the completed view to render on screen
        return convertView;

    }

    private static class ViewHolder {
        TextView id_crimen;
        TextView nu_lat;
        TextView nu_long;
        TextView tx_obs;
        TextView in_status_proc;
        TextView fe_crimen;
        TextView fe_proc;
        TextView id_delito;
        TextView co_usr;
        TextView tx_movil;
        TextView id_rut_esc;
        TextView id_prq;
        TextView id_stat_crimen;
        TextView tx_direccion;
        TextView tx_descripcion;
        TextView co_clima;
        TextView nu_temperatura;

    }
}
