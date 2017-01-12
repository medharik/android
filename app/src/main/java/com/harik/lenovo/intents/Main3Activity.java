package com.harik.lenovo.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import static android.R.attr.data;

public class Main3Activity extends AppCompatActivity {
WebView wb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_3);
        wb=(WebView) findViewById(R.id.web);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("http://www.eurosport.fr");
        Toast.makeText(this,"chargement de la page ",Toast.LENGTH_LONG).show();

        Intent i=getIntent();
      Uri data= i.getData();
        Toast.makeText(this,"chargement de la page "+data.getHost(),Toast.LENGTH_LONG).show();       // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kooora.com")));

    }
}
