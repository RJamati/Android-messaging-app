package com.msgapp.msgapp;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText edtxt_ph;
    private EditText edtxt_msg;
    private Button btn_send;
    public String ph,msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxt_ph=(EditText)findViewById(R.id.editText);
        edtxt_msg=(EditText)findViewById(R.id.editText2);
        btn_send=(Button)findViewById(R.id.button);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ph=edtxt_ph.getText().toString();
                msg=edtxt_msg.getText().toString();

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,intent,0);

                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(ph,null,msg,pi,null);


                Toast.makeText(getApplicationContext(),"Message Sent Successfully",Toast.LENGTH_LONG).show();

            }
        });
    }
}
