package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button btn = (Button) findViewById(R.id.login_button);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText username = (EditText)findViewById(R.id.username);
                EditText password = (EditText)findViewById(R.id.password);
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                  Intent intent = new Intent(getApplicationContext(), ChooseFinalPlanActivity.class);
                    startActivity(intent);
                    Database d=new Database(getApplicationContext());
                    d.insertUtente(1, username.getText().toString(), password.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(), "Username o Password sbagliate",Toast.LENGTH_SHORT).show();
                    //wrong password
                }

            }
        });

        }
    }