package com.example.android.bookinventoryapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.android.bookinventoryapp.data.BookContract.BookEntry;
import com.example.android.bookinventoryapp.data.BookDbHelper;

public class MainActivity extends AppCompatActivity {
    BookDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new BookDbHelper(this);
        insertBook();
        dataReader();
    }
    @Override
    protected void onStart() {
        super.onStart();
        insertBook();
    }

    private void insertBook(){
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(BookEntry.PRODUCT_NAME, "Book");
        values.put(BookEntry.PRODUCT_PRICE, 5);
        values.put(BookEntry.PRODUCT_QUANTITY, 5);
        values.put(BookEntry.PRODUCT_SUPPLIER_NAME, "supplier name");
        values.put(BookEntry.PRODUCT_SUPPLIER_PHONE, "0005552223");

        long newRowId = database.insert(BookEntry.TABLE_NAME, null, values);
        if(newRowId== -1){
            Log.v("MainActivity","Error no new entry " + newRowId);
        }else{
            Log.v("MainActivity","New row ID " + newRowId);
        }
    }
    private Cursor dataReader(){

        SQLiteDatabase db= mDbHelper.getReadableDatabase();
        //        projection
        String[] projection ={
                BookEntry._ID,
                BookEntry.PRODUCT_NAME,
                BookEntry.PRODUCT_PRICE,
                BookEntry.PRODUCT_QUANTITY,
                BookEntry.PRODUCT_SUPPLIER_NAME,
                BookEntry.PRODUCT_SUPPLIER_PHONE
        };

        Cursor cursor = db.query(
                BookEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        try{
            Log.v("MainActivity","it's working? " + cursor.getCount());
        }finally {
            cursor.close();
        }
        return cursor;
    }
}
