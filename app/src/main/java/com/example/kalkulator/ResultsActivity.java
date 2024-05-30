
package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView fuelCostTextView, fuelCostPerPersonTextView, costPer100kmTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        fuelCostTextView = findViewById(R.id.fuel_cost);
        fuelCostPerPersonTextView = findViewById(R.id.fuel_cost_per_person);
        costPer100kmTextView = findViewById(R.id.cost_per_100km);

        double fuelCost = getIntent().getDoubleExtra("fuelCost", 0);
        double fuelCostPerPerson = getIntent().getDoubleExtra("fuelCostPerPerson", 0);
        double costPer100km = getIntent().getDoubleExtra("costPer100km", 0);

        fuelCostTextView.setText("Koszt paliwa: " + fuelCost + " zł");
        fuelCostPerPersonTextView.setText("Koszt paliwa na osobę: " + fuelCostPerPerson + " zł");
        costPer100kmTextView.setText("Koszt przejechania 100 km: " + costPer100km + " zł");

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });
    }
}