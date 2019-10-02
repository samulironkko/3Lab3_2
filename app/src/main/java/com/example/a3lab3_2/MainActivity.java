package com.example.a3lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements WebPageFetcher.MyInterface, View.OnClickListener {

    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

    }

    @Override
    public void returnContent(String content) {
        textView.setText(content);
    }

    @Override
    public void onClick(View v) {
        WebPageFetcher webPageFetcher = new WebPageFetcher(this, editText.getText().toString());
        webPageFetcher.start();

    }
}
