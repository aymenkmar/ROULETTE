package com.example.aymen.roulette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    TextView textView;
    List<String> bullets;

    boolean shuffled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);




        //button.setVisibility(View.INVISIBLE);

        bullets = new ArrayList<>();
        //tzid ken bullet wa7da lel gun
        bullets.add("NO");
        bullets.add("NO");
        bullets.add("NO");
        bullets.add("NO");
        bullets.add("YES");


        // roll the barrel
        Collections.shuffle(bullets);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // roll the barrel
                Collections.shuffle(bullets);
                imageView.setImageResource(R.drawable.gun1);
                shuffled = true;
                textView.setText("CLICK ON IMAGE TO SHOOT");

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if (shuffled) {
                String currentBullet = bullets.get(1);

                if (currentBullet.equals("YES")) {
                    imageView.setImageResource(R.drawable.gun2);
                    textView.setText("YOU ARE DEAD!");
                } else {
                    imageView.setImageResource(R.drawable.gun3);
                    textView.setText("YOU ARE ALIVE! PASS THE GUN TO THE NEXT PLAYER");


                }
                shuffled = false;
            } else {
                textView.setText("FIRST ROLL THE BARREL");

            }
            }
        });
    }
}
