package com.Booting;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataKamus extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "dbkamus";
	
	public static final String INGGRIS = "inggris";
	public static final String INDONESIA = "indonesia";
	public static final String BATAK = "batak";
	
	//Constructor DataKamus untuk initiate database
	public DataKamus(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	//Method createTable untuk membuat table kamus
	public void createTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS kamus");
		db.execSQL("CREATE TABLE if not exists kamus (id INTEGER PRIMARY KEY AUTOINCREMENT, inggris TEXT, indonesia TEXT, batak TEXT);");
	}
	
	//Method generateData untuk mengisikan data ke kamus.
	public void generateData(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		cv.put(INGGRIS,"lari");
		cv.put(INDONESIA, "run");
		cv.put(BATAK, "kiam");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "jalan");
		cv.put(INDONESIA, "walk");
		cv.put(BATAK, "erdalan");
		
		db.insert("kamus", "INGGRIS", cv);
		
		cv.put(INGGRIS, "bangun");
		cv.put(INDONESIA, "wakeup");
		cv.put(BATAK, "medak");
		
		db.insert("kamus", "INGGRIS", cv);
		
		
		cv.put(INGGRIS, "membaca");
		cv.put(INDONESIA, "read");
		cv.put(BATAK, "ngoge");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "tidur");
		cv.put(INDONESIA, "sleep");
		cv.put(BATAK, "tunduh");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "makan");
		cv.put(INDONESIA, "eat");
		cv.put(BATAK, "man");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "mandi");
		cv.put(INDONESIA, "bath");
		cv.put(BATAK, "ridi");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "siapa");
		cv.put(INDONESIA, "who");
		cv.put(BATAK, "ise");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "air");
		cv.put(INDONESIA, "water");
		cv.put(BATAK, "lau");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "ia");
		cv.put(INDONESIA, "yes");
		cv.put(BATAK, "uwe");
		
		db.insert("kamus", INGGRIS, cv);
		
		cv.put(INGGRIS, "tidak");
		cv.put(INDONESIA, "no");
		cv.put(BATAK, "lang");
		
		db.insert("kamus", INGGRIS, cv);
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//TODO Auto-generated method stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//TODO Auto-generated method sub
		 
		
	}
	
}
