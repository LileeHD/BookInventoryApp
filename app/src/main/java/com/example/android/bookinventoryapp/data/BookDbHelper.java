package com.example.android.bookinventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.bookinventoryapp.data.BookContract.BookEntry;

public class BookDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Inventory.db";

    public BookDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_BOOK_TABLE = "CREATE TABLE "
                + BookEntry.TABLE_NAME + " ("
                + BookEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BookEntry.PRODUCT_NAME + " TEXT NOT NULL, "
                + BookEntry.PRODUCT_PRICE + " INTEGER NOT NULL, "
                + BookEntry.PRODUCT_QUANTITY + " INTEGER NOT NULL, "
                + BookEntry.PRODUCT_SUPPLIER_NAME + " TEXT,"
                + BookEntry.PRODUCT_SUPPLIER_PHONE + " LONG NOT NULL );";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
