package com.jwala.recyclerviewbasicexample;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// 1 - on click on a recyclerView item sending data to next Activity ( sending data to next activity in recyclerview using interface implementation )
// 2- implementation of horizontal and vertical recyclerView is done.
//
public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnClickListener {

    RecyclerView recyclerView;
    private List<EmployeeModel> employeeModelListtttt;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        employeeModelListtttt = new ArrayList<>();

//        employeeModelListtttt.add(new EmployeeModel(100));
//        employeeModelListtttt.add(new EmployeeModel(100));
//        employeeModelListtttt.add(new EmployeeModel(100));

//        employeeModelListtttt.add(new EmployeeModel(100,"jwala"));
//        employeeModelListtttt.add(new EmployeeModel(100,"jwala"));
//        employeeModelListtttt.add(new EmployeeModel(100,"jwala"));
//        employeeModelListtttt.add(new EmployeeModel(100,"jwala"));

        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.images));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.ic_launcher_background));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.images));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.backgtound_png));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.dd));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.github));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.images));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.backgtound_png));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.images));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.github));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.images));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.backgtound_png));
        employeeModelListtttt.add(new EmployeeModel(100, "Jwala Kumar", R.drawable.images));

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, employeeModelListtttt, this);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        to make the RecyclerView horizontal, just set the orientation as Horizontal in new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onItemClick(int position) {

        Intent employeeDetails = new Intent(MainActivity.this,EmployeeDetailsActivity.class);
        employeeDetails.putExtra("employeeDetailsPosition", employeeModelListtttt.get(position));
        startActivity(employeeDetails);

    }
}
