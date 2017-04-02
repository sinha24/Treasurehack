package com.solipsism.treasurehack;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.solipsism.treasurehack.utils.PrefsHelper;

public class startjourney extends AppCompatActivity {
    Button play,inst;
    String chkcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startjourney);

        play=(Button) findViewById(R.id.gobttn);
        inst=(Button) findViewById(R.id.inst1);
        final Activity activity=this;

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("SCAN SECOND CODE");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }
        });

        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(startjourney.this, instruction.class);
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
                Toast.makeText(startjourney.this, "You Cancelled the scan", Toast.LENGTH_SHORT).show();
            }
            else
            {
                chkcode=result.getContents();
                if(chkcode.equals("758369")){
                    PrefsHelper.getPrefsHelper(startjourney.this).savePref(PrefsHelper.PREF_AUTH,758369);
                    Intent i = new Intent(startjourney.this, journey.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(startjourney.this, "Wrong code, Scan the live code", Toast.LENGTH_SHORT).show();
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
