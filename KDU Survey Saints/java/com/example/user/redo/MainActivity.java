package com.example.user.redo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNext = findViewById(R.id.button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";
                RadioGroup rg = findViewById(R.id.radio_1);
                if(rg.getCheckedRadioButtonId() == -1)
                    error += "Frequency not selected\n";
                EditText edt = findViewById(R.id.text_2);

                if(edt.getText().toString().replaceAll(" ","").length() == 0)
                    error += "Reason not inputted\n";

                int[] cbId = new int[]{R.id.box_3_1,R.id.box_3_2,R.id.box_3_3,R.id.box_3_4};
                for(int i = 0; i < cbId.length; i++)
                {
                    CheckBox cb = findViewById(cbId[i]);
                    if(cb.isChecked())
                        break;
                    if(i == 3)
                        error += "Favourite food(s) not checked\n";
                }
                rg = findViewById(R.id.radio_9);
                if(rg.getCheckedRadioButtonId() == -1)
                    error+= "Recommendation not selected\n";

                if(error.length() != 0) {
                    Toast toast = Toast.makeText(MainActivity.this,error,Toast.LENGTH_LONG);
                    TextView t = toast.getView().findViewById(android.R.id.message);
                    if(t != null)
                        t.setGravity(Gravity.CENTER);
                    toast.show();
                    return;
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Survey Submitted!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, EndActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
            }
        });
    }
}
