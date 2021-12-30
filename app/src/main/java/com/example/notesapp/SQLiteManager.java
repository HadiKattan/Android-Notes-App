package com.example.notesapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Notes.db";
    private static final String TABLE_NAME = "Notes";
    private static final int DATABASE_VERSION = 1;


    public SQLiteManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Title TEXT, Description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Notes");
        onCreate(db);
    }
    public void populateNoteToArrayList(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlQuery = "SELECT * FROM Notes";
        ArrayList<Note> notes = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery,null);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String desc = cursor.getString(2);
            Note n = new Note(id,title,desc);
            Note.notes.add(n);
        }
    }
    public void addNoteToDatabase(Note n){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "INSERT INTO "+TABLE_NAME+" VALUES('"+n.getId()+"','"+n.getTitle()+"','"+n.getDescription()+"')";
        db.execSQL(sqlInsert);
        db.close();
    }

}
