package com.cuc.infoapp.service

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(val city:String) {
    private val createBook="create table City(" +
            "city char primary key autoincrement)"

//    override fun onCreate(db: SQLiteDatabase?) {
//        db?.execSQL(createBook)
//        Toast.makeText(context,"Create succeeded", Toast.LENGTH_SHORT).show()
//    }
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion:Int, newVersion:Int){
//
//    }
}