package com.example.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkActivity  extends AppCompatActivity {
    Button exitButton2,confirmButton;
    RadioButton r_a, r_b, r_c, r_d;
    String orderedDrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink_activity);


        RadioGroup options = findViewById(R.id.list_item);
        String[] listOrderDrink = getResources().getStringArray(R.array.list_order_drink);
        if (listOrderDrink.length > 0) {
            for (int i = 0; i < listOrderDrink.length; i++) {
                RadioButton radioButton = (RadioButton) options.getChildAt(i);
                radioButton.setText(listOrderDrink[i]);
                radioButton.setChecked(false);
            }

            r_a = findViewById(R.id.item_1);
            r_b = findViewById(R.id.item_2);
            r_c = findViewById(R.id.item_3);
            r_d = findViewById(R.id.item_4);


            confirmButton = findViewById(R.id.button_confirm);
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(r_a.isChecked()){
                        orderedDrink = (String) r_a.getText();
                    } else if(r_b.isChecked()){
                        orderedDrink = (String) r_b.getText();
                    } else if(r_c.isChecked()){
                        orderedDrink = (String) r_c.getText();
                    } else if(r_d.isChecked()){
                        orderedDrink = (String) r_d.getText();
                    } else {
                        Toast.makeText(DrinkActivity.this, "Bạn phải chọn 1 đồ uống để thực hiện chức năng này!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("selectedDrink", orderedDrink);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            });

            exitButton2 = findViewById(R.id.button_exit_2);
            exitButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Go back to the main activity
                    finish();
                }
            });
        }
    }
}
