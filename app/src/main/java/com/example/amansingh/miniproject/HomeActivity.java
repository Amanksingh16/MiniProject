package com.example.amansingh.miniproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button upload , calc, calendar , urlbtn , exit;
    TextView user;
    EditText url;
    ImageView photo;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        upload = (Button)findViewById(R.id.upload);
        calc = (Button)findViewById(R.id.calc);
        calendar = (Button)findViewById(R.id.convertor);
        urlbtn = (Button)findViewById(R.id.urlbutton);
        exit = (Button)findViewById(R.id.exit);
        url = (EditText)findViewById(R.id.url);
        photo = (ImageView)findViewById(R.id.photo);
        user = (TextView)findViewById(R.id.name);
        i = getIntent();
        user.setText(user.getText()+" "+i.getStringExtra("user"));

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 100);
            }
        });
        calc.setOnClickListener(this);
        calendar.setOnClickListener(this);
        urlbtn.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.calc)
        {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        if(v.getId()==R.id.convertor)
        {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_CALENDAR);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        if(v.getId()==R.id.urlbutton)
        {
            String urlvalue = url.getText().toString();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(urlvalue));
            startActivity(i);
        }
        else
        if(v.getId()==R.id.exit)
        {
             finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100)
        {
            if(resultCode == RESULT_OK)
            {
                Bundle b = data.getExtras();
                Bitmap image = (Bitmap)b.get("data");
                photo.setImageBitmap(image);
                Toast.makeText(HomeActivity.this,"Photo Uploaded",Toast.LENGTH_LONG).show();
            }
            else
                if(resultCode == RESULT_CANCELED)
                {
                    Toast.makeText(HomeActivity.this,"User cancelled",Toast.LENGTH_LONG).show();
                }
        }
    }
}
