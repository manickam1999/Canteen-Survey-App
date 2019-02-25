package com.example.user.redo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        Button btn = (Button) findViewById(R.id.btnTitle);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        EditText edt = (EditText) findViewById(R.id.editTitle);

        if (edt.getText().toString().length() == 0)
        {
            Toast.makeText(getBaseContext(),"Please Input ID First!",Toast.LENGTH_LONG).show();
            return;
        }
        else if(edt.getText().toString().length() != 7  )
        {
            Toast.makeText(getBaseContext(),"Please Input the 7 Digit ID",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        this.finish();
    }
}