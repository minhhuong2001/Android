package com.example.formvalidate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private EditText mssv, fullname, cccd, phone, email;
    private CheckBox rule;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // register buttons with their proper IDs.
        submit = findViewById(R.id.submit_button);

        // register all the EditText fields with their IDs.
        mssv = (EditText) findViewById(R.id.mssv);
        fullname = (EditText) findViewById(R.id.fullname);
        cccd = (EditText) findViewById(R.id.cccd);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);

        rule = (CheckBox) findViewById(R.id.rule);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    completeForm();
                }
            }
        });
    }

    private void completeForm()
    {
        Toast toast = Toast.makeText(this, R.string.toast_submit,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    private boolean CheckAllFields() {
        boolean flag = true;

        if (mssv.length() == 0) {
            mssv.setError("MSSV can not be empty!");
            flag = false;
        }
        if (fullname.length() == 0) {
            fullname.setError("Full Name can not be empty!");
            flag = false;
        }
        if (cccd.length() == 0) {
            cccd.setError("CCCD can not be empty!");
            flag = false;
        }
        if (phone.length() == 0) {
            phone.setError("Phone number can not be empty!");
            flag = false;
        }
        if (email.length() == 0) {
            email.setError("Email address can not be empty!");
            flag = false;
        }
        if (!rule.isChecked()) {
            Toast toast = Toast.makeText(this, R.string.toast_message,
                    Toast.LENGTH_SHORT);
            toast.show();
            flag = false;
        }

        return flag;
    }
}