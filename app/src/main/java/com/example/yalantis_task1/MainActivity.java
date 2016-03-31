package com.example.yalantis_task1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.button_back);
            toolbar.setTitle(R.string.title);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, v.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
        setSupportActionBar(toolbar);

        List<Uri> photos = new ArrayList<>();
        photos.add(Uri.parse(getResources().getString(R.string.uri_photo_1)));
        photos.add(Uri.parse(getResources().getString(R.string.uri_photo_2)));
        photos.add(Uri.parse(getResources().getString(R.string.uri_photo_3)));
        photos.add(Uri.parse(getResources().getString(R.string.uri_photo_4)));
        photos.add(Uri.parse(getResources().getString(R.string.uri_photo_5)));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(photos, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager
                .HORIZONTAL, false);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerAdapter);
        }

        TextView tvOffer = (TextView) findViewById(R.id.tvOffer);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);

            tvOffer.setOnClickListener(this);
            tvDescription.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, v.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
    }
}