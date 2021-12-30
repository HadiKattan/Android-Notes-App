package com.example.notesapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {
    Context mContext;
    int ressource;
    public NoteAdapter(Context mContext, int ressource, ArrayList<Note> notes) {
        super(mContext, ressource, notes);
        this.mContext = mContext;
        this.ressource = ressource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note n =getItem(position);
        View row;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.note_cell,parent,false);
        TextView title = (TextView) row.findViewById(R.id.cellTitle);
        TextView desc = (TextView) row.findViewById(R.id.cellDesc);
        title.setText(n.getTitle());
        desc.setText(n.getDescription());
        return row;
    }
}
