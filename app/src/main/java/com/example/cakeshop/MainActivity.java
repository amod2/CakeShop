package com.example.cakeshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button view;
    database DB=new database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////                DATE CODE                //////////////////////////////////////////
        TextView tdate=findViewById(R.id.currentdate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dt=(String)formatter.format(date);
        tdate.setText(dt);
        /////////////////// DATE CODE                  /////////////////////////////////////////
        show_data();

    }

    private void show_data() {
        view=findViewById(R.id.viewOrder);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+ "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Cake Orders");
                builder.setMessage(buffer.toString());
                builder.setPositiveButton("Details",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                CustomerDetails();

                            }
                        });

                builder.setNeutralButton("Exit",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {

                                dialog.cancel();
//                                Intent in=new Intent(MainActivity.this,MainActivity.class);
//                                startActivity(in);
                            }
                        });

                builder.setNegativeButton("Exit",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                            }
                        });
                builder.setNegativeButton("TodayOrder",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                todayOrder();
                            }
                        });
                builder.create().show();

            }        });

    }

    private void CustomerDetails() {
        database DB=new database(this);
        Cursor res = DB.getdata();
        if(res.getCount()==0){
            Toast.makeText(MainActivity.this, "No Customer Details  Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("#######################"+ "\n");
        while(res.moveToNext()){
            buffer.append("Date: "+res.getString(1)+ "\n");
            buffer.append("Weight: "+res.getString(2)+ "\n");
            buffer.append("Name "+res.getString(3)+ "\n");
            buffer.append("Address: "+res.getString(4)+ "\n");
            buffer.append("Phone: "+res.getString(5)+ "\n");
            buffer.append("Shape: "+res.getString(6)+ "\n");
            buffer.append("Order Person: "+res.getString(7)+ "\n\n");
            buffer.append("-------------------------------------------------------"+"\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Customer Details ");
        builder.setMessage(buffer.toString());
        builder.show();
    }
    public void todayOrder(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        database DB=new database(this);
        String dt=(String)formatter.format(date);
        Cursor res = DB.getTodayOrders(dt);
        if(res.getCount()==0){
            Toast.makeText(MainActivity.this, "No Order for today till now", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+ "\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Today Orders");
        builder.setMessage(buffer.toString());
        builder.show();
    }

    public void Add(View view) {
        Intent in=new Intent(MainActivity.this,addOrder.class);
        startActivity(in);
    }

    public void todayOrders(View view) {

      todayOrder();
    }

    public void CustomerDetails(View view) {
      CustomerDetails();
    }

    public void CalBill(View view) {
        Intent in=new Intent(MainActivity.this,BillManager.class);
        startActivity(in);
    }

    public void ListTest(View view) {
        Intent in=new Intent(this,ItemLists.class);
        startActivity(in);
    }
}