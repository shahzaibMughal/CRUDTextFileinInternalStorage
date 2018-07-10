package com.shahzaib.crudtextfileininternalstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createTextFile(View view) {
        startActivity(new Intent(this,CreateTextFile.class));
    }

    public void deleteTextFile(View view) {
        //NOTE:  we know, we have stored the file in internal storage in directory returned by getFilesDir() method
        File directory = getFilesDir();
        File file = new File(directory, CONSTANTS.TEXT_FILE_NAME);
        if(file.exists())
        {
            if(file.delete())
            {
                Toast.makeText(this, "File Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Error! while deleting the file", Toast.LENGTH_SHORT).show();

            }
        }
        else
        {
            Toast.makeText(this, "File Not Exists", Toast.LENGTH_SHORT).show();
        }
    }

    public void readTextDataFromFile(View view) {
        startActivity(new Intent(this,ReadTextFile.class));
    }

}
