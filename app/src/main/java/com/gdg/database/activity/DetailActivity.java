package com.gdg.database.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gdg.database.R;
import com.gdg.database.database.ProductDAL;
import com.gdg.database.model.Product;

public class DetailActivity extends AppCompatActivity {

    Button insertButton;
    EditText productNameText;
    EditText productCompanyText;
    EditText quantityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Detail Product");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        productNameText = (EditText) findViewById(R.id.product_name);
        productCompanyText = (EditText) findViewById(R.id.product_company);
        quantityText = (EditText) findViewById(R.id.product_quantity);

        insertButton = (Button) findViewById(R.id.add_btn);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                insertProduct();
            }
        });
    }

    private void insertProduct() {
        String productName = productNameText.getText().toString();
        String productCompany = productCompanyText.getText().toString();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityText.getText().toString());

        } catch (Exception ex) {
            quantity = 0;
        }

        Product product = new Product(productName, productCompany, quantity);
        ProductDAL.insertProduct(product);

        // Show to Activity
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
