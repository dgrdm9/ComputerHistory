package com.dgrdm9.menulist.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dgrdm9.menulist.Models.Evento;
import com.dgrdm9.menulist.R;

import java.util.List;

public class EventoAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Evento> eventoList;

    public EventoAdapter(Context context, int layout, List<Evento> eventoList) {
        this.context = context;
        this.layout = layout;
        this.eventoList = eventoList;
    }

    @Override
    public int getCount() {
        return this.eventoList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.eventoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(layout, null);

            holder = new ViewHolder();
            holder.textViewFecha = view.findViewById(R.id.textViewFecha);
            holder.textViewDescripcion = view.findViewById(R.id.textViewDecripcion);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Evento currentEvento = eventoList.get(i);

        holder.textViewFecha.setText(currentEvento.getFecha());
        holder.textViewDescripcion.setText(currentEvento.getDescripcion());

        return view;
    }

    static class ViewHolder {
        private TextView textViewFecha;
        private TextView textViewDescripcion;
    }
}
