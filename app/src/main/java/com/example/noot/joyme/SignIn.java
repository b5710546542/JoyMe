package com.example.noot.joyme;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button btnSignin, btnCreateNewAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initInstances();
    }

    private void initInstances(){
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnCreateNewAccount = (Button) findViewById(R.id.btnCreateNewAccount);
        btnSignin = (Button) findViewById(R.id.btnSignIn);

        btnCreateNewAccount.setOnClickListener(listener);
        btnSignin.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnCreateNewAccount :
                    continueCreateAccount();
                    break;
                case R.id.btnSignIn:
                    signIn();
                    break;
            }
        }
    };

    //sign in to application
    private void signIn(){

    }

    //go to registration page
    private void continueCreateAccount(){
        finish();
        startActivity(new Intent(SignIn.this,Registration.class));
    }
}
