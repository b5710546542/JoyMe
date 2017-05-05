package com.example.noot.joyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    private EditText edtNewUsername, edtNewPassword, edtConfirmPassword;
    private Button btnSubmitAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    private void initInstances(){
        edtNewUsername = (EditText) findViewById(R.id.edtUsername);
        edtNewPassword = (EditText) findViewById(R.id.edtNewPassword);
        edtConfirmPassword = (EditText) findViewById(R.id.edtConfirmPassword);
        btnSubmitAccount = (Button) findViewById(R.id.btnSubmitAccount);

        btnSubmitAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create new account

                //go to sign in page

            }
        });
    }
}
