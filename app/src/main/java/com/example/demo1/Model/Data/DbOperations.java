package com.example.demo1.Model.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.demo1.Model.DashboardFragment;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DbOperations {
    private Context context;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase database;

    public DbOperations(Context context) {
        this.context = context;
    }

    //Открытие бд
    public DbOperations openDb() throws SQLException {
        myDbHelper = new MyDbHelper(context);
        database = myDbHelper.getWritableDatabase();
        return this;
    }

    //Запись в бд
    public void insertDb(List<Data> list, int amount, String type, String note, String date) {
        //Создаем новые строки
        ContentValues contentValues = new ContentValues();
        for (Data el: list) {
            contentValues.put(MyConstants.AMOUNT, amount);
            contentValues.put(MyConstants.TYPE, type);
            contentValues.put(MyConstants.NOTE, note);
            contentValues.put(MyConstants.DATE, date);
            //Вставляем строки в таблицу
            database.insert(MyConstants.TABLE_NAME, null, contentValues);
        }
    }

    //Считываем данные
    public List<Data> getFromDb() {
        List<Data> data = new ArrayList<>();
        String columns = "SELECT * FROM " + MyConstants.TABLE_NAME;
        //Указываем считывателю откуда считывать
        database = myDbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(columns, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        //Создаем цикл для перебора элементов
        while (cursor.moveToNext()) {
             int am = cursor.getInt(cursor.getColumnIndex(MyConstants.AMOUNT));
             String ty = cursor.getString(cursor.getColumnIndex(MyConstants.TYPE));
             String no = cursor.getString(cursor.getColumnIndex(MyConstants.NOTE));
             String da = cursor.getString(cursor.getColumnIndex(MyConstants.DATE));
             data.add(new Data(am, ty, no, da));
             Log.d(TAG, "Data: " + data.toString());
        }
        cursor.close();
        database.close();
        return data;
    }

    //Закрытие бд
    public void closeDb() {
        myDbHelper.close();
    }
}
