package com.example.cakeshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Year;
import java.util.ArrayList;

public class BillManager extends AppCompatActivity {
    private static final String[] Baloons=new String[]{
            "Birthday Balloon","Balloon Anniversary","Balloon General"
    };
    private static final String[] Candle=new String[]{
            "Candle Magic","Candle Normal"
    };
    private static final String[]  Ycandle=new String[]{
            "Year Candle ","Year Candle LowQ"
    };
    private static final String[]  Caps=new String[]{
            "Cap Small","Cap Medium","Cap Large"
    };
    private static final String[]  Taj=new String[]{
            "Taj General ","Taj Light"
    };
    private static final String[]  Spark=new String[]{
            "SparkCandle 'S'","SparkCandle 'M'","SparkCandle 'L'"
    };
    private static final String[]  Lotus=new String[]{
            "LotusCandle 'S'","LotusCandle 'L'"
    };
    private static final String[]  Banner=new String[]{
            "Banner LowQ ","Banner Birthday","Banner Balloon"
    };
    private static final String[]  Slash=new String[]{
            "Slash Birthday ","Slash Anniversary"
    };
    private static final String[]  Spray=new String[]{
            "Spray white ","Spray colored"
    };
    private static final String[]  pPopper=new String[]{
            "PartyPopper 'S'","PartyPopper 'M'","PartyPopper 'L'"
    };


    private int balBirth_p=120,balAnniv_p=120,balNormal=250;
    private int candle1=50,candle2=40;
    private int spark_small=40,spark_medium=50,spark_large=70;
    private int year1_p=35,year2_p=25;
    private int cap1=35,cap2=50,cap3=80;
    private int taj1=80,taj2=130;
    private int lotus1=100;
    private int lotus2=160;
    private int bannerHB=120,balBanner=300,local=50;
    private int slash_p=100;
    private int spray1=110,spray2=130;
    private int pop1=120,pop2=150,pop3=200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_manager);
        ballonSuggestions();
        candleSuggestions();
        yCandleSuggestions();
        capSuggestions();
        tajSuggestions();
        sparkSuggestions();
        lotusSuggestions();
        bannerSuggestions();
        slashSuggestions();
        spraySuggestions();
        partyPopperSuggestions();


    }

    private void partyPopperSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.popper);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pPopper);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void spraySuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.spray);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Spray);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void slashSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.slash);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Slash);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void bannerSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.banner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Banner);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void lotusSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.lotus);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Lotus);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void tajSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.taj);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Taj);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }



    private void sparkSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.spark);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Spark);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void capSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.cap);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Caps);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void yCandleSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.yearcandle);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Ycandle);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void candleSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.candle);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Candle);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void ballonSuggestions() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.baloon);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Baloons);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }
