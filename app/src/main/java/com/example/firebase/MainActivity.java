package com.example.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
   // private  Button buttonuserlogin;
     private EditText editTextusename;
     private EditText editTextpassword;

     private FirebaseAuth firebaseAuth;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();

        buttonRegister=(Button) findViewById(R.id.buttonregister);
        //buttonuserlogin=(Button) findViewById(R.id.Userlogin);
        editTextusename=(EditText) findViewById(R.id.Username);
        editTextpassword=(EditText) findViewById(R.id.Password);
       // buttonuserlogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);



    }
private void  buttonregister(){
        String usename=editTextusename.getText(). toString().trim();
        String password= editTextpassword.getText().toString().trim();
        if(TextUtils.isEmpty(usename)){
            Toast.makeText(this,"Please enter username",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){

            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

firebaseAuth.createUserWithEmailAndPassword(usename, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"   register successfuly",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"   can't  register successfuly",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    @Override
    public  void onClick(View view) {
        if (view == buttonRegister) {

            buttonregister();
        }
       /* if (view == buttonuserlogin) {


        }*/
    }
}
