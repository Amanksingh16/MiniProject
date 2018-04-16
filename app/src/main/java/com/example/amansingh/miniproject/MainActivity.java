package com.example.amansingh.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText user , pass;
    Button submit , reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText)findViewById(R.id.username1);
        pass = (EditText)findViewById(R.id.password1);
        submit = (Button)findViewById(R.id.submit1);
        reset = (Button)findViewById(R.id.reset1);

        submit.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.submit1)
        {
            String username = user.getText().toString();
            String password = pass.getText().toString();
            if(username.equals("Aman") && password.equalsIgnoreCase( "Aman"))
            {
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                i.putExtra("user",username);
                startActivity(i);
                finish();
            }
        }
        else
            if(v.getId()==R.id.reset1)
            {
                 user.setText("");
                 pass.setText("");
            }
    }
}
