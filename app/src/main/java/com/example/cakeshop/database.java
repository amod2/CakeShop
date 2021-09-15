package com.example.cakeshop;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname = "sanvi.db";

    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q = "create table sanvicake(id integer  primary key autoincrement,date text,weight text,name text,address text,phone text,shape text,orderPerson text,o_date text)";
        String q2="create table bill_lists(bill_number integer primary key autoincrement,bill_data text)";
        sqLiteDatabase.execSQL(q);
        sqLiteDatabase.execSQL(q2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists sanvicake");
        sqLiteDatabase.execSQL("drop table if exists bill_lists");
        onCreate(sqLiteDatabase);
    }
    public boolean insert_bill(String bill_data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("order_data",bill_data);
        long r = db.insert("bill_lists", null, c);
        if (r == -1)
            return false;
        else
            return true;
    }
    public Cursor getBillNumber (){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from bill_lists", null);
        return cursor;

    }


    public boolean insert_data(String date, String weight, String name, String address, String phone, String shape, String o_person, String o_date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("date", date);
        c.put("weight", weight);
        c.put("name", name);
        c.put("address", address);
        c.put("phone", phone);
        c.put("shape", shape);
        c.put("orderPerson", o_person);
        c.put("o_date", o_date);
        long r = db.insert("sanvicake", null, c);
        if (r == -1)
            return false;
        else
            return true;
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from sanvicake", null);
        return cursor;

    }
    public Cursor getTodayOrders (String cdate)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from sanvicake where date = ?", new String[]{cdate} , null);
        return cursor;

    }
}
