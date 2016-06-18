package com.gdg.database.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.gdg.database.R;
import com.gdg.database.adapter.ProductAdapter;
import com.gdg.database.database.PrefStore;
import com.gdg.database.database.ProductDAL;
import com.gdg.database.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    List<Product> productList;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Log.e("hqthao", "List activity");

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("List Product");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        productList = new ArrayList<>();
        productList = ProductDAL.getAllList();

        // recycle view
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        ProductAdapter adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setSelection(PrefStore.getSortType(this));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PrefStore.setSortType(ListActivity.this, position);
                productList = ProductDAL.getAllList();
                ProductAdapter adapter = new ProductAdapter(productList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // onBackPressed();
            detailActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void detailActivity() {
        Intent myIntent = new Intent(this, DetailActivity.class);
        startActivity(myIntent);
    }

}