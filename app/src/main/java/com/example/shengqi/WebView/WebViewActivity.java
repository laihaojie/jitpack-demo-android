package com.example.shengqi.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.shengqi.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        w = findViewById(R.id.m_web);
        // 本地Url
        w.loadUrl("file:///android_asset/offline.html");
//        w.loadUrl("https://m.baidu.com");

        // 网络地址
        w.getSettings().setJavaScriptEnabled(true);

        w.setWebViewClient(new MyWebViewClient());


        w.setWebChromeClient(new MyWebChromeClient());
//        w.evaluateJavascript();
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
    }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView", "onPageStarted: 网页开始加载");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView", "onPageStarted: 网页加载完成");
            w.loadUrl("javascript:alert('Hello')",null);

        }
    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK && w.canGoBack()){
            w.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}