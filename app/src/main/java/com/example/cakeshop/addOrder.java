package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addOrder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    AutoCompleteTextView auto;
    EditText t1,t3,t4,t5,t7;
    private static final String[] wt_s=new String[]{
            "0.5Kg ","1Kg","2Kg","3Kg","4Kg","5Kg"
    };
    private static final String[] shapeArr=new String[]{
            "heart","round","square"
    };
    private static final String[] addressArr=new String[]{
            "yadukuha","Nanupati","Dhabauli","Harwada","Hathipur","Hauwahi","nemwatol","Sarabe","Hatletba","Basdepati","Simrapati","Simrari","Sabaila",
            "Kharyani","Gatoli","Gotkuha","Chorakailpur","Pachherba","Bafai","Tinkoriya","Bisharghora","Nathpati","Mangraha","Machi","Lagma","Khaujari",
            "Ekrahi","Gidhha","Mahuliya","Bishargora","Dumariya","Matauna"
    };
    private static final String[] nameArr=new String[]{
      "Anish","Aayush","Ashmita","Aastha","Aashish","Anu","Anushka","Ankit","Aman","Aakash","Ashik","Avishek","Amod","Amit","Ajay","Bikash","Banshika","Dharmendra","Dipu","Dipendra","Deepika","Deepak",
            "Dhiraj","Dhirendra","Earthav","Ganesh","Gopal","Golu","Harsh","Himanshu","Jiwan","Juli","Juliya","Kamal","Kiran","Kishan","Krishana","Kush","Kriti",
            "Khushi","Kajal","Lalit","Lalita","Manoj","Manish","Mohan","Mohini","Manisha","Manjita","Mamta","Naresh","Narayan","Opendra","Om","Omprakash","Pooja","Punit",
            "Preeti","Prakash","Prince","Priyanshu","Priya","Pradip","Pratik","Prabin","Rupesh","Rina","Rishika","Ritika","Ritik","Roshan","Rohit","Rohan",
            "Ranjit","Ranjita","Rahul","Rakesh","Roshini","Roshan","Saroj","Suman","Sujit","Sanjeep","Sajan","Santosh","Smriti","Sanjana","Sakshi","Soni","Sonu",
            "Shiv","Shivani","Shivam","Shuvam","Shivangi","Sunil","Sumit","Tanya","Trisha","Urmila","Usha","Umesh","Varun","Vibek","Virat"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
      NameSuggestion();
      AddressSuggestion();
      WeightSuggestion();
      ShapeSpinner();
    }

    private void NameSuggestion() {
        AutoCompleteTextView namev= ( AutoCompleteTextView ) findViewById(R.id.name1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nameArr);
        namev.setAdapter(adapter);
        namev.setThreshold(1);
    }

    private void AddressSuggestion() {
        AutoCompleteTextView address= ( AutoCompleteTextView ) findViewById(R.id.addr);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,addressArr);
        address.setAdapter(adapter);
        address.setThreshold(1);
    }

    private void ShapeSpinner() {
        Spinner spin = (Spinner) findViewById(R.id.shape);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,shapeArr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

//    private void ShapeSuggestion() {
//        AutoCompleteTextView shapeV= ( AutoCompleteTextView ) findViewById(R.id.shape);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,shapeArr);
//        shapeV.setAdapter(adapter);
//
//    }


    private void WeightSuggestion() {

        auto= ( AutoCompleteTextView ) findViewById(R.id.wt);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,wt_s);
        auto.setAdapter(adapter);
    }


    public void takeOrders(View view) {
        database d=new database(this);
        t1=findViewById(R.id.date);
        auto=findViewById(R.id.wt);
        t3=findViewById(R.id.name1);
        t4=findViewById(R.id.addr);
        t5=findViewById(R.id.phone);
        Spinner t6=(Spinner)findViewById(R.id.shape);
        t7=findViewById(R.id.o_person);
        String s1=t1.getText().toString();
        String s2=auto.getText().toString();
        String s3=t3.getText().toString();
        String s4=t4.getText().toString();
        String s5=t5.getText().toString();
        String s6=t6.getSelectedItem().toString();
        String s7=t7.getText().toString();
        if(s1.equals("")||s2.equals("")|| s3.equals("") || s4.equals("")){
            Toast.makeText(addOrder.this, "First 4 field are required", Toast.LENGTH_SHORT).show();
        }else {
            boolean fl = d.insert_data(s1, s2, s3, s4, s5, s6, s7, s1);
            if (fl) {
//                    Log.i("this", "onClick:  is working data inserted");
                Toast.makeText(addOrder.this, "Order is done", Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getApplicationContext(), shapeArr[i], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}