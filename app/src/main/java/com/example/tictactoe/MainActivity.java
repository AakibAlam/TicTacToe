package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    char[] gameState = {'0','0','0','0','0','0','0','0','0'};
    int[][] winningPosition = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}


    };
    public void tapped(View view){
         ImageView tap = (ImageView) view;
           int id = Integer.parseInt(tap.getTag().toString());
         if(gameState[id]!='0'){
             Toast.makeText(this, "please, select a valid position", Toast.LENGTH_SHORT).show();
         }
         else{
             if(activePlayer==0){
                 gameState[id] = 'O';
                 tap.setImageResource(R.drawable.o);

             }
             else{
                 gameState[id] = 'X';
                 tap.setImageResource(R.drawable.x);

             }
             for(int i=0;i<8;i++){
                 if(gameState[winningPosition[i][0]]==gameState[winningPosition[i][1]] &&
                         gameState[winningPosition[i][0]]==gameState[winningPosition[i][2]] &&
                         gameState[winningPosition[i][0]]!='0'){

                     if(gameState[winningPosition[i][0]]=='O'){
                         Toast.makeText(this, "O wins the game!! ", Toast.LENGTH_SHORT).show();
                     }
                   else{
                         Toast.makeText(this, "X wins the game!! ", Toast.LENGTH_SHORT).show();
                     }
                     gameReset();
                 }
             }
             activePlayer ^= 1;
         }
    }

    void gameReset(){
        for(int i=0;i<9;i++){
            gameState[i] = '0';
        }
        ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView19)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView20)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
