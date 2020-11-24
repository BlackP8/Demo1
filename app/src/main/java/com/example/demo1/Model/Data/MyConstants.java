package com.example.demo1.Model.Data;

public class MyConstants {

    //Задаем названия столбцов таблицы
    public static final String TABLE_NAME = "Income";
    public static final String _ID = "_id";
    public static final String AMOUNT = "Amount";
    public static final String TYPE = "Type";
    public static final String NOTE = "Note";
    public static final String DATE = "Date";
    public static final String DB_NAME = "bill.db";
    /* Версия нужна для фиксации изменений в структуре бд.
       Например при изменении или добавлении колонны необходимо
       присвоить номеру версии другое значение*/
    public static final int DB_VERSION = 1;

    //Константа, создающая структуру таблицы
    public static final String CREATE_TABLE_STRUCTURE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY, " +
                    AMOUNT + " INTEGER, " + TYPE + " TEXT, " +
                    NOTE + " TEXT, " + DATE + " TEXT" + ");";

    //Константа, удаляющая структуру таблицы
    public static final String DELETE_TABLE_STRUCTURE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
