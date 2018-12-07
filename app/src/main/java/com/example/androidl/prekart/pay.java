package com.example.androidl.prekart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class pay extends AppCompatActivity {

    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);


        String url="paytm.com/login?redirect=%2F";
        setContentView(R.layout.activity_pay);
        wb=(WebView)findViewById(R.id.webview);
        WebSettings websetting=wb.getSettings();
        websetting.setJavaScriptEnabled(true);
        wb.loadUrl("http://"+ url);
        wb.setWebViewClient(new WebViewClient());

    }
}
