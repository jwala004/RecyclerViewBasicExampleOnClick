package com.jwala.recyclerviewbasicexampleonclick;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeDetailsActivity extends AppCompatActivity {

    private TextView tv_employee_id, tv_employee_name;
    private ImageView iv_profile_icon;
    EmployeeModel employeeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        iv_profile_icon = findViewById(R.id.iv_profile_icon);
        tv_employee_id = findViewById(R.id.tv_employee_id);
        tv_employee_name = findViewById(R.id.tv_employee_name);

        getIncomingIntent();

    }

    private void getIncomingIntent() {

        if (getIntent().hasExtra("employeeDetailsPosition")) {

            employeeModel = getIntent().getParcelableExtra("employeeDetailsPosition");

            iv_profile_icon.setImageResource(employeeModel.getImage());
            tv_employee_id.setText(String.valueOf(employeeModel.getId()));
            tv_employee_name.setText(employeeModel.getName());

        }

    }
}
