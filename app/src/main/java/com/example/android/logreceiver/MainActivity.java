package com.example.android.logreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String intentType = intent.getType();
        Bundle intentExtras = intent.getExtras();

        setContentView(R.layout.activity_main);
        AppCompatTextView textView = findViewById(R.id.textView);

        if (intentType == null || intentExtras == null) {
            return;
        }

        String text = intent.getExtras().getString(Intent.EXTRA_HTML_TEXT);
        if (text != null) {
            textView.setText(Html.fromHtml(text));
            return;
        }

        text = intent.getExtras().getString(Intent.EXTRA_TEXT);

        if (text != null) {
            textView.setText(text);
        }
    }
}
