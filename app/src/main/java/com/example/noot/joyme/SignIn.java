package com.example.noot.joyme;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends AppCompatActivity {

    private static final String TAG = "SignIn";
    private EditText edtUsername, edtPassword;
    private Button btnSignin, btnSignUp;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();
        initInstances();
    }

    private void initInstances(){
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignin = (Button) findViewById(R.id.btnSignIn);

        btnSignUp.setOnClickListener(listener);
        btnSignin.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();

            switch (v.getId()){
                case R.id.btnSignUp :
                    signUp(username,password);
                    break;
                case R.id.btnSignIn:
                    signIn(username,password);
                    break;
            }
        }
    };

    //sign in to application
    private void signIn(String username, String password){
        if(!username.isEmpty()) {
            mAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
//                                Log.w(TAG, "signInWithEmail:failed", task.getException());
                                Toast.makeText(SignIn.this, "Sign in fail",
                                        Toast.LENGTH_SHORT).show();
                            }else{
                                finish();
                                startActivity(new Intent(SignIn.this,Profile.class));
                            }

                            // ...
                        }
                    });
        }else{
            Toast.makeText(SignIn.this, "Please input username",
                    Toast.LENGTH_SHORT).show();
        }
    }

    //go to registration page
    private void signUp(String username, String password){
        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignIn.this, "Sign up fail",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SignIn.this, "Account created",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
