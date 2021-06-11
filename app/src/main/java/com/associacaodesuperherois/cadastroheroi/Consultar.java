package com.associacaodesuperherois.cadastroheroi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Consultar extends AppCompatActivity {
    ListView listaherois;
    SQLiteDatabase db;
    ArrayList<Heroi> herois = new ArrayList<>();
    ArrayAdapter<Heroi> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        getSupportActionBar().setTitle("Consultar Heróis");
        listaherois = findViewById(R.id.listViewLista);

        herois.clear();

        db = openOrCreateDatabase(
                Banco.banco(),
                Context.MODE_PRIVATE,
                null
        );

        Cursor dados = db.rawQuery(
                "SELECT * FROM " + Banco.tabela() + " ORDER BY nomeheroi ASC",
                null
        );

        while(dados.moveToNext()){
            herois.add(new Heroi(
                    dados.getInt(0),
                    dados.getString(1),
                    dados.getString(2),
                    dados.getString(3),
                    dados.getString(4),
                    dados.getString(5),
                    dados.getString(6)
            ));

            adaptador = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, herois);

            listaherois.setAdapter(adaptador);

            listaherois.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Heroi dados = (Heroi) listaherois.getItemAtPosition(position);
                    Intent detalhes = new Intent(getApplicationContext(),Detalhes.class);
                    detalhes.putExtra("dados",dados);
                    startActivity(detalhes);
                }
            });
        }
    }
}