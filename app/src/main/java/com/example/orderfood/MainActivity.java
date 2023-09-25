package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnOrderFood, btnOrderDrink;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOrderFood = (Button) findViewById(R.id.button_order);
        btnOrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        btnOrderDrink = (Button) findViewById(R.id.button_drink);
        btnOrderDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        //button close
        exitButton = (Button) findViewById(R.id.button_exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView resultTextView = findViewById(R.id.result);


        if (data != null) {
            String selectedFood = data.getStringExtra("selectedFood");
            if (selectedFood == null || selectedFood.length() < 1)
                selectedFood = "<Bấm vào nút đặt đồ ăn để hiện thông tin món ăn>";
            String selectedDrink = data.getStringExtra("selectedDrink");
            if (selectedDrink == null || selectedDrink.length() < 1)
                selectedDrink = "<Bấm vào nút đặt đồ uống để hiện thông tin đồ uống>";


            if (requestCode == 1 && resultCode == RESULT_OK) {
                // Now, you have the selected food in the 'selectedFood' variable
                // Set this value to your TextView in the MainActivity

                String currentText = resultTextView.getText().toString();
                String newText = selectedFood;

                if (newText.length() > 0) {
                    if (currentText.contains(" - ")) {
                        // Replace existing food text
                        String[] parts = currentText.split(" - ");
                        newText = selectedFood + " - " + parts[1];
                    } else {
                        // Append food text
                        newText = selectedFood + " - " + "<Bấm vào nút đặt đồ uống để hiện thông tin đồ uống>";
                    }

                    resultTextView.setText(newText);
                }
            }

            if (requestCode == 2 && resultCode == RESULT_OK) {

                String currentText = resultTextView.getText().toString();
                String newText = selectedDrink;

                if (newText.length() > 0) {
                    if (currentText.contains(" - ")) {
                        // Replace existing drink text
                        String[] parts = currentText.split(" - ");
                        newText = parts[0] + " - " + selectedDrink;
                    } else {
                        // Append drink text
                        newText = "<Bấm vào nút đặt đồ ăn để hiện thông tin món ăn>" + " - " + selectedDrink;
                    }

                    resultTextView.setText(newText);
                }
            }
        }
    }

}