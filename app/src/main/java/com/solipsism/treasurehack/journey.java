package com.solipsism.treasurehack;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.solipsism.treasurehack.utils.PrefsHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class journey extends AppCompatActivity {

    TextView question;
    Button scan, submit;
    String checkResult;
    EditText qrstring;

    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> code = new ArrayList<>();
    ArrayList<String> qrstr = new ArrayList<>();


    int randomques;
    int geti, check = 0;
    String tr, cr, qr;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);

        String q1 = "There is a board, a board different from others. It carries a thought and no one ever bothers....";
        String q2 = "Knowledge is power reaches the wall. Those big golden words will never make you fall...";
        String q3 = "The very first stop and the very last too...";

        String q4 = "Decipher: \n [3.5] , 4*4-7+6/3 , √16 \uD83E\uDD14";
        String q5 = "Water meets air, with a touch of flavour";
        String q6 = "Hey Dude! Don't _______ with me...\uD83C\uDFB5\uD83C\uDFB6\uD83C\uDFB5\uD83C\uDFB6";

        String q7 = "Billi \uD83D\uDC31  do, Degree \uD83C\uDF93 lo...";
        String q8 = "Decipher: \n (640x25+419)/1263 , (256x25-26)/3187 , 1/2x6/4x16/5x5/12 \uD83E\uDD14";
        String q9 = "Remove my start and i'm a degree of arts, remove my end and to a storage unit I tend, Remove my middle and she'll solve your any life riddle. \uD83C\uDFB5\uD83C\uDFB6\uD83C\uDFB5\uD83C\uDFB6";

        String q10 = "a small car with rings one less than olympics";
        String q11 = "a 100 seater luxurious car";
        String q12 = "you are sitting in a ambassdor in front of a shop working hard, look right";

        String q13 = "Find the lady with an umbrella";
        String q14 = "The place where you get METAL TOKENS";
        String q15 = "Kitabon ki thandi chaaon";

        String q16 = "The 'CENTRAL PERK' of our 'F.R.I.E.N.D.S.'";
        String q17 = "One Modi decision caused this place to go mad and flood over";
        String q18 = "Bhaiya!! Der na ho jaaye, Kahi der na ho jaaye \uD83C\uDFB5\uD83C\uDFB6\uD83C\uDFB5\uD83C\uDFB6";
        String q19 = "Kyu paisa paisa karti hai, Paise pe kyu tu marti hai \uD83C\uDFB5\uD83C\uDFB6\uD83C\uDFB5\uD83C\uDFB6 ";
        String q20 = "You buried Mr. Pool here...\uD83D\uDE2D\uD83D\uDE2D";

        String q21 = "(100+many) office";
        String q22 = "Silicon Valley ka pataal lok";
        String q23 = "OMG where are you";
        String q24 = "The department with which you had your last relationship";
        String q25 = "Unchi hai building, lift teri band hai, kaise me aau, lift teri band hai\uD83C\uDFB5\uD83C\uDFB6\uD83C\uDFB5\uD83C\uDFB6";

        String qr1 = "qtreydkgkfnfl";
        String qr2 = "retsybkdmldml";
        String qr3 = "rqexsbxbdkdbdm";
        String qr4 = "qrsfbqtabyomij";
        String qr5 = "reqswdafthiklio";

        String qr6 = "r3gu3b4in768kal";
        String qr7 = "v34ge8hfj9ej1jd";
        String qr8 = "rqesbdjmdkmkwwj";
        String qr9 = "qwsaeddjgnkgfm873";
        String qr10 = "eqwsahntyyk54239";

        String qr11 = "uthfmdlmclmd4315";
        String qr12 = "cxvzbdh763nfls92j";
        String qr13 = "rqedvhbfngng34glmg";
        String qr14 = "trfbfjnfljn5613mj";
        String qr15 = "rqedsbdub213nmjow";


        if ((int) PrefsHelper.getPrefsHelper(journey.this).getPref(PrefsHelper.PREF_JOURNEY) == 12) {
            questions.add(q16);
            questions.add(q16);
            questions.add(q16);

            questions.add(q13);
            questions.add(q14);
            questions.add(q15);

            questions.add(q10);
            questions.add(q11);
            questions.add(q12);

            questions.add(q22);
            questions.add(q22);
            questions.add(q22);

            questions.add(q1);
            questions.add(q2);
            questions.add(q3);

            questions.add(q4);
            questions.add(q5);
            questions.add(q6);

            questions.add(q7);
            questions.add(q8);
            questions.add(q9);

            code.add("2468");
            code.add("2468");
            code.add("2468");

            code.add("5968");
            code.add("5968");
            code.add("5968");

            code.add("2178");
            code.add("2178");
            code.add("2178");

            code.add("8162");
            code.add("8162");
            code.add("8162");

            code.add("7566");
            code.add("7566");
            code.add("7566");

            code.add("9823");
            code.add("9823");
            code.add("9823");

            code.add("1523");
            code.add("1523");
            code.add("1523");

            qrstr.add(qr6);
            qrstr.add(qr6);
            qrstr.add(qr6);

            qrstr.add(qr5);
            qrstr.add(qr5);
            qrstr.add(qr5);

            qrstr.add(qr4);
            qrstr.add(qr4);
            qrstr.add(qr4);

            qrstr.add(qr12);
            qrstr.add(qr12);
            qrstr.add(qr12);

            qrstr.add(qr1);
            qrstr.add(qr1);
            qrstr.add(qr1);

            qrstr.add(qr2);
            qrstr.add(qr2);
            qrstr.add(qr2);

            qrstr.add(qr3);
            qrstr.add(qr3);
            qrstr.add(qr3);

        } else if ((int) PrefsHelper.getPrefsHelper(journey.this).getPref(PrefsHelper.PREF_JOURNEY) == 34) {
            questions.add(q18);
            questions.add(q18);
            questions.add(q18);

            questions.add(q4);
            questions.add(q5);
            questions.add(q6);

            questions.add(q13);
            questions.add(q14);
            questions.add(q15);

            questions.add(q1);
            questions.add(q2);
            questions.add(q3);

            questions.add(q17);
            questions.add(q17);
            questions.add(q17);

            questions.add(q7);
            questions.add(q8);
            questions.add(q9);

            questions.add(q10);
            questions.add(q11);
            questions.add(q12);

            code.add("4812");
            code.add("4812");
            code.add("4812");

            code.add("9823");
            code.add("9823");
            code.add("9823");

            code.add("5968");
            code.add("5968");
            code.add("5968");

            code.add("7566");
            code.add("7566");
            code.add("7566");

            code.add("3691");
            code.add("3691");
            code.add("3691");

            code.add("1523");
            code.add("1523");
            code.add("1523");

            code.add("2178");
            code.add("2178");
            code.add("2178");

            qrstr.add(qr8);
            qrstr.add(qr8);
            qrstr.add(qr8);

            qrstr.add(qr2);
            qrstr.add(qr2);
            qrstr.add(qr2);

            qrstr.add(qr5);
            qrstr.add(qr5);
            qrstr.add(qr5);

            qrstr.add(qr1);
            qrstr.add(qr1);
            qrstr.add(qr1);

            qrstr.add(qr7);
            qrstr.add(qr7);
            qrstr.add(qr7);

            qrstr.add(qr3);
            qrstr.add(qr3);
            qrstr.add(qr3);

            qrstr.add(qr4);
            qrstr.add(qr4);
            qrstr.add(qr4);


        } else if ((int) PrefsHelper.getPrefsHelper(journey.this).getPref(PrefsHelper.PREF_JOURNEY) == 56) {
            questions.add(q19);
            questions.add(q19);
            questions.add(q19);

            questions.add(q1);
            questions.add(q2);
            questions.add(q3);

            questions.add(q4);
            questions.add(q5);
            questions.add(q6);

            questions.add(q7);
            questions.add(q8);
            questions.add(q9);

            questions.add(q13);
            questions.add(q14);
            questions.add(q15);

            questions.add(q25);
            questions.add(q25);
            questions.add(q25);

            questions.add(q10);
            questions.add(q11);
            questions.add(q12);

            code.add("5101");
            code.add("5101");
            code.add("5101");

            code.add("7566");
            code.add("7566");
            code.add("7566");

            code.add("9823");
            code.add("9823");
            code.add("9823");

            code.add("1523");
            code.add("1523");
            code.add("1523");

            code.add("5968");
            code.add("5968");
            code.add("5968");

            code.add("1122");
            code.add("1122");
            code.add("1122");

            code.add("2178");
            code.add("2178");
            code.add("2178");

            qrstr.add(qr9);
            qrstr.add(qr9);
            qrstr.add(qr9);

            qrstr.add(qr1);
            qrstr.add(qr1);
            qrstr.add(qr1);

            qrstr.add(qr2);
            qrstr.add(qr2);
            qrstr.add(qr2);

            qrstr.add(qr3);
            qrstr.add(qr3);
            qrstr.add(qr3);

            qrstr.add(qr5);
            qrstr.add(qr5);
            qrstr.add(qr5);

            qrstr.add(qr15);
            qrstr.add(qr15);
            qrstr.add(qr15);

            qrstr.add(qr4);
            qrstr.add(qr4);
            qrstr.add(qr4);


        } else if ((int) PrefsHelper.getPrefsHelper(journey.this).getPref(PrefsHelper.PREF_JOURNEY) == 78) {
            questions.add(q24);
            questions.add(q24);
            questions.add(q24);

            questions.add(q7);
            questions.add(q8);
            questions.add(q9);

            questions.add(q13);
            questions.add(q14);
            questions.add(q15);

            questions.add(q4);
            questions.add(q5);
            questions.add(q6);

            questions.add(q1);
            questions.add(q2);
            questions.add(q3);

            questions.add(q10);
            questions.add(q11);
            questions.add(q12);

            questions.add(q21);
            questions.add(q21);
            questions.add(q21);

            code.add("1020");
            code.add("1020");
            code.add("1020");

            code.add("1523");
            code.add("1523");
            code.add("1523");

            code.add("5968");
            code.add("5968");
            code.add("5968");

            code.add("9823");
            code.add("9823");
            code.add("9823");

            code.add("7566");
            code.add("7566");
            code.add("7566");

            code.add("2178");
            code.add("2178");
            code.add("2178");

            code.add("7142");
            code.add("7142");
            code.add("7142");

            qrstr.add(qr14);
            qrstr.add(qr14);
            qrstr.add(qr14);

            qrstr.add(qr3);
            qrstr.add(qr3);
            qrstr.add(qr3);

            qrstr.add(qr5);
            qrstr.add(qr5);
            qrstr.add(qr5);

            qrstr.add(qr2);
            qrstr.add(qr2);
            qrstr.add(qr2);

            qrstr.add(qr1);
            qrstr.add(qr1);
            qrstr.add(qr1);

            qrstr.add(qr4);
            qrstr.add(qr4);
            qrstr.add(qr4);

            qrstr.add(qr11);
            qrstr.add(qr11);
            qrstr.add(qr11);

        } else if ((int) PrefsHelper.getPrefsHelper(journey.this).getPref(PrefsHelper.PREF_JOURNEY) == 90) {
            questions.add(q23);
            questions.add(q23);
            questions.add(q23);

            questions.add(q10);
            questions.add(q11);
            questions.add(q12);

            questions.add(q1);
            questions.add(q2);
            questions.add(q3);

            questions.add(q13);
            questions.add(q14);
            questions.add(q15);

            questions.add(q4);
            questions.add(q5);
            questions.add(q6);

            questions.add(q7);
            questions.add(q8);
            questions.add(q9);

            questions.add(q20);
            questions.add(q20);
            questions.add(q20);

            code.add("9187");
            code.add("9187");
            code.add("9187");

            code.add("2178");
            code.add("2178");
            code.add("2178");

            code.add("7566");
            code.add("7566");
            code.add("7566");

            code.add("5968");
            code.add("5968");
            code.add("5968");

            code.add("9823");
            code.add("9823");
            code.add("9823");

            code.add("1523");
            code.add("1523");
            code.add("1523");

            code.add("6121");
            code.add("6121");
            code.add("6121");

            qrstr.add(qr13);
            qrstr.add(qr13);
            qrstr.add(qr13);

            qrstr.add(qr4);
            qrstr.add(qr4);
            qrstr.add(qr4);

            qrstr.add(qr1);
            qrstr.add(qr1);
            qrstr.add(qr1);

            qrstr.add(qr5);
            qrstr.add(qr5);
            qrstr.add(qr5);

            qrstr.add(qr2);
            qrstr.add(qr2);
            qrstr.add(qr2);

            qrstr.add(qr3);
            qrstr.add(qr3);
            qrstr.add(qr3);

            qrstr.add(qr10);
            qrstr.add(qr10);
            qrstr.add(qr10);
        }


        question = (TextView) findViewById(R.id.question);
        scan = (Button) findViewById(R.id.scan);
        qrstring = (EditText) findViewById(R.id.qrstring);
        submit = (Button) findViewById(R.id.submit);
        final Activity activity = this;

        int b = PrefsHelper.getPrefsHelper(journey.this).getPref(PrefsHelper.PREF_CURRENT, -1);
        if (b == -1) {
            Random x = new Random();
            randomques = x.nextInt(3);
            geti = 3 * 0 + randomques;

            PrefsHelper.getPrefsHelper(journey.this).savePref(PrefsHelper.PREF_CURRENT, geti);
            tr = questions.get(geti);
            cr = code.get(geti);
            qr = qrstr.get(geti);
        } else {
            check = PrefsHelper.getPrefsHelper(journey.this).getPref(PrefsHelper.PREF_CHECK, 0);
            geti = b;
            Log.e("get ", geti + "");
            Log.e("question ", questions.get(geti));
            tr = questions.get(geti);
            cr = code.get(geti);
            qr = qrstr.get(geti);
        }


        question.setText(tr);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrstring.clearFocus();
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("QUICK BUDDY, SEARCH THE CODE");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrstring.clearFocus();
                String checkqr = qrstring.getText().toString();
                if (checkqr.equals(qr)) {
                    Toast.makeText(journey.this, "keep Moving", Toast.LENGTH_LONG).show();
                    check++;
                    if (check >= 7) {
                        Log.e("checkinjou ", check + "");
                        PrefsHelper.getPrefsHelper(journey.this).savePref(PrefsHelper.PREF_CHECK, check);
                        Toast.makeText(journey.this, "You reached the destination", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(journey.this, finalpoint.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(journey.this, "Here is the next question for you.", Toast.LENGTH_LONG).show();


                        Random x = new Random();
                        randomques = x.nextInt(3);
                        Log.e("randomques ", randomques + "");
                        geti = 3 * check + randomques;
                        Log.e("geti ", geti + "");
                        PrefsHelper.getPrefsHelper(journey.this).savePref(PrefsHelper.PREF_CURRENT, geti);
                        PrefsHelper.getPrefsHelper(journey.this).savePref(PrefsHelper.PREF_CHECK, check);
                        tr = questions.get(geti);
                        cr = code.get(geti);
                        qr = qrstr.get(geti);
                        question.setText(tr);
                        qrstring.setText("");

                    }
                } else {
                    qrstring.requestFocus();
                    qrstring.setError("Please enter correct string");
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(journey.this, "You Cancelled the scan", Toast.LENGTH_LONG).show();
            } else {
                checkResult = result.getContents();

                if (cr.equals(checkResult)) {
                    Toast.makeText(journey.this, "keep Moving", Toast.LENGTH_SHORT).show();
                    check++;
                    if (check >= 7) {
                        Log.e("checkinjou ", check + "");
                        PrefsHelper.getPrefsHelper(journey.this).savePref(PrefsHelper.PREF_CHECK, check);
                        Toast.makeText(journey.this, "You reached the destination", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(journey.this, finalpoint.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(journey.this, "Here is the next question for you.", Toast.LENGTH_SHORT).show();


                        Random x = new Random();
                        randomques = x.nextInt(3);
                        Log.e("randomques ", randomques + "");
                        geti = 3 * check + randomques;
                        Log.e("geti ", geti + "");
                        PrefsHelper.getPrefsHelper(journey.this).savePref(PrefsHelper.PREF_CURRENT, geti);
                        PrefsHelper.getPrefsHelper(journey.this).savePref(PrefsHelper.PREF_CHECK, check);
                        tr = questions.get(geti);
                        cr = code.get(geti);
                        qr = qrstr.get(geti);
                        question.setText(tr);
                    }

                } else {
                    Toast.makeText(journey.this, "You are at wrong place buddy.....!", Toast.LENGTH_SHORT).show();
                }


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
