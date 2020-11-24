package com.example.demo1.Model.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {


    //Инициализируем создание бд с определенным именем и   версией
    public MyDbHelper(@Nullable Context context) {
        super(context, MyConstants.DB_NAME, null, MyConstants.DB_VERSION);
    }

    //Метод, работающий при первом создании бд
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Передаем команду на создание таблицы
        db.execSQL(MyConstants.CREATE_TABLE_STRUCTURE);
    }

    //Вызывается при изменении бд
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Передаем команду на удаление
        db.execSQL(MyConstants.DELETE_TABLE_STRUCTURE);
        onCreate(db);
    }
}
