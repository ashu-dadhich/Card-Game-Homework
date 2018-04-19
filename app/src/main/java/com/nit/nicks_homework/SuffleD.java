package com.nit.nicks_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import card_pack.Constants;

import static com.nit.nicks_homework.MainActivity.cardDeck;

public class SuffleD extends AppCompatActivity {

    static boolean isDeckSuffled=false;
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suffle_d);
        final Button suffleDeck=(Button) findViewById(R.id.suffledeck);
        Button next=(Button) findViewById(R.id.next1);
        final EditText noOfSuffles=(EditText) findViewById(R.id.numOfSuffles);
        final TextView textView=(TextView) findViewById(R.id.cardDisplayAfterSuffle);

        suffleDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed_text = noOfSuffles.getText().toString().trim();
                if(!TextUtils.isEmpty(ed_text)){
                    n= Integer.parseInt(noOfSuffles.getText().toString());
                    if(n>0){
                        Log.d("ashu",""+n);
                        cardDeck.shuffle(n);
                        Log.d("ashu","after suffle:"+cardDeck.toString());
                        textView.setText(Constants.encoding+"\nDeck After Suffle:\n"+cardDeck.toString());
                        textView.setVisibility(View.VISIBLE);
                        suffleDeck.setVisibility(View.GONE);
                        noOfSuffles.setVisibility(View.GONE);
                        isDeckSuffled=true;
                    }else{
                        Toast.makeText(SuffleD.this, "Number should be positive", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SuffleD.this, "Please Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDeckSuffled){
                    Intent intent=new Intent(SuffleD.this,EnterNoOfPlayers.class);
                    startActivity(intent);
                }
            }
        });
    }
}
