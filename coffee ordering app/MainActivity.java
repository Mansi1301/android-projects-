/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.editText1);
        String name= text.getText().toString();

        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.checkbox_whip);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_choco);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String summary = createOrderSummary(price,hasWhippedCream, hasChocolate, name);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL , new String[] { "justjava@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, summary);

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        return "Name: " + name + "\nAdd whipped cream? " + hasWhippedCream + "\nAdd chocolate? " + hasChocolate + "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank you!";
    }

    /**
     * Calculates the price of the order.
     *
     * param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;
        if(hasWhippedCream)
            basePrice=basePrice + 1 ;
        if(hasChocolate)
            basePrice=basePrice + 2 ;

        return basePrice * quantity ;
    }

    public void increment(View view) {
        if(quantity==100) {
            Toast.makeText(this,"You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity= quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity==1){
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity= quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}