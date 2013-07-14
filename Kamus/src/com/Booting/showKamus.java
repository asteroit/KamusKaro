package com.Booting;

import android.app.Activity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;

public class showKamus extends Activity {
    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private EditText txtInggris;
    private EditText txtIndonesia;
    private EditText txtBatak;
    private DataKamus datakamus = null;
    public static final String INDONESIA = "indonesia";
    public static final String INGGRIS = "inggris";
    public static final String BATAK = "batak";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datakamus = new DataKamus(this);
        db = datakamus.getWritableDatabase();
        datakamus.createTable(db);
        datakamus.generateData(db);
        
        setContentView(R.layout.main);
        txtInggris = (EditText) findViewById(R.id.txtInggris);
        txtIndonesia = (EditText) findViewById(R.id.txtIndonesia);
        txtBatak = (EditText) findViewById(R.id.txtBatak);
    }
    
    public void getTerjemahan(View view) {
    	String result= "";
    	String result2= "";
    	
    	String englishword = txtInggris.getText().toString();
    	kamusCursor = db.rawQuery("SELECT ID, INGGRIS, INDONESIA, BATAK " + "FROM kamus where INGGRIS = '" + englishword + "'ORDER BY INGGRIS", null); 
    
    	//Membaca data dari kamusCursor dan menampungnya di result
    	//Membaca string di index 2 yaitu bahasa inggris
    	if (kamusCursor.moveToFirst()) {
    		result = kamusCursor.getString(2);
    		for (;!kamusCursor.isAfterLast(); kamusCursor.moveToNext()) {
    			result = kamusCursor.getString(2);
    	}
    	}
    	
    	//Membaca data dari kamusCursor dan menampungnya di result
    	//Membaca string di index 3 yaitu bahasa batak
    	if (kamusCursor.moveToFirst()) {
    		result2 = kamusCursor.getString(3);
    		for (;!kamusCursor.isAfterLast(); kamusCursor.moveToNext()) {
    			result2 = kamusCursor.getString(3);
    		}
    	}
    	
    	//Menampilkan not found jika data tidak sesuai atau tidak ada di database
    	if (result.equals("")) {
    		result = "Word Not Found";
    	}
    	
    	if (result2.equals("")) {
    		result2 = "Kai kin nindu e pal ?";
    	}
    	
    	//Menampilkan datanya setelah ditampung
    	txtIndonesia.setText(result);
    	txtBatak.setText(result2);
    	}
    
    	@Override
    	public void onDestroy() {
    		super.onDestroy();
    		kamusCursor.close();
    		db.close();
    	}
    }
