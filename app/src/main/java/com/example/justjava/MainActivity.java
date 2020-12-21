/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.example.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int pricePerCup = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText text = (EditText)findViewById(R.id.name_field);
        String name = text.getText().toString(); // Chaining method call

        //Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out if the user want chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice();
        displayMessage(createOrderSummary(name, price, hasWhippedCream, hasChocolate));
    }

    /**
     * Calculates the price of the order.
     * @return total price.
     */
    private int calculatePrice() {
        return quantity * pricePerCup;
    }

    /**
     * Creates the order Summary.
     *
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAddWhippedcream: " + addWhippedCream;
        priceMessage += "\nAddChocolate: " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $";
        priceMessage += price + "\nThankyou!";
        return priceMessage;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment (View view) {
        quantity = quantity + 1;
        displayQuntity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement (View view) {
        quantity = quantity - 1;
        displayQuntity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuntity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}