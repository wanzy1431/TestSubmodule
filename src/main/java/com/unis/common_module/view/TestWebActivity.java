package com.unis.common_module.view;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.unis.common_module.R;

public class TestWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web);
        WebView webview = (WebView) findViewById(R.id.wb);
        webview.loadUrl("file:///android_asset/webtest.html");
    }
}