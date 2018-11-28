package com.dgrdm9.menulist.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.dgrdm9.menulist.Adapters.EventoAdapter;
import com.dgrdm9.menulist.Models.Evento;
import com.dgrdm9.menulist.R;
import com.dgrdm9.menulist.Utilities.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForthFragment extends Fragment {

    private ListView listView;
    private List<Evento> eventoList;
    private EventoAdapter listAdapter;
    private ImageView imageView;

    public ForthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forth, container, false);
        imageView = v.findViewById(R.id.forthImage);
        Picasso.get().load(R.drawable.ibmpc).fit().centerCrop().into(imageView);
        eventoList = new ArrayList<>();
        listView = v.findViewById(R.id.listView4);
        eventoList = Util.setForthEventos();
        listAdapter = new EventoAdapter(getContext(), R.layout.list_item, eventoList);
        listView.setAdapter(listAdapter);
        return v;
    }

}
