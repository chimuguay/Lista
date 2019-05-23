package com.omarpelcastre.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    String countryList[] = {"Mexico","New York","Chicago","Brazil","Chile"};
    public static Button btnAddCity;
    public static TextView textAddCity;
    public static Button editCityBtn;
    static ArrayList<String> lista = null;
    public static Adaptador adaptador = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAddCity = findViewById(R.id.btnAddCity);
        textAddCity = findViewById(R.id.textAddCity);
        editCityBtn = findViewById(R.id.editCityBtn);

        simpleList = (ListView) findViewById(R.id.simpleListView);
        lista = new ArrayList<>(Arrays.asList(countryList));

        /*

        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(MainActivity.this, R.layout.activity_listview,R.id.textView, lista);
        simpleList.setAdapter(arrayAdapter);

        */

        adaptador = new Adaptador(this, lista);

        lista.add("Peru");
        simpleList.setAdapter(adaptador);
        //arrayAdapter.notifyDataSetChanged();

        btnAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textAddCity.getText().toString();
                lista.add(name);
                adaptador.notifyDataSetChanged();
            }
        });

        editCityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.set(Adaptador.pos, textAddCity.getText().toString());
                adaptador.notifyDataSetChanged();
                editCityBtn.setVisibility(View.INVISIBLE);
            }
        });

    }

    public static void delete(int pos) {
        lista.remove(pos);
        adaptador.notifyDataSetChanged();


    }






}
