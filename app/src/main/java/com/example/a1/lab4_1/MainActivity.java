package com.example.a1.lab4_1;

import android.net.UrlQuerySanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URLStreamHandlerFactory;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainActivity extends AppCompatActivity {
       View urlEditText;
       View goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.editText);
        goButton = findViewById(R.id.bottom);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取网址
                String url = urlEditText.getText().toString();
                Intent intent = new Intent();
                //将url字符串解析为uri对象
                Uri uri = Uri.parse(url);
                //设置data
                intent.setData(uri);
                //设置动作为ACTION_VIEW，为了启动隐式Intent
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }
}
