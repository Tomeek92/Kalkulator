package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText distanceInput, consumptionInput, priceInput, passengersInput;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distanceInput = findViewById(R.id.distance_input);
        consumptionInput = findViewById(R.id.consumption_input);
        priceInput = findViewById(R.id.price_input);
        passengersInput = findViewById(R.id.passengers_input);
        calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double distance = Double.parseDouble(distanceInput.getText().toString());
                double consumption = Double.parseDouble(consumptionInput.getText().toString());
                double price = Double.parseDouble(priceInput.getText().toString());
                int passengers = Integer.parseInt(passengersInput.getText().toString());

                double fuelCost = (distance / 100) * consumption * price;
                double fuelCostPerPerson = fuelCost / passengers;
                double costPer100km = fuelCost / distance * 100;


                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("fuelCost", fuelCost);
                intent.putExtra("fuelCostPerPerson", fuelCostPerPerson);
                intent.putExtra("costPer100km", costPer100km);
                startActivity(intent);
            }
        });
    }
}