package com.dgrdm9.menulist.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
public class PrehFragment extends Fragment {

    private ListView listView;
    private List<Evento> eventoList;
    private EventoAdapter listAdapter;
    private ImageView imageView;

    public PrehFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_preh, container, false);
        imageView = v.findViewById(R.id.prehImage);
        Picasso.get().load(R.drawable.babbage).fit().centerCrop().into(imageView);
        eventoList = new ArrayList<>();
        listView = v.findViewById(R.id.listView0);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                imageView.setVisibility(View.GONE);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if(i == 0) imageView.setVisibility(View.VISIBLE);
            }
        });
        eventoList = Util.setPrehEventos();
        listAdapter = new EventoAdapter(getContext(), R.layout.list_item, eventoList);
        listView.setAdapter(listAdapter);
        return v;
    }

}
