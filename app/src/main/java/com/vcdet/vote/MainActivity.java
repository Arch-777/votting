package com.vcdet.vote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int bjpVotes = 0;
    private int congressVotes = 0;
    private int aapVotes = 0;
    private int bspVotes = 0;
    private int notaVotes = 0;

    private Button bjpButton;
    private Button congressButton;
    private Button aapButton;
    private Button bspButton;
    private Button notaButton;
    private Button resultsButton;
    private TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        bjpButton = findViewById(R.id.bjp_button);
        congressButton = findViewById(R.id.congress_button);
        aapButton = findViewById(R.id.aap_button);
        bspButton = findViewById(R.id.bsp_button);
        notaButton = findViewById(R.id.nota_button);
        resultsButton = findViewById(R.id.results_button);
        resultsTextView = findViewById(R.id.results_text);

        // Set click listeners for voting buttons
        bjpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bjpVotes++;
                updateResultsText();
            }
        });

        congressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                congressVotes++;
                updateResultsText();
            }
        });
        aapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aapVotes++;
                updateResultsText();
            }
        });
        bspButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bspVotes++;
                updateResultsText();
            }
        });
        notaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaVotes++;
                updateResultsText();
            }
        });


        // Set click listener for results button
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winner = getWinner();
                resultsTextView.setText("The winner is: " + winner);
            }
        });
    }

    private String getWinner() {
        int maxVotes = 0;
        String winner = "";

        if (bjpVotes > maxVotes) {
            winner = "BJP";
            maxVotes = bjpVotes;
        }
        if (aapVotes > maxVotes) {
            winner = "AAP";
            maxVotes = aapVotes;
        }
        if (bspVotes > maxVotes) {
            winner = "BSP";
            maxVotes = bspVotes;
        }
        if (congressVotes > maxVotes) {
            winner = "Congress";
            maxVotes = congressVotes;
        }
        if (notaVotes > maxVotes){
            winner = "NOTA";
            maxVotes = notaVotes;
        }

        return winner;
    }

    private void updateResultsText() {
        // Update text view with current vote counts
        //String text = "";
        String text = "Votes:\nBJP: " + bjpVotes + "\nCongress: " + congressVotes + "\nAAP: " + aapVotes + "\nBSP: " + bspVotes + "\nNOTA: " + notaVotes;
        resultsTextView.setText(text);
    }
}