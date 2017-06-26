package com.example.android.filei_o;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private String fileName ="MyFile";
    private OutputStream out;
    private InputStream in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText) findViewById(R.id.etInput);
        textView =(TextView) findViewById(R.id.tvResult);

    }

    public void load(View view) throws IOException {
        in = openFileInput(fileName);
        File file = getFileStreamPath(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String output ="";
        while((line= br.readLine()) != null){
            output += (line);
            output+= '\n';

        }
        textView.setText(output);
        in.close();

    }



    public void save(View view) throws IOException {
        out =openFileOutput(fileName,Context.MODE_PRIVATE);
        out.write(editText.getText().toString().getBytes());
        out.close();
    }
}
