package com.tema7.tema7ejemplo1.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tema7.tema7ejemplo1.Activities.MainActivity;
import com.tema7.tema7ejemplo1.Interfaces.OnPersonCreated;
import com.tema7.tema7ejemplo1.Models.Country;
import com.tema7.tema7ejemplo1.Models.Person;
import com.tema7.tema7ejemplo1.R;
import com.tema7.tema7ejemplo1.Utils.Util;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */


   public class FirstFragment extends Fragment {
    private ArrayList<Country> mCountryList;
    private List<Country> countries;
    private EditText editTextName;
    private  Spinner spinner_countries;
    private Button btnCreate;
    private OnPersonCreated onPersonCreated;
        public FirstFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_first,container, false);
            editTextName = (EditText) view.findViewById(R.id.editText);
            spinner_countries = (Spinner) view.findViewById(R.id.spinner_countries);
            btnCreate = (Button) view.findViewById(R.id.buttonCreate);
            btnCreate.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    createNewPerson();
                }
            });

            countries = Util.getCountries();


            ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(getContext(),android.R.layout.simple_spinner_dropdown_item,countries);
            spinner_countries.setAdapter(adapter);
            return view;
        }

        private  void createNewPerson(){
            boolean rep=false;
            for (Person per: SecondFragment.getPersons()
                 ) {
                if (editTextName.getText().toString().equalsIgnoreCase(per.getName())){
                    rep=true;
            }

            }

            if (!editTextName.getText().toString().isEmpty()&& !rep){
                 Toast.makeText(getActivity(),"Creando Persona",Toast.LENGTH_SHORT).show();
                 String nombre =  editTextName.getText().toString();
                 Country country = (Country)spinner_countries.getSelectedItem();
                 Person person= new Person(nombre, country);
                 onPersonCreated.createPerson(person);

            }
        }


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnPersonCreated){
            onPersonCreated = (OnPersonCreated) context;
        }else{
            throw new RuntimeException(context.toString()+" implementa OnPerson...");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onPersonCreated = null;
    }


}
