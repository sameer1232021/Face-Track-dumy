package org.tensorflow.lite.examples.classification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ResetPassword extends AppCompatActivity {
    //Variables
    private EditText emailEditText;
    private Button resetB;
    private ImageView backB;
    private Dialog progressBar;
    private TextView dialog;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        //Initialization
        auth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.email);
        resetB = findViewById(R.id.resetB);
        backB = findViewById(R.id.backB);

        progressBar = new Dialog(ResetPassword.this);
        progressBar.setContentView(R.layout.dialog_layout);
        progressBar.setCancelable(false);
        progressBar.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialog = progressBar.findViewById(R.id.dialog_text);
        dialog.setText("Reset Password...");

        resetB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
        progressBar.show();
        String email = emailEditText.getText().toString().trim();
        if(email.isEmpty()) {
            emailEditText.setError("Email is required");
            emailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please provide valid Email Id");
            emailEditText.requestFocus();
            return;
        }
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressBar.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(ResetPassword.this,"Check your email to reset password !", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ResetPassword.this,"Something went wrong. Please try again later !", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
