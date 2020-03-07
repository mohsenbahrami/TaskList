package com.example.tasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <NoteDetails> note ;
    CustomListAdapter adapter;
    Context context;
    NoteDetails noteDetails;
    ListView ltView;

    String subject;
    String description;
    String date;
    int status;
    int[]images ={R.drawable.square_green,R.drawable.square_yellow,R.drawable.square_red};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        note = new ArrayList<NoteDetails>();
        adapter = new CustomListAdapter(this,note);
        ltView = (ListView)findViewById(R.id.listView);
        ltView.setAdapter(adapter);
        //adapter.add(new NoteDetails("mohsen","hi bahrami","today",1,1));

    }

}

