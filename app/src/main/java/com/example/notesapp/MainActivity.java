package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
     ListView noteListView;
     NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        noteListView = (ListView) findViewById(R.id.noteListView);
        noteAdapter=new NoteAdapter(this,R.layout.note_cell,Note.notes);
        SQLiteManager sqLiteManager = new SQLiteManager(this);
        sqLiteManager.populateNoteToArrayList();
        noteListView.setAdapter(noteAdapter);
    }

    public void newNote(View view){
        Intent i = new Intent(this,NoteDetailActivity.class);
        startActivity(i);
    }
    public void load(){

    }
}