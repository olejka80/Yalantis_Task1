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

public class MainActivity extends AppCompatActivity implements OnItemClickListener,
        View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setNavigationIcon(R.drawable.button_back);
        toolbar.setTitle(R.string.title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, getResources()
                            .getString(R.string.button_back), Toast.LENGTH_SHORT).show();
                    finish();
                }
            });


        ArrayList<Uri> photos = new ArrayList<>();
        photos.add(Uri.parse("http://wyr.com.ua/files/lviv/jura_9.jpg"));
        photos.add(Uri.parse("http://vsitury.com.ua/uploads/48/2588/P5.jpg"));
        photos.add(Uri.parse("http://vsitury.com.ua/uploads/48/2786/P2.jpg"));
        photos.add(Uri.parse("http://visittoukraine.com/uploads/images/news/lvov(3).jpg"));
        photos.add(Uri.parse("http://vsitury.com.ua/uploads/107/3175/P4.jpg"));

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(photos, this, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager
                .HORIZONTAL, false);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(myRecyclerAdapter);

        }

        TextView tvOffer = (TextView) findViewById(R.id.tvOffer);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);
        if (tvOffer != null) {
            tvOffer.setOnClickListener(this);
        }
        if (tvDescription != null) {
            tvDescription.setOnClickListener(this);
        }

    }

    @Override
    public void OnPhotoClick(int position) {
        Toast.makeText(MainActivity.this, getResources()
                .getString(R.string.photo_number) + (position + 1), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tvOffer:
                Toast.makeText(MainActivity.this, getResources()
                        .getString(R.string.offer), Toast.LENGTH_SHORT).show();
                break;

            case R.id.tvDescription:
                Toast.makeText(MainActivity.this, getResources()
                        .getString(R.string.descr), Toast.LENGTH_SHORT).show();
                break;
        }

    }
}