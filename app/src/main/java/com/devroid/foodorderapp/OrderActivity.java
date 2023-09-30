package com.devroid.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.devroid.foodorderapp.Adapters.OrdersAdapter;
import com.devroid.foodorderapp.Models.OrdersModel;
import com.devroid.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        getOrders();





    }

    public void getOrders() {
        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();
         if(list.size()>0){
             binding.orderRecyclerView.setVisibility(View.VISIBLE);
             binding.empty.setVisibility(View.GONE);
             LinearLayoutManager layoutManager=new LinearLayoutManager(this);
             binding.orderRecyclerView.setLayoutManager(layoutManager);
             OrdersAdapter adapter = new OrdersAdapter(list,OrderActivity.this);
             adapter.notifyDataSetChanged();
             binding.orderRecyclerView.setAdapter(adapter);
         }else
         {
             binding.orderRecyclerView.setVisibility(View.GONE);
             binding.empty.setVisibility(View.VISIBLE);
         }


    }
}