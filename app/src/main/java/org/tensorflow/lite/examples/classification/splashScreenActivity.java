package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class splashScreenActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static int SPLASH_SCREEN = 4000;

    //Animation variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView text, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //hooks
        image = findViewById(R.id.icon);
        text = findViewById(R.id.ic_text);
        slogan = findViewById(R.id.ic_slogan);

        image.setAnimation(topAnim);
        text.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // FirebaseUser currentUser = mAuth.getCurrentUser();
                if(mAuth.getCurrentUser() != null){
                    Intent intent = new Intent(splashScreenActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    splashScreenActivity.this.finish();
                }

                else {
                    Intent intent = new Intent(splashScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();
    }
}