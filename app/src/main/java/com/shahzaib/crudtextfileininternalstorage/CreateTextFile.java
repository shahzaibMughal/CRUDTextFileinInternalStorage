package com.shahzaib.crudtextfileininternalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTextFile extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_text_file);
        editText = findViewById(R.id.editText);
    }

    public void createTextFile(View view) {
        String data = editText.getText().toString();
        if (!data.isEmpty()) {

            saveDataInInternalStorage(data);

        } else {
            Toast.makeText(this, "Data is Missing", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDataInInternalStorage(String data) {
        // creating the file
        File directory = getFilesDir();
        File file = new File(directory, CONSTANTS.TEXT_FILE_NAME);

        saveDataIntoFile(file, data);
    }

    private void saveDataIntoFile(File file, String data) {
        if(file.exists())
        {
            Toast.makeText(this, "File Updated..", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "New File Created", Toast.LENGTH_SHORT).show();
        }

        try {

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data.getBytes());
            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
            finish();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            CONSTANTS.SHOW_LOG("Exception Occur: " + e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            CONSTANTS.SHOW_LOG("Exception Occur: " + e.toString());
        }
    }


}
