package com.nit.nicks_homework;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import card_pack.Cards;
import card_pack.Constants;

import static com.nit.nicks_homework.MainActivity.cardDeck;

public class PlayerList extends AppCompatActivity {
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    public boolean isHandDealt=false;
    public Cards[][] playerCardList=new Cards[Constants.numPlayers][5];
    public boolean oneTimeFlag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        mainListView=(ListView) findViewById(R.id.mainListView);
        final Button button=(Button) findViewById(R.id.deal);
        final Button restart=(Button) findViewById(R.id.Restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayerList.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!oneTimeFlag){
                    for(int i=0;i<Constants.numPlayers;i++){
                        for(int j=0;j<5;j++){
                            playerCardList[i][j]=cardDeck.deal();
                        }
                    }
                    isHandDealt=true;
                    oneTimeFlag=true;
                    restart.setVisibility(View.VISIBLE);
                    Toast.makeText(PlayerList.this, "Cards Dealt select each player to select their cards",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(PlayerList.this, "Dealing is only allowed once", Toast.LENGTH_SHORT).show();
                }

            }
        });
        String[] playerL=new String[Constants.numPlayers];
        for(int i=0;i< Constants.numPlayers;i++){
            playerL[i]="Player "+(i+1);
        }
        ArrayList<String> playerList=new ArrayList<String>();
        playerList.addAll(Arrays.asList(playerL));
        listAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, playerList);
        mainListView.setAdapter(listAdapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(isHandDealt){
                    AlertDialog.Builder builder=new AlertDialog.Builder(PlayerList.this);
                    builder.setTitle("Player has the following cards");
                    String s = "";
                    for ( int i = 0; i < 5; i++ ){
                        s+=playerCardList[position][i]+" ";
                    }
                    builder.setMessage(s)
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    AlertDialog buiDialog=builder.create();
                    buiDialog.show();
                }else {
                    Toast.makeText(PlayerList.this, "Please Deal hand first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
