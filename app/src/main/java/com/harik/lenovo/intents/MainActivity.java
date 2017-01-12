package com.harik.lenovo.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b;
    private Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> ad =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        ad.add("Web");
        ad.add("Phone");
        ad.addAll(new String[]{"Call","Map","Recherche map","Photo","mes contacts","Mail","SMS","Activité for result"});
         s=(Spinner)findViewById(R.id.apan);
        s.setAdapter(ad);
         b=(Button)findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
int position =s.getSelectedItemPosition();
                Intent i=null;
                switch (position){
                    case 0:
i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.fr"));
                        startActivity(i);
                        break;
                    case 1:
                        i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0656982439"));
                        startActivity(i);
                        break;
                    case 2:
                        i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0656982439"));
                        startActivity(i);
                        break;

                    case 3:
                        i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:33,-7?z=20"));
                        startActivity(i);
                        break;
                    case 4:
                        i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=query"));
                        startActivity(i);
                        break;
                    case 5:
                        i=new Intent(("android.media.action.IMAGE_CAPTURE"));
                        startActivity(i);
                        break;
                    case 6:
                        i=new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                        startActivity(i);
                        break;


                    case 7:
                      sendEmail();
                        break;
                    case 8:
                        Uri uri = Uri.parse("smsto:" + "0656982439");
                        i = new Intent(Intent.ACTION_SENDTO, uri);
                        i.setPackage("com.whatsapp");
                        startActivity(Intent.createChooser(i, ""));
                        break;
                    case 9:
                      i=new Intent(MainActivity.this,Main2Activity.class);
                        startActivityForResult(i,1);

                        break;

//                        break;
                  default:
                      Toast.makeText(MainActivity.this, "Choix non valide", Toast.LENGTH_LONG).show();

                }

            }
        });






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode==1){
            if (resultCode==1){
Toast.makeText(MainActivity.this,"devise "+data.getStringExtra("devise"),Toast.LENGTH_LONG).show();
            }
        }
    }

    private void sendEmail(){

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + "med.harik@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My email's subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "My email's body");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }



}
