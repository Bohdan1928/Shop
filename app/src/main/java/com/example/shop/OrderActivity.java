package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class OrderActivity extends AppCompatActivity {
    String[] address = {"bbigun2000@gmail.com"};
    String subject = "Order from Music Shop";
    String emailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userName");
        String instrumentName = orderIntent.getStringExtra("instrumentName");
        int orderQuantity = orderIntent.getIntExtra("orderQuantity", 0);
        int price = orderIntent.getIntExtra("price", 0);

        emailText = "Customer name: " + userName + "\n"
                + "Product name: " + instrumentName + "\n"
                + "Quantity: " + orderQuantity + "\n"
                + "Price: " + price + "\n" +"Order Price: " + orderQuantity * price;
        TextView orderList = findViewById(R.id.orderList);
        orderList.setText(emailText);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}