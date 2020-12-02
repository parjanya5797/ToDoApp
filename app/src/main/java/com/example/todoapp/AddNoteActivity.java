package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker priorityNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.title);
        editTextDescription = findViewById(R.id.description);
        priorityNo= findViewById(R.id.priority);

        priorityNo.setMinValue(1);
        priorityNo.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");

    }

    private void SaveNote()
    {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = priorityNo.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty())
        {
            Toast.makeText(this, "Please Enter a Title and Description", Toast.LENGTH_SHORT).show();
            return;
        }


    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.save_note:
                SaveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}