package com.i022213.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.i022213.sqlite.Adapters.AdapterUser;
import com.i022213.sqlite.Data.DataUser;
import com.i022213.sqlite.Models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button create, listbtn;
    ListView lista;
    DataUser dataUser;
    List<User> userList;
    AdapterUser adapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        create = (Button) findViewById(R.id.id_btn_create);
        listbtn = (Button) findViewById(R.id.id_btn_list);
        lista = (ListView) findViewById(R.id.id_lv_mylist);
        dataUser = new DataUser(this);
        dataUser.open();


        userList = dataUser.findAll();
        adapterUser = new AdapterUser(getApplicationContext(), userList);
        lista.setAdapter(adapterUser);
    }

    public void SAccount(View view){
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }
}
