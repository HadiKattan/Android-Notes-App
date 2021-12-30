package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoteDetailActivity extends AppCompatActivity {

    EditText title, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        title = (EditText) findViewById(R.id.titleEditText);
        desc = (EditText) findViewById(R.id.descriptionEditText);
    }

    public void saveNote(View view) {
        String t = title.getText().toString();
        String d = desc.getText().toString();
        Log.e("title",t);
        if (t.trim().length() == 0 && d.trim().length()==0){
            title.setError("Title cannot be empty");
            desc.setError("Description cannot be empty");
        }
        else if(t.trim().length()==0)
            title.setError("Title cannot be empty");
        else if(d.trim().length()==0)
            desc.setError("Description cannot be empty");
        else {
            int id = Note.notes.size();
            Note n = new Note(id, t, d);
            SQLiteManager sqLiteManager = new SQLiteManager(view.getContext());
            sqLiteManager.addNoteToDatabase(n);
            Note.notes.add(n);
            finish();
        }
    }
}