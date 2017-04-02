package com.solipsism.treasurehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class instruction extends AppCompatActivity {

    Button close;
    TextView inst3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        inst3=(TextView)findViewById(R.id.inst3);
        String text="HOW TO PLAY: \n \n1.Get the clue, go to correct place, scan the QR, Get the NEXT clue. \n2.The team who solves all 7 hacks first wins the game.\n3.There'll be an alternate character string written with each QR code which is just for the backup, in-case your scanner doesn't works.\n\n\n" +
                "WHERE TO PLAY: \n\n1.The play area is limited to college campus only.\n2.Run starts at medi square.\n\n\n" +
                "WHEN TO PLAY:\n\n1.You'll have to scan 2 codes at starting point before expecting clues:\n\t\t1.1 QR code A: This code can be scanned by one person from a team anywhere between 11 to 12 pm on 23rd march only when you show us the registration slip." +
                "\n \t\t1.2 QR code B: This QR code will go live on 12 pm to start your journey. \n\n\nPRO TIP: \n\n1. Scan the QR from atleast 3 feet away for a quick scan.\n2.Beware of bogus QR codes.\n3.Play with a charged phone as progress in a phone is non-transferrable.";
        inst3.setText(text);


        close=(Button) findViewById(R.id.button7);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
