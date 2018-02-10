package com.example.shan.password_validator;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare EditText, TextView and Button by id
        final EditText inputPassword = (EditText) findViewById(R.id.password);
        final Button validateButton = (Button) findViewById(R.id.validate);
        final TextView strength = (TextView) findViewById(R.id.strength);
        final Validator v = new Validator(); //declare validator object

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p = inputPassword.getText().toString(); //receive the input
                String output = "";
                if (v.validate(p)== 5) {
                    output = "Password strength level: 5. Strong";
                }
                else {
                    output = "Password strength: "+v.validate(p)+" not strong enough.";
                }

                strength.setText(output);
            }
        });

    }

}
