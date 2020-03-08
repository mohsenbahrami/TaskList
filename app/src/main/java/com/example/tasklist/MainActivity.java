package com.example.tasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <NoteDetails> note ;
    CustomListAdapter adapter;
    Context context;
    NoteDetails noteDetails;
    ListView ltView;

    String subject;
    String description;
    String date ;
    int status ;
    int[]images ={R.drawable.square_green,R.drawable.square_yellow,R.drawable.square_red};
    int i ;
    EditText mainTitle;
    EditText mainDescription;
    RadioGroup radioGroup;
    RadioButton mainLow;
    RadioButton mainMedium;
    RadioButton mainHigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        note = new ArrayList<NoteDetails>();
        adapter = new CustomListAdapter(this,note);
        ltView = (ListView)findViewById(R.id.listView);
        ltView.setAdapter(adapter);




    }

    public void newTask(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Get the layout inflater
            final LayoutInflater inflater = this.getLayoutInflater();
            final View view = inflater.inflate(R.layout.entredialog, null);

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            alertDialogBuilder.setView(view);
            mainTitle = (EditText)findViewById(R.id.input_newTask);
            mainDescription = (EditText)findViewById(R.id.input_description);
             radioGroup = (RadioGroup)findViewById(R.id.input_radioGroup);
             mainLow = (RadioButton)findViewById(R.id.rb_low);
             mainMedium = (RadioButton)findViewById(R.id.rb_medium);
             mainHigh = (RadioButton)findViewById(R.id.rb_high);

            //get elements from the dialog view
            final EditText passTitle = (EditText)view.findViewById(R.id.input_newTask);
            final EditText passDescription = (EditText)view.findViewById(R.id.input_description);
            final RadioGroup passradioGroup = (RadioGroup)view.findViewById(R.id.input_radioGroup);
            final RadioButton passLow = (RadioButton)view.findViewById(R.id.rb_low);
            final RadioButton passMedium = (RadioButton)view.findViewById(R.id.rb_medium);
            final RadioButton passHigh = (RadioButton)view.findViewById(R.id.rb_high);

            //3. Set positive buton

        alertDialogBuilder.setPositiveButton("ADD",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(),"You clicked ADD button",Toast.LENGTH_LONG).show();
                    }
                });
        //4. Set negative buton
        alertDialogBuilder.setNegativeButton("CENCEL",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.dismiss();
                        Toast.makeText(getApplicationContext(),"You clicked no button",Toast.LENGTH_LONG).show();
                    }
                });



        AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }



