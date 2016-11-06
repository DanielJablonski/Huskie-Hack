package com.daniel.employeetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EmployeeList extends AppCompatActivity {

    ArrayList<String> items;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase fireRef = FirebaseDatabase.getInstance();
    DatabaseReference ref = fireRef.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        items = new ArrayList<>();
        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        items.add("John");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EmployeeList.this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        ref.child("employee").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(int i =0; i < dataSnapshot.getChildrenCount(); i++)
                {
                    items.add(dataSnapshot.child("employee" + Integer.toString(i+1)).getValue().toString());
                }
                Log.d("DONKEY", dataSnapshot.child("employee1").getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("DONKEY", "FAILED");
            }
        });

    }
}
