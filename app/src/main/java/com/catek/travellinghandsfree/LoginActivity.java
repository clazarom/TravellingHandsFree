package com.catek.travellinghandsfree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    //Tag for the logs
    private static final String TAG = "LOGIN_ACTIVITY";
    //Firebase authenticator
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Enter Button
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(loginButtonListener);

        //Authenticate
        //Initialize the FirebaseAuth object
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth .getCurrentUser();
        if(currentUser != null){
            //User signed in - update with reload activity and finish app
            reload();
            finishApplication();
        }
    }

    /**
     * Reload the Activity
     */
    private void reload(){
        //Trigger the onCreate() method
        this.recreate();
    }

    /**
     * Finish the application
     */
    private void finishApplication(){
        finishAndRemoveTask();
    }

    private final View.OnClickListener loginButtonListener = view -> startNonExportedActivity(MainActivity.class);

    /**
     * Start an specific Activity that is not exported. To do so, the method hast o use an explicit
     * Intent.
     * @param activityClass class of the activity to be started
     */
    private void startNonExportedActivity(Class<?> activityClass){
        Intent explicitIntent = new Intent(getApplicationContext(), activityClass);
        //explicitIntent.setPackage(getApplicationContext().getPackageName());
        startActivity(explicitIntent);
    }
}
