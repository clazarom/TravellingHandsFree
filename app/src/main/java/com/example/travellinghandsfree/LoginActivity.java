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

    View.OnClickListener loginButtonListener = view -> startSpecificActivity(MainActivity.class);

    private void startSpecificActivity(Class<?> otherActivityClass){
        startActivity(new Intent(getApplicationContext(), otherActivityClass));
    }
}
