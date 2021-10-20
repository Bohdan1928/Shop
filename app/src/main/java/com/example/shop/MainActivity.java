package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int quantity = 0;
    private Spinner spinner;
    private HashMap<String, Integer> hashMap;
    TextView textPrice;
    EditText editTextPersonName;

    String name;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeSpinner();
        initializeHashMap();
        editTextPersonName = findViewById(R.id.editTextPersonName);
    }

    public void initializeHashMap() {
        hashMap = new HashMap();
        hashMap.put("Guitar", 700);
        hashMap.put("Drum", 1500);
        hashMap.put("Keyboard", 1000);
    }

    public void initializeSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayList<String> spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Drum");
        spinnerArrayList.add("Keyboard");

        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void increaseQuantity(View view) {
        quantity += 1;
        TextView numberQuantity = findViewById(R.id.numberQuantity);
        numberQuantity.setText("" + quantity);
        textPrice = findViewById(R.id.textPrice);
        textPrice.setText("" + quantity * price);
    }

    public void decreaseQuantity(View view) {
        quantity -= 1;
        if (quantity == -1) {
            quantity = 0;
        }
        TextView numberQuantity = findViewById(R.id.numberQuantity);
        numberQuantity.setText("" + quantity);
        textPrice = findViewById(R.id.textPrice);
        textPrice.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        name = spinner.getSelectedItem().toString();
        price = hashMap.get(name);
        textPrice = findViewById(R.id.textPrice);
        textPrice.setText("" + quantity * price);

        ImageView imageView2 = findViewById(R.id.imageView2);
        switch (name) {
            case "Guitar":
                imageView2.setImageResource(R.drawable.guitar);
                break;
            case "Keyboard":
                imageView2.setImageResource(R.drawable.piano);
                break;
            case "Drum":
            default:
                imageView2.setImageResource(R.drawable.drumset);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addCart(View view) {
        Order order = new Order();

        order.setUserName(editTextPersonName.getText().toString());
        order.setInstrumentName(name);
        order.setOrderQuantity(quantity);
        order.setPrice(price * quantity);

        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userName", order.getUserName());
        orderIntent.putExtra("instrumentName", order.getInstrumentName());
        orderIntent.putExtra("orderQuantity", order.getOrderQuantity());
        orderIntent.putExtra("price", order.getPrice());
        startActivity(orderIntent);
    }
}