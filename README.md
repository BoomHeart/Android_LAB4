# LAB4实验报告

## 一、实验要求：

1、自定义WebView验证隐式Intent的使用

2、新建一个工程用来获取URL地址并启动Intent

## 二、实验过程：

1、自定义WebView验证隐式Intent的使用

代码：

activity_main.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"/>
    <Button
        android:id="@+id/buttom"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"/>
</LinearLayout>
```

MainActivity.java:

```java
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
```

不知为何urlEditText.getText().toString()语句无法使用。
