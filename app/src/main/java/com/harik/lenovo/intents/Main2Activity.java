package com.harik.lenovo.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {
Button b=null;
    RadioGroup rg=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b=(Button)findViewById(R.id.btnDevise);
        rg=(RadioGroup) findViewById(R.id.group);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        Intent i = getIntent();
        String data=null;
int c=rg.getCheckedRadioButtonId();
        //RadioButton rb=(RadioButton) findViewById(R.id.mad);
        //rb.isChecked();
switch (c){
    case R.id.$:data="$";break;
    case R.id.€:data="€";break;
    case R.id.mad:data="MAD";break;
}        i.putExtra("devise",data);
setResult(1,i);
        super.finish();
    }
}
