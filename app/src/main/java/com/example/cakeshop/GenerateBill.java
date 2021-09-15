package com.example.cakeshop;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class GenerateBill extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String [] qty =new String[]{
      "1","2","3","4","5"
    };
    private static final String[] Baloons=new String[]{
            "BirthdayBaloon","Anniversary Baloon","Geneal Baloon","None"
    };
    private static final String[]  Ycandle=new String[]{
            "Year Candle","Year Candle General","None"
    };
    private static final String[] Cap=new String[]{
            " Caps Small","Caps Medium","Caps Large"
    };
    private static final String[] Taj=new String[]{
            " Taj","Music Taj","None"
    };
    private static final String[] SparkC=new String[]{
            " SparkCandle Small","SparkCandle Medium","SparkCandle Large","None"
    };
    private int balBirth_p=120,balAnniv_p=120,balNormal=250;
    private int cap_s_p=35,cap_m_p=50,cap_l_p=70;
    private int spark_s_p=40,Spark_m_p=60,spark_l_p=70;
    private int year1_p=35,year2_p=25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_bill);
        BalSpiner();
        YearcandleSpiner();
        CapSpiner();
        SparkSpiner();
        TajSpiner();
        Qtybal();
        QtyYear();
        QtyCaps();
        QtyTaj();
        QtySpark();

       Calculate();
    }
    StringBuffer bf=new StringBuffer();
    ArrayList<String > items=new ArrayList<>();
    ArrayList<String> itemqty=new ArrayList<>();


    private void Calculate() {
        Spinner baln=findViewById(R.id.baloon);
        Spinner cap_s=findViewById(R.id.sparkc);
        Spinner year_s=findViewById(R.id.year);
        String baloon=baln.getSelectedItem().toString();
        String yearcandle=year_s.getSelectedItem().toString();
        String cap=cap_s.getSelectedItem().toString();
        Spinner bqty_s=findViewById(R.id.bqty);
        Spinner yearqty_s=findViewById(R.id.yearqty);
        Spinner capsqty_s=findViewById(R.id.capsqty);
        String bqty1=bqty_s.getSelectedItem().toString();
        String yearqty1=yearqty_s.getSelectedItem().toString();
        String capsqty1=capsqty_s.getSelectedItem().toString();

        items.add(baloon);
        items.add(yearcandle);
        items.add(cap);

        itemqty.add(bqty1);
        itemqty.add(yearqty1);
        itemqty.add(capsqty1);
        int total=0;
        int tprice=0;
        int item=1;

        bf.append("ItemName    "+"Price    "+"Quantity   "+ "Total"+"\n");
        for(int i=0;i< items.size();i++){
            int price = 1;
            if(i==0){
                if(items.get(i).equals("BirthdayBaloon")){
                    price=balBirth_p;
                    item=Integer.valueOf(itemqty.get(i));
                    tprice=price*item;

                }else if(items.get(i).contains("Anniversary Baloon")){
                    price=balAnniv_p;
                    item=Integer.valueOf(itemqty.get(i));
                    tprice=price*item;
                }else if(items.get(i).contains("General Baloon")){
                    price=balNormal;
                    item=Integer.valueOf(itemqty.get(i));
                    tprice=price*item;
                }else{
                    System.out.println("Nothing working");
                }
            }else if(i==1){
                if(items.get(i).contains("Year Candle")){
                    price=year1_p;
                    item=Integer.valueOf((itemqty.get(i)));
                    tprice=price*item;
                }else if(items.get(i).contains("Year Candle Normal")){
                    price=year2_p;
                    item=Integer.valueOf(itemqty.get(i));
                    tprice=price*item;

                }else{
                    System.out.println("Nothing working");
                }
            }
            bf.append(items.get(i)+"    "+itemqty.get(i)+"    "+item+ "   "+tprice+"\n");
            total=+tprice;


        }
        bf.append("Grand Total= "+total);


    }

    private void TajSpiner() {
        Spinner spin = (Spinner) findViewById(R.id.sparkc);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Taj);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void SparkSpiner() {
        Spinner spin = (Spinner) findViewById(R.id.spark);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,SparkC);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void QtySpark() {
        Spinner spin = (Spinner) findViewById(R.id.sparkqty);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,qty);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void QtyTaj() {
        Spinner spin = (Spinner) findViewById(R.id.tajqty);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,qty);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void QtyCaps() {
        Spinner spin = (Spinner) findViewById(R.id.capsqty);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,qty);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void QtyYear() {
        Spinner spin = (Spinner) findViewById(R.id.yearqty);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,qty);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void Qtybal() {
        Spinner spin = (Spinner) findViewById(R.id.bqty);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,qty);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void CapSpiner() {
        Spinner spin = (Spinner) findViewById(R.id.sparkc);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Cap);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void YearcandleSpiner() {

        Spinner spin = (Spinner) findViewById(R.id.year);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Ycandle);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    private void BalSpiner() {
        Spinner spin = (Spinner) findViewById(R.id.baloon);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter adaptor = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Baloons);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptor);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),Baloons[i] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView){


    }


    public void Generate(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GenerateBill.this);
        builder.setCancelable(true);
        builder.setTitle("Cake Orders");
        builder.setMessage(bf.toString());
        builder.show();
    }
}