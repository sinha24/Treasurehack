package com.solipsism.treasurehack;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.solipsism.treasurehack.utils.PrefsHelper;

import java.util.Random;

public class startplay extends AppCompatActivity {

    Button play,inst;
    String chkcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startplay);


        play=(Button) findViewById(R.id.playButton);
        inst=(Button) findViewById(R.id.inst);
        final Activity activity=this;

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("SCAN FIRST CODE");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();


            }
        });

        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(startplay.this, instruction.class);
                startActivity(i);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result!=null)
        {
            if(result.getContents()==null)
            {
                Toast.makeText(startplay.this, "You Cancelled the scan", Toast.LENGTH_SHORT).show();
            }
            else
            {
                chkcode=result.getContents();
                if(chkcode.equals("12")){
                    PrefsHelper.getPrefsHelper(startplay.this).savePref(PrefsHelper.PREF_JOURNEY,12);
                    Intent i = new Intent(startplay.this, startjourney.class);
                    startActivity(i);
                    finish();
                }
                else if(chkcode.equals("34")){
                    PrefsHelper.getPrefsHelper(startplay.this).savePref(PrefsHelper.PREF_JOURNEY,34);
                    Intent i = new Intent(startplay.this, startjourney.class);
                    startActivity(i);
                    finish();
                }
                else if(chkcode.equals("56")){
                    PrefsHelper.getPrefsHelper(startplay.this).savePref(PrefsHelper.PREF_JOURNEY,56);
                    Intent i = new Intent(startplay.this, startjourney.class);
                    startActivity(i);
                    finish();
                } else if(chkcode.equals("78")){
                    PrefsHelper.getPrefsHelper(startplay.this).savePref(PrefsHelper.PREF_JOURNEY,78);
                    Intent i = new Intent(startplay.this, startjourney.class);
                    startActivity(i);
                    finish();
                }
                else if(chkcode.equals("90")){
                    PrefsHelper.getPrefsHelper(startplay.this).savePref(PrefsHelper.PREF_JOURNEY,90);
                    Intent i = new Intent(startplay.this, startjourney.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(startplay.this, "Wrong code, Reach source point for correct code", Toast.LENGTH_SHORT).show();
                    Log.e("start code",chkcode);
                }
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
