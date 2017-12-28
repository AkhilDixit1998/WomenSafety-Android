package com.example.akhildixit.womensafety;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener{

    EditText name,phoneNumber,helpNumber1,helpNumber2,helpNumber3;
    Button submit,reset;
    String file_name="User_data";
    String Username,UserPhoneNumber,UserHelpNumber1,UserHelpNumber2,UserHelpNumber3;

    Boolean is_logged_in;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        SharedPreferences sp= getSharedPreferences(Example.saved_preferences,0);
        is_logged_in=sp.getBoolean("is_logged_in",false);

        if(is_logged_in)
        {
           Intent intent=new Intent(this,Help_Activity.class);
            startActivity(intent);
            finish();
        }


            name = (EditText) findViewById(R.id.nameEditText);
            phoneNumber = (EditText) findViewById(R.id.phoneEditText);
            helpNumber1 = (EditText) findViewById(R.id.number1);
            helpNumber2 = (EditText) findViewById(R.id.number2);
            helpNumber3 = (EditText) findViewById(R.id.number3);




            submit = (Button) findViewById(R.id.submitBtn);
            reset = (Button) findViewById(R.id.resetBtn);

            submit.setOnClickListener(this);
            reset.setOnClickListener(this);



            SharedPreferences.Editor editor=sp.edit();

            editor.putBoolean("is_logged_in",true);
            editor.commit();

        }


    @Override
    public void onClick(View v) {

        switch (v.getId())

        {
            case R.id.submitBtn:
                Username = name.getText().toString();
                UserPhoneNumber = phoneNumber.getText().toString();
                UserHelpNumber1 = helpNumber1.getText().toString();
                UserHelpNumber2 = helpNumber2.getText().toString();
                UserHelpNumber3 = helpNumber3.getText().toString();
                try {

                    Toast.makeText(Login_Activity.this,Username,Toast.LENGTH_SHORT).show();
                    Toast.makeText(Login_Activity.this,UserPhoneNumber,Toast.LENGTH_SHORT).show();
                    Toast.makeText(Login_Activity.this,UserHelpNumber1,Toast.LENGTH_SHORT).show();
                    Toast.makeText(Login_Activity.this,UserHelpNumber2,Toast.LENGTH_SHORT).show();

                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput(file_name, MODE_APPEND)));

                    bufferedWriter.write(Username+"\n");
                    bufferedWriter.write(UserPhoneNumber+"\n");
                    bufferedWriter.write(UserHelpNumber1+"\n");
                    bufferedWriter.write(UserHelpNumber2+"\n");
                    bufferedWriter.write(UserHelpNumber3+"\n");


                    bufferedWriter.close();

                    Toast.makeText(Login_Activity.this,"succesfully stored data",Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }



                /*for trial*/
                Intent intent =new Intent(Login_Activity.this,Help_Activity.class);
                startActivity(intent);

                break;
            case R.id.resetBtn:
                name.getText().clear();
                phoneNumber.getText().clear();
                helpNumber1.getText().clear();
                helpNumber2.getText().clear();
                helpNumber3.getText().clear();

        }


    }
}
