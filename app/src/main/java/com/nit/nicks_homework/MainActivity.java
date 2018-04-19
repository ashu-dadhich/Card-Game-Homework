package com.nit.nicks_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import card_pack.CardDeck;
import card_pack.Constants;

public class MainActivity extends AppCompatActivity {

    static boolean isDeckInit=false;
    public static CardDeck cardDeck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button init=(Button) findViewById(R.id.initdeck);
        Button next=(Button) findViewById(R.id.next);
        final TextView textView=(TextView) findViewById(R.id.cardDisplay);
        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cardDeck =new CardDeck();
                isDeckInit=true;
                Log.d("ashu",cardDeck.toString());
                textView.setText(Constants.encoding+"\nDeck Init:\n"+cardDeck.toString());
                textView.setVisibility(View.VISIBLE);
                init.setVisibility(View.GONE);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDeckInit){
                    Intent intent=new Intent(MainActivity.this,SuffleD.class);
                    startActivity(intent);
                }
            }
        });
    }
}
