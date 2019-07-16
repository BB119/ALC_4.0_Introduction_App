package com.bbexcellence.introduction;

import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAlcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        WebView myWebView = findViewById(R.id.alc_web_view);
        myWebView.setWebViewClient(new MyWebClient());
        myWebView.loadUrl("https://andela.com/alc/");
        myWebView.getSettings().setJavaScriptEnabled(true);

        // Adding the back arrow on top
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private class MyWebClient extends WebViewClient {
        @Override
        public void onReceivedSslError(final WebView view, final SslErrorHandler handler, SslError error) {
            // for SSLErrorHandler
            final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage(R.string.notification_error_ssl_cert_invalid);
            builder.setPositiveButton(getString(R.string.ssl_error_postive_button), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    view.setVisibility(View.VISIBLE);
                    handler.proceed();
                }
            });
            builder.setNegativeButton(getString(R.string.ssl_error_negative_button), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.cancel();
                }
            });
            final AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
