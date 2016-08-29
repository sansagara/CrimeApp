package com.leonel.crimeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.leonel.crimeapp.R;
import com.leonel.crimeapp.models.PrecHistory;

import java.util.List;

/**
 * Custom ArrayAdapter Consolidated Adapter for displaying list items in listview
 *
 * @author API Plug
 * @version v1.0
 */
public class HistoryAdapter extends ArrayAdapter<PrecHistory> {

    public HistoryAdapter(Context context, List<PrecHistory> prec_history) {
        super(context, 0, prec_history);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        PrecHistory prec_history = getItem(position);

        ViewHolder viewHolder; //check for cache
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_history, parent, false);
            viewHolder.tipo_categoria = (TextView) convertView.findViewById(R.id.tipo_categoria);
            viewHolder.fecha = (TextView) convertView.findViewById(R.id.fecha);
            viewHolder.estado = (TextView) convertView.findViewById(R.id.estado);
            viewHolder.municipio = (TextView) convertView.findViewById(R.id.municipio);
            viewHolder.parroquia = (TextView) convertView.findViewById(R.id.parroquia);
            viewHolder.direccion = (TextView) convertView.findViewById(R.id.direccion);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status);
            viewHolder.descripcion = (TextView) convertView.findViewById(R.id.descripcion);
            viewHolder.lat_lng = (TextView) convertView.findViewById(R.id.lat);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the prec_crimen object
        viewHolder.tipo_categoria.setText(prec_history.getCategoria() + " : " + prec_history.getNombre());
        viewHolder.fecha.setText(prec_history.getFecha());
        viewHolder.estado.setText(prec_history.getEstado());
        viewHolder.municipio.setText(prec_history.getMunicipio());
        viewHolder.parroquia.setText(prec_history.getParroquia() + "");
        viewHolder.direccion.setText(prec_history.getDireccion());
        viewHolder.status.setText(prec_history.getStatus());
        viewHolder.descripcion.setText(prec_history.getDescripcion() + "");
        viewHolder.lat_lng.setText(Double.toString(prec_history.getLat()) + ", " + Double.toString(prec_history.getLng()));

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
        TextView tipo_categoria;
        TextView fecha;
        TextView estado;
        TextView municipio;
        TextView parroquia;
        TextView direccion;
        TextView status;
        TextView descripcion;
        TextView lat_lng;
    }
}
