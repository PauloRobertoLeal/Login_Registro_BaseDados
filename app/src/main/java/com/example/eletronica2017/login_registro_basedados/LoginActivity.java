package com.example.eletronica2017.login_registro_basedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button bt_login;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        bt_login = (Button) findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(LoginActivity.this, "Username não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Password não inserida, tente novamente", Toast.LENGTH_SHORT).show();
                } else {
                    //tudo OK
                    String res = db.ValidarLogin(username, password);

                    if (res.equals("OK")) {
                        Toast.makeText(LoginActivity.this, "Login OK", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login errado, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
