package com.example.noelaniekan.androidcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    ArrayAdapter<String> contacts;

    ListView list;
    EditText text;
    EditText number;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.EditText);
        number = (EditText) findViewById(R.id.EditText2);
        addButton = (Button) findViewById(R.id.Button);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String item = text.getText().toString();
        String items = number.getText().toString();
        contacts.add(item + " " + items);
        text.setText(" ");
        number.setText(" ");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        String item = contacts.getItem(position);
        contacts.remove(item);
        return true;
    }
}
