package org.tensorflow.lite.examples.classification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText name, emailID, password, confirm;
    private Button signupb;
    private ImageView back;
    FirebaseAuth mAuth;
    private String nameString, emailString, passwordString, confirmString;
    private Dialog progressBar;
    private TextView dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.name);
        emailID = findViewById(R.id.emailSign);
        password = findViewById(R.id.passwordSign);
        confirm = findViewById(R.id.confirmSign);
        signupb = findViewById(R.id.signupB);
        back = findViewById(R.id.back);
        mAuth = FirebaseAuth.getInstance();

        progressBar = new Dialog(SignUpActivity.this);
        progressBar.setContentView(R.layout.dialog_layout);
        progressBar.setCancelable(false);
        progressBar.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialog = progressBar.findViewById(R.id.dialog_text);
        dialog.setText("Signing in...");

        //back button implementation
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Sign up button implementation
        signupb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    signUpNewUser();
                }
            }
        });


    }

    //Validate the details given
    private boolean validate() {
        nameString = name.getText().toString().trim();
        emailString = emailID.getText().toString().trim();
        passwordString = password.getText().toString().trim();
        confirmString = confirm.getText().toString().trim();

        if (nameString.isEmpty()) {
            name.setError("Enter your name");
            return false;
        }

        if (emailString.isEmpty()) {
            emailID.setError("Enter your email ID");
            return false;
        }

        if (passwordString.isEmpty()) {
            password.setError("Enter your password");
            return false;
        }

        if (confirmString.isEmpty()) {
            confirm.setError("Confirm your password");
            return false;
        }

        if (passwordString.compareTo(confirmString) != 0) {
            Toast.makeText(SignUpActivity.this, "Password don't match", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void signUpNewUser() {
        progressBar.show();

        mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressBar.dismiss();
                            Toast.makeText(SignUpActivity.this, "Sign Up successful!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUpActivity.this, ClassifierActivity.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            progressBar.dismiss();
                            Toast.makeText(SignUpActivity.this,
                                    "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            //Toast.makeText(SignUpActivity.this, "Something went wrong ! Please Try again later !",
                            //      Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
