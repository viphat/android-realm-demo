package com.gdg.database.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gdg.database.R;

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
