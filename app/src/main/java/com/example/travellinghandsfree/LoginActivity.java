package com.example.travellinghandsfree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Enter Button
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(loginButtonListener);
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
