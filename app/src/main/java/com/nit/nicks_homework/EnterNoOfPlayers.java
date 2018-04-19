package com.nit.nicks_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import card_pack.Constants;

public class EnterNoOfPlayers extends AppCompatActivity {
    //private boolean isPlayerValueEntere=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_no_of_players);
        final EditText editText=(EditText) findViewById(R.id.numPlayers);
        Button button=(Button) findViewById(R.id.next2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed_text = editText.getText().toString().trim();
                if(!TextUtils.isEmpty(ed_text)){
                    Constants.numPlayers=Integer.parseInt(editText.getText().toString());
                    int temp=Constants.numPlayers*5;
                    if(Constants.numPlayers>0 && temp<=52){
                        Intent intent=new Intent(EnterNoOfPlayers.this,PlayerList.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(EnterNoOfPlayers.this, "Num of player either too low or too high",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
