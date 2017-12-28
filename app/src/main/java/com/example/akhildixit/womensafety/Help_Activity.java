package com.example.akhildixit.womensafety;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * For help methods
 *
 *
 *
 * Created by Akhil Dixit on 5/30/2017.
 */

public class Help_Activity extends AppCompatActivity {


    String file_name = "User_data";
    Button button;
    TextView txt;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_screen);

        button = (Button) findViewById(R.id.helpButton);
        txt = (TextView) findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9910461536"));

                Intent intent1=new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:9818399270"));


                if (ActivityCompat.checkSelfPermission(Help_Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Help_Activity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(intent);
                startActivity(intent1);

                                          try {
                                             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(file_name)));
                                              int count=0;

                                              String data;
                                              while ((data = bufferedReader.readLine())!=null){
                                                  count++;
                                                  Log.d("MainActivity", data);
                                                  Toast.makeText(Help_Activity.this,"Data is = "+data+"count is "+count, Toast.LENGTH_LONG).show();
                                                  txt.setText(txt.getText()+"\n"+data);
                                              }


                                      }
                                      catch (Exception e)
                                      {
                                          e.printStackTrace();
                                          e.printStackTrace();
                                          Toast.makeText(Help_Activity.this,"some error occured",Toast.LENGTH_SHORT).show();
                                      }
                                      Toast.makeText(Help_Activity.this,"help is on its way",Toast.LENGTH_LONG).show();


                                  }




                              }


    );


}
}