ArrayList<String> qt=new ArrayList<>();
    ArrayList<String> ui_price=new ArrayList<>();

    public void CalBill(View view) {
        StringBuffer buffer=new StringBuffer();
        buffer.append("|-------------------------------------------------|"+"\n");
        buffer.append("| Sanvi Cake Center Yadukuha |"+"\n");
        buffer.append("| Pro:Saroj kumar mandal         |"+"\n");
        buffer.append("| Mob:9807894206                    |"+"\n");
        buffer.append("|------------------------------------------------|"+"\n");
        buffer.append("|------------------------------------------------|"+"\n");
        buffer.append("Name                      Qty     Price"+"\n");
        int price = 0;
        int item = 1;
        int tprice = 0;
        int total = 0;
        AutoCompleteTextView bal_tv = findViewById(R.id.baloon);
        AutoCompleteTextView candle_tv = findViewById(R.id.candle);
        AutoCompleteTextView ycandle_tv = findViewById(R.id.yearcandle);
        AutoCompleteTextView cap_tv = findViewById(R.id.cap);
        AutoCompleteTextView taj_tv = findViewById(R.id.taj);
        AutoCompleteTextView spark_tv = findViewById(R.id.spark);
        AutoCompleteTextView lotus_tv = findViewById(R.id.lotus);
        AutoCompleteTextView banner_tv = findViewById(R.id.banner);
        AutoCompleteTextView slash_tv = findViewById(R.id.slash);
        AutoCompleteTextView spray_tv = findViewById(R.id.spray);
        AutoCompleteTextView popper_tv = findViewById(R.id.popper);
        EditText qty1_et = findViewById(R.id.qty1);
        EditText qty2_et = findViewById(R.id.qty2);
        EditText qty3_et = findViewById(R.id.qty3);
        EditText qty4_et = findViewById(R.id.qty4);
        EditText qty5_et = findViewById(R.id.qty5);
        EditText qty6_et = findViewById(R.id.qty6);
        EditText qty7_et = findViewById(R.id.qty7);
        EditText qty8_et = findViewById(R.id.qty8);
        EditText qty9_et = findViewById(R.id.qty9);
        EditText qty10_et = findViewById(R.id.qty10);
        EditText qty11_et = findViewById(R.id.qty11);
        qt.add(qty1_et.getText().toString());
        qt.add(qty2_et.getText().toString());
        qt.add(qty3_et.getText().toString());
        qt.add(qty4_et.getText().toString());
        qt.add(qty5_et.getText().toString());
        qt.add(qty6_et.getText().toString());
        qt.add(qty7_et.getText().toString());
        qt.add(qty8_et.getText().toString());
        qt.add(qty9_et.getText().toString());
        qt.add(qty10_et.getText().toString());
        qt.add(qty11_et.getText().toString());
        EditText price1_et=findViewById(R.id.price1);
        EditText price2_et=findViewById(R.id.price2);
        EditText price3_et=findViewById(R.id.price3);
        EditText price4_et=findViewById(R.id.price4);
        EditText price5_et=findViewById(R.id.price5);
        EditText price6_et=findViewById(R.id.price6);
        EditText price7_et=findViewById(R.id.price7);
        EditText price8_et=findViewById(R.id.price8);
        EditText price9_et=findViewById(R.id.price9);
        EditText price10_et=findViewById(R.id.price10);
        EditText price11_et=findViewById(R.id.price11);
        ui_price.add(price1_et.getText().toString());
        ui_price.add(price2_et.getText().toString());
        ui_price.add(price3_et.getText().toString());
        ui_price.add(price4_et.getText().toString());
        ui_price.add(price5_et.getText().toString());
        ui_price.add(price6_et.getText().toString());
        ui_price.add(price7_et.getText().toString());
        ui_price.add(price8_et.getText().toString());
        ui_price.add(price9_et.getText().toString());
        ui_price.add(price10_et.getText().toString());
        ui_price.add(price11_et.getText().toString());
        for (int i = 0; i <= 10; i++) {

            if (i == 0) {
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }


                for (int j = 0; j < Baloons.length; j++) {
                    if (Baloons[j].equals(bal_tv.getText().toString()) && j == 0) {
                        price = balBirth_p;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                           try {
                               price=Integer.parseInt(ui_price.get(i).toString());
                           }catch (Exception e){

                           }
                        }

                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Baloons[j]+"     "+item+"         "+tprice+"\n");
                        break;
                    } else if (Baloons[j].equals(bal_tv.getText().toString()) && j == 1) {
                        price = balAnniv_p;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }

                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Baloons[j]+"     "+item+"         "+tprice+"\n");
                        break;
                    } else if (Baloons[j].equals(bal_tv.getText().toString()) && j == 2) {
                        price = balNormal;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        price1_et.setText(price);
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Baloons[j]+"     "+item+"         "+tprice+"\n");
                        break;
                    }


               }
            } else if (i == 1) {
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Candle.length; j++) {
                    if (candle_tv.getText().toString().contains(Candle[j]) && j == 0) {
                        price = candle1;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Candle[j]+"        "+item+"         "+tprice+"\n");
                        break;
                    } else if (Candle[j].equals(candle_tv.getText().toString()) && j == 1) {
                        price = candle2;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Candle[j]+"        "+item+"         "+tprice+"\n");
                        break;
                    }
