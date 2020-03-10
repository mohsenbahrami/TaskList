package com.example.tasklist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String currentDate;
    ArrayList<NoteDetails> note;
    CustomListAdapter adapter;
    Context context;
    NoteDetails noteDetails;
    ListView ltView;
    EditText mainTitle,mainDescription,mainDate;
    TextView title, description;
    ImageView shape;
    RadioGroup radioGroup;
    RadioButton mainLow,mainMedium,mainHigh;
    Button newTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = new ArrayList<NoteDetails>();
        adapter = new CustomListAdapter(this, note);
        ltView = (ListView) findViewById(R.id.listView);
        ltView.setAdapter(adapter);
        context = this;

        ltView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                noteDetails= (NoteDetails) adapter.getItem(position);
                noteDetails.setChecked(!noteDetails.getChecked());
                adapter.notifyDataSetChanged();
            }
        });


        ltView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                displayInformation(view, position);

                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }


    //Creating Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    //Sorting Tasks based on Priority and Status
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.sort_priority_des) {
            note.sort(new Comparator<NoteDetails>() {
                @Override
                public int compare(NoteDetails o1, NoteDetails o2) {
                    return o1.getShape() - o2.getShape();
                }
            });
            adapter.notifyDataSetChanged();
            return true;

        } else if (id == R.id.sort_status_asc) {
            note.sort(new Comparator<NoteDetails>() {
                @Override
                public int compare(NoteDetails o1, NoteDetails o2) {
                    return (o2.getChecked() ? 1 : 0) - (o1.getChecked() ? 1 : 0);
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void newTask(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Get the layout inflater
        final LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.entredialog, null);
        //get elements from the dialog view

//      // Inflate and set the layout for the dialog
//       // Pass null as the parent view because its going in the dialog layout
        alertDialogBuilder.setView(view);
        mainTitle = (EditText)view.findViewById(R.id.input_newTask);
        mainDescription = (EditText) view.findViewById(R.id.input_description);
        radioGroup = (RadioGroup) view.findViewById(R.id.input_radioGroup);
        mainLow = (RadioButton) view.findViewById(R.id.rb_low);
        mainMedium = (RadioButton) view.findViewById(R.id.rb_medium);
        mainHigh = (RadioButton) view.findViewById(R.id.rb_high);
        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());


        //3. Set positive buton
        alertDialogBuilder.setPositiveButton("ADD",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        noteDetails = new NoteDetails();
                        noteDetails.setTitle(mainTitle.getText().toString());
                        noteDetails.setDescription(mainDescription.getText().toString());
                        noteDetails.setDate(currentDate);

                        if (mainLow.isChecked()) {
                            noteDetails.setShape(R.drawable.square_green);
                        } else if (mainMedium.isChecked()) {
                            noteDetails.setShape(R.drawable.square_yellow);
                        } else if (mainHigh.isChecked()) {
                            noteDetails.setShape(R.drawable.square_red);
                        }
                        adapter.add(new NoteDetails(noteDetails.getTitle(),noteDetails.getDescription(),noteDetails.getDate(),noteDetails.getShape()));

                    }
                });
        //4. Set negative buton
        alertDialogBuilder.setNegativeButton("CENCEL",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.dismiss();
                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void displayInformation(View v, int position) {

        final NoteDetails t = (NoteDetails) adapter.getItem(position);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dispalydailog, null);
        alertDialogBuilder.setView(view);

        title = (TextView) view.findViewById(R.id.display_title);
        description = (TextView) view.findViewById(R.id.dispaly_description);
        shape = (ImageView) view.findViewById(R.id.dispaly_shape);

        title.setText(t.getTitle());
        description.setText(t.getDescription());
        shape.setImageResource(t.getShape());

        alertDialogBuilder.setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        adapter.remove(t);
                    }
                });

        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}





