package com.devroid.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.devroid.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("foodname");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.pricelbl.setText(String.valueOf(price));
            binding.foodName.setText(name);
            binding.detailDescripton.setText(description);



            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nameBox = binding.nameBox.getText().toString();
                    String phoneBox = binding.phoneBox.getText().toString();
                    if (!nameBox.isEmpty() && !phoneBox.isEmpty()) {

                        boolean isInserted = helper.insertOrder(
                                nameBox,
                                phoneBox,

                                price,
                                image,
                                description,
                                name,

                                Integer.parseInt(binding.quantity.getText().toString())

                        );
                        if (isInserted)
                            Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();

                        else
                            Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(DetailActivity.this, "All fields are mandatory !!", Toast.LENGTH_SHORT).show();
                    }
                }
            });




        }else {



            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(5);
           // Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();
            binding.detailImage.setImageResource(image);
            binding.pricelbl.setText(String.format("%d",cursor.getInt(3)));
            binding.nameBox.setText(cursor.getString(1));
            binding.detailDescripton.setText(cursor.getString(6));
            binding.foodName.setText(cursor.getString(7));
            binding.phoneBox.setText(cursor.getString(2));

            binding.insertBtn.setText("Update order");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isUpdated = helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.pricelbl.getText().toString()),
                            image,
                            binding.detailDescripton.getText().toString(),
                           binding.foodName.getText().toString(),
                            1,
                            id

                    );

                   if(isUpdated)
                       Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                   else
                       Toast.makeText(DetailActivity.this, "Failed.", Toast.LENGTH_SHORT).show();
                }
            });



        }


    }
}