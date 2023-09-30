package com.devroid.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.devroid.foodorderapp.Adapters.MainAdapter;
import com.devroid.foodorderapp.Models.MainModel;
import com.devroid.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list =new ArrayList<>();
        list.add(new MainModel(R.drawable.burger,"Burger","5","Chicken Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.cake,"Cake","6","BlackForest Cake without egg"));
        list.add(new MainModel(R.drawable.dairymilk,"DairyMilk","7","No.1 Sweet"));
        list.add(new MainModel(R.drawable.maggy,"Maggy","8","The best Snacks forever"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","9","Quality is very Good"));
        list.add(new MainModel(R.drawable.samosa,"Samosa","10","Quality is very Impressive"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}