//                        Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }
            } else if (i == 2) {
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Ycandle.length; j++) {
                    if (Ycandle[j].equals(ycandle_tv.getText().toString()) && j == 0) {
                        price = year1_p;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Ycandle[j]+"   "+item+"         "+tprice+"\n");
                        break;
                    } else if (Ycandle[j].equals(ycandle_tv.getText().toString()) && j == 1) {
                        price = year2_p;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Ycandle[j]+"   "+item+"         "+tprice+"\n");
                        break;
                    }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }
            }else if (i == 3) {
                    if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                        item = 1;
                    } else {
                        try {
                            item = Integer.parseInt(qt.get(i));
                        } catch (Exception e) {

                        }

                    }
                    for (int j = 0; j < Caps.length; j++) {
                        if (Caps[j].equals(cap_tv.getText().toString()) && j == 0) {
                            price = cap1;
                            if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                                try {
                                    price=Integer.parseInt(ui_price.get(i).toString());
                                }catch (Exception e){

                                }
                            }
                            tprice = price * item;
                            total = total + tprice;
                            buffer.append(Caps[j]+"          "+item+"         "+tprice+"\n");
                            break;
                        } else if (Caps[j].equals(cap_tv.getText().toString()) && j == 1) {
                            price = cap2;
                            if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))) {
                                try {
                                    price=Integer.parseInt(ui_price.get(i).toString());
                                }catch (Exception e){

                                }
                            }
                            tprice = price * item;
                            total = total + tprice;
                            buffer.append(Caps[j]+"         "+item+"         "+tprice+"\n");
                            break;
                        }else if (Caps[j].equals(cap_tv.getText().toString()) && j == 2) {
                            price = cap3;
                            if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                                try {
                                    price=Integer.parseInt(ui_price.get(i).toString());
                                }catch (Exception e){

                                }
                            }
                            tprice = price * item;
                            total = total + tprice;
                            buffer.append(Caps[j]+"          "+item+"         "+tprice+"\n");
                            break;
                        }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                    }
                }else if(i==4){
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Taj.length; j++) {
                    if (Taj[j].equals(taj_tv.getText().toString()) && j == 0) {
                        price = taj1;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Taj[j]+"             "+item+"         "+tprice+"\n");
                        break;
                    } else if (Taj[j].equals(taj_tv.getText().toString()) && j == 1) {
                        price = taj2;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Taj[j]+"              "+item+"         "+tprice+"\n");
                        break;
                    }

                }

            }else if(i==5){
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Spark.length; j++) {
                    if (Spark[j].equals(spark_tv.getText().toString()) && j == 0) {
                        price = spark_small;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Spark[j]+"   "+item+"        "+tprice+"\n");
                        break;
                    } else if (Spark[j].equals(spark_tv.getText().toString()) && j == 1) {
                        price =spark_medium;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Spark[j]+"   "+item+"        "+tprice+"\n");
                        break;
                    }else if (Spark[j].equals(spark_tv.getText().toString()) && j == 2) {
                        price = spark_large;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Spark[j]+"   "+item+"        "+tprice+"\n");
                        break;
                    }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }

            }else if(i==6){
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Lotus.length; j++) {
                    if (Lotus[j].equals(lotus_tv.getText().toString()) && j == 0) {
                        price = lotus1;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Lotus[j]+"          "+item+"         "+tprice+"\n");
                        break;
                    } else if (Lotus[j].equals(lotus_tv.getText().toString()) && j == 1) {
                        price = lotus2;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){try {
                            price=Integer.parseInt(ui_price.get(i).toString());
                        }catch (Exception e){

                        }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Lotus[j]+"          "+item+"         "+tprice+"\n");
                        break;
                    }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }
            }else if(i==7){
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Banner.length; j++) {
                    if (Banner[j].equals(banner_tv.getText().toString()) && j == 0) {
                        price = local;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Banner[j]+"          "+item+"         "+tprice+"\n");
                        break;
                    } else if (Banner[j].equals(banner_tv.getText().toString()) && j == 1) {
                        price = bannerHB;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Banner[j]+"          "+item+"         "+tprice+"\n");
                        break;
                    }else if (Banner[j].equals(banner_tv.getText().toString()) && j == 2) {
                        price = balBanner;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Banner[j]+"          "+item+"         "+tprice+"\n");
                        break;
                    }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }
            }else if(i==8){
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Slash.length; j++) {
                    if (Slash[j].equals(slash_tv.getText().toString()) && j == 0) {
                        price = slash_p;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))) {
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Slash[j]+"     "+item+"         "+tprice+"\n");
                        break;

                    }else if (Slash[j].equals(slash_tv.getText().toString()) && j == 1) {
                        price = slash_p;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Slash[j]+"     "+item+"         "+tprice+"\n");
                        break;

                    }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }
            }else if(i==9){
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < Spray.length; j++) {
                    if (Spray[j].equals(spray_tv.getText().toString()) && j == 0) {
                        price = spray1;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Spray[j]+"        "+item+"        "+tprice+"\n");
                        break;

                    }else if (Spray[j].equals(spray_tv.getText().toString()) && j == 1) {
                        price = spray2;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(Spray[j]+"        "+item+"        "+tprice+"\n");
                        break;

                    }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }

            }else if(i==10){
                if (qt.get(i).equals(null) || qt.get(i).equals(" ")) {
                    item = 1;
                } else {
                    try {
                        item = Integer.parseInt(qt.get(i));
                    } catch (Exception e) {

                    }

                }
                for (int j = 0; j < pPopper.length; j++) {
                    if (pPopper[j].equals(popper_tv.getText().toString()) && j == 0) {
                        price = pop1;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(pPopper[j]+"  "+item+"         "+tprice+"\n");
                        break;

                    }else if (pPopper[j].equals(popper_tv.getText().toString()) && j == 1) {
                        price = pop2;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(pPopper[j]+"  "+item+"         "+tprice+"\n");
                        break;

                    }else if (pPopper[j].equals(popper_tv.getText().toString()) && j == 2) {
                        price = pop3;
                        if(!(ui_price.get(i).equals(null) || ui_price.get(i).equals(" "))){
                            try {
                                price=Integer.parseInt(ui_price.get(i).toString());
                            }catch (Exception e){

                            }
                        }
                        tprice = price * item;
                        total = total + tprice;
                        buffer.append(pPopper[j]+"  "+item+"         "+tprice+"\n");
                        break;

                    }


//                    Toast.makeText(this, " "+price, Toast.LENGTH_SHORT).show();
                }
            }
            }
            buffer.append("|-------------------------------------------------|"+"\n");
            buffer.append("|                  Total= "+total+"               |"+"\n");
            buffer.append("|-------------------------------------------------|"+"\n");
            qt.clear();
            ui_price.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(BillManager.this);
        builder.setCancelable(true);
        builder.setTitle("Bill Calculated");
        builder.setMessage(buffer.toString());
        builder.setPositiveButton("Send Bill",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        Intent in=new Intent(BillManager.this,SendMessage.class);
                        in.putExtra("key",buffer.toString());
                        startActivity(in);

                    }
                });

        builder.setNeutralButton("Home",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
//                        Context context = null;
//                        context.startActivity(new Intent(context, GenerateBill.class));
                        //dialog.cancel();
                        Intent in=new Intent(BillManager.this,MainActivity.class);
                      startActivity(in);
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
        builder.create().show();

        }
    }
