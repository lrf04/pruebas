package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    Button boton,reproducir,parar;
    WebView webView;
    public MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio);
        boton=(Button)findViewById(R.id.botonLlamar);
        webView=(WebView)findViewById(R.id.webView);

        reproducir=(Button)findViewById(R.id.reproducir);
        parar=(Button)findViewById(R.id.parar);


        reproducir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp=MediaPlayer.create(getApplicationContext(),R.raw.musica);
                mp.start();
            }
        });
        parar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp.stop();
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.youtube.com/watch?v=7KPyunRIjr0");
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
                webView.loadUrl(request.getUrl().toString());
                return false;
            }


        });

        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                llamar();
            }
        });
    }

    private void llamar(){
        int permissionCheck= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR);
        Uri uri=Uri.parse("tel:9981663748");
        Intent intent=new Intent(Intent.ACTION_CALL,uri);
        startActivity(intent);
    }
}