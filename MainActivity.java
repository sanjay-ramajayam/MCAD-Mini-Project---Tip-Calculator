package com.example.tipcalculator; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.TextView; 
import androidx.appcompat.app.AppCompatActivity; 
public class MainActivity extends AppCompatActivity { 
    private EditText billAmountInput, tipPercentageInput; 
    private TextView tipAmountOutput, totalBillOutput; 
    private Button calculateButton; 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        billAmountInput = findViewById(R.id.billAmountInput); 
        tipPercentageInput = findViewById(R.id.tipPercentageInput); 
        tipAmountOutput = findViewById(R.id.tipAmountOutput); 
        totalBillOutput = findViewById(R.id.totalBillOutput); 
        calculateButton = findViewById(R.id.calculateButton); 
        // Set up button click listener 
        calculateButton.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                calculateTip(); 
            } 
        }); 
    } 
    private void calculateTip() { 
        // Get user input 
        String billInput = billAmountInput.getText().toString(); 
        String tipInput = tipPercentageInput.getText().toString(); 
        if (!billInput.isEmpty() && !tipInput.isEmpty()) { 
            double billAmount = Double.parseDouble(billInput); 
            double tipPercentage = Double.parseDouble(tipInput); 
            // Calculate tip and total 
            double tipAmount = billAmount * (tipPercentage / 100); 
            double totalBill = billAmount + tipAmount; 
            // Display results 
            tipAmountOutput.setText(String.format("Tip Amount: ₹%.2f", tipAmount)); 
            totalBillOutput.setText(String.format("Total Bill: ₹%.2f", totalBill)); 
        } else { 
            tipAmountOutput.setText("Please enter valid inputs."); 
            totalBillOutput.setText(""); 
        }
}
}
