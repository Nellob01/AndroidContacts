package com.example.noelaniekan.androidcontacts;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name;
    EditText phone;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        name = (EditText) findViewById(R.id.editText2);
        phone = (EditText) findViewById(R.id.editText);

        String S = getIntent().getExtras().getString("contacts");
        String linepart[] = S.split(" : ");
        name.setText(linepart[0]);
        phone.setText(linepart[1]);
        position = getIntent().getExtras().getInt("position", 0);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String item = name.getText().toString();
        String items = phone.getText().toString();
        String contacts = (item + " : " + items);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("contacts", contacts);
        returnIntent.putExtra("position", position);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();


    }

}
