package com.tema7.tema7ejemplo1.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.tema7.tema7ejemplo1.Adapters.PersonAdapter;
import com.tema7.tema7ejemplo1.Models.Person;
import com.tema7.tema7ejemplo1.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
 static List<Person> persons;
private PersonAdapter adapter;
private ListView listView;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        persons= new ArrayList<Person>();
        adapter = new PersonAdapter(getContext(),R.layout.list_view_item,persons);
        listView = (ListView)view.findViewById(R.id.ListaPersonas);
        listView.setAdapter(adapter);
        return view;
    }


    public static List<Person> getPersons( ){
       return persons;
    }


    public void addPerson(Person person){
    persons.add(person);
    adapter.notifyDataSetChanged();
    }

}
