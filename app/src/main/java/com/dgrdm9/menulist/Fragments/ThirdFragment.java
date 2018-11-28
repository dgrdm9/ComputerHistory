package com.dgrdm9.menulist.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dgrdm9.menulist.Adapters.EventoAdapter;
import com.dgrdm9.menulist.Models.Evento;
import com.dgrdm9.menulist.R;
import com.dgrdm9.menulist.Utilities.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    private ListView listView;
    private List<Evento> eventoList;
    private EventoAdapter listAdapter;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        eventoList = new ArrayList<>();
        listView = v.findViewById(R.id.listView3);
        eventoList = Util.setThirdEventos();
        listAdapter = new EventoAdapter(getContext(), R.layout.list_item, eventoList);
        listView.setAdapter(listAdapter);
        return v;
    }

}
