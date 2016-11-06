package com.daniel.employeetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CheckInActivity extends AppCompatActivity {

    TextView greeting;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        user = FirebaseAuth.getInstance().getCurrentUser();
        greeting = (TextView) findViewById(R.id.helloEmployeeText);
        if(user != null)
        {
            greeting.setText("Hi " + user.getDisplayName() + ",");
        }

    }
}
