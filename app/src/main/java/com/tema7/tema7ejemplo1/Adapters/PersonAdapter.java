package com.tema7.tema7ejemplo1.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tema7.tema7ejemplo1.Models.Person;
import com.tema7.tema7ejemplo1.R;
import java.util.List;

public class PersonAdapter extends BaseAdapter{
    /*private TextView viewNombre;
    private TextView viewPais;
    private ImageView image;*/
    private Context context;
    private int layout;
    public List<Person> persons;

public PersonAdapter(Context context, int layout, List<Person> persons) {
    this.context = context;
    this.layout = layout;
    this.persons = persons;

}


@Override
public int getCount(){
    return persons.size();
}


@Override
public Person getItem(int position){
    return persons.get(position);
}

@Override
public long getItemId(int id){
    return id;
}

@Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewNombre);
            holder.country = (TextView) convertView.findViewById(R.id.textViewPais);
            holder.image = (ImageView) convertView.findViewById(R.id.ImageBandera);
            convertView.setTag((holder));
        }else {

            holder = (ViewHolder) convertView.getTag();
        }
             Person currentPerson = getItem(position);
             holder.name.setText(currentPerson.getName());

             holder.country.setText(currentPerson.getCountry().getName());

             String url = currentPerson.getCountry().getFlagURL();
             Picasso.get().load(url).fit().into(holder.image);




    return convertView;
}
static class ViewHolder{
    private TextView name;
    private TextView country;
    private ImageView image;
}

}



