package com.example.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemLists extends AppCompatActivity {
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
        setContentView(R.layout.activity_item_lists);
        showItems();
    }

    private void showItems() {
        ListView l=findViewById(R.id.list);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");
        arrayList.add("Amod"+"\n"+"9807894206"+"\n");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        l.setAdapter(adapter);

    }
}