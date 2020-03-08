package com.example.tasklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<NoteDetails> {
    public CustomListAdapter(Context context, ArrayList<NoteDetails> note) {
        super(context, 0, note);
    }

    @Override
    public View getView(int position, View row, ViewGroup parent){
        NoteDetails current_note = getItem(position); //get the current row of the adapter

        //check to see if the row exists (reused / recreated) or not and set it
        if(row == null)
            row = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);

        //getting the elements of my row view

        ImageView note_priority = (ImageView)row.findViewById(R.id.note_priority);
        TextView note_title = (TextView)row.findViewById(R.id.note_title);
        TextView note_description = (TextView)row.findViewById(R.id.note_description);
        TextView note_date = (TextView)row.findViewById(R.id.note_date);
        //CheckBox note_checkBox = (CheckBox)row.findViewById(R.id.note_checkBox);

        //setting these elements from the contact

        note_priority.setImageResource(current_note.getShape());
        note_title.setText(current_note.getTitle());
        note_description.setText(current_note.getDescription());
        note_date.setText(current_note.getDate());
        //note_checkBox.setChecked(current_note.getChecked());



        return row;
    }

}
