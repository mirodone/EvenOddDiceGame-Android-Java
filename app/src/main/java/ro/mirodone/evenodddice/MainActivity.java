package ro.mirodone.evenodddice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import javax.crypto.spec.IvParameterSpec;

public class MainActivity extends AppCompatActivity {

    Button b_roll, b_even, b_odd;

    TextView tvPoints_cpu, tvPoints_you, tvStatus;

    ImageView iv_dice1, iv_dice2;

    int cpuPoints, playerPoints;

    String currentPick = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_roll = findViewById(R.id.btn_roll);
        b_even = findViewById(R.id.btn_even);
        b_odd = findViewById(R.id.btn_odd);

        tvPoints_cpu = findViewById(R.id.tv_cpu);
        tvPoints_you = findViewById(R.id.tv_player);
        tvStatus  = findViewById(R.id.tv_status);

        iv_dice1 = findViewById(R.id.dice_one);
        iv_dice2 = findViewById(R.id.dice_two);

        b_roll.setVisibility(View.INVISIBLE);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int firstDice = random.nextInt(6)+1;
                int secondDice = random.nextInt(6)+1;

                setDiceImages(firstDice, secondDice);

                int sum = firstDice + secondDice;
                int rest = sum % 2;

                if(currentPick.equals("even")){
                    if(rest == 0){
                        playerPoints++;
                    }else {
                        cpuPoints++;
                    }
                }

                if(currentPick.equals("odd")){
                    if(rest != 0){
                        playerPoints++;
                    }else {
                        cpuPoints++;
                    }
                }

                //display points

                tvPoints_cpu.setText("CPU: " + cpuPoints);
                tvPoints_you.setText("YOU: " + playerPoints);

                b_roll.setVisibility(View.INVISIBLE);
                b_even.setVisibility(View.VISIBLE);
                b_odd.setVisibility(View.VISIBLE);

                //animation

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv_dice1.startAnimation(animation);
                iv_dice2.startAnimation(animation);

            }
        });

        b_even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPick = "even";
                tvStatus.setText(currentPick);

                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);
            }
        });

        b_odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPick = "odd";
                tvStatus.setText(currentPick);

                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void setDiceImages (int dice1Number, int dice2Number){

        switch (dice1Number){
            case 1:
                iv_dice1.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                iv_dice1.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                iv_dice1.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                iv_dice1.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                iv_dice1.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                iv_dice1.setImageResource(R.drawable.dice_6);
                break;
        }

        switch (dice2Number){
            case 1:
                iv_dice2.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                iv_dice2.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                iv_dice2.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                iv_dice2.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                iv_dice2.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                iv_dice2.setImageResource(R.drawable.dice_6);
                break;
        }


    }

}
