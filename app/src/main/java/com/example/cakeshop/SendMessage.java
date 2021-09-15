package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendMessage extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    EditText et2;
    String msg;
    String number;
    int order_id=0;
    Cursor cr;
    database db=new database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        msg=getIntent().getStringExtra("key");


      try {
           cr=db.getBillNumber();
          order_id =cr.getCount();
      }catch (Exception e){

      }
      order_id+=100;



        StringBuffer sb=new StringBuffer(msg);
        sb.append("Bill Number: "+order_id);
        TextView et1=findViewById(R.id.message);
        et1.setText(sb.toString());
        et2=findViewById(R.id.number1);
        Button btn1=(Button) findViewById(R.id.send);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(et2.getText().toString(),null,sb.toString(),null,null);
                    Toast.makeText(SendMessage.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(SendMessage.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }





}
