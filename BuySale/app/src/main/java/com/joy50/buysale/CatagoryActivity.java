package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.joy50.buysale.DatabaseQuary.lists;
import static com.joy50.buysale.DatabaseQuary.loadedCatagoryNames;

public class CatagoryActivity extends AppCompatActivity {

    private RecyclerView catagoryRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        String title = getIntent().getStringExtra("CatagoryName");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        catagoryRecyclerview = findViewById(R.id.catagoryRecyclerView);
        LinearLayoutManager testingLinearLayout = new LinearLayoutManager(this);
        testingLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        catagoryRecyclerview.setLayoutManager(testingLinearLayout);
        //List<HomePageModel> homePageModelList = new ArrayList<>();
        HomePageAdapter homePageAdapter;
        int listPos = 0;
        for (int i= 0;i<DatabaseQuary.loadedCatagoryNames.size();i++){
            if (DatabaseQuary.loadedCatagoryNames.get(i).equals(title.toUpperCase())){
                listPos = i;
            }
        }
        if (listPos == 0){
            loadedCatagoryNames.add(title.toUpperCase());
            lists.add(new ArrayList<HomePageModel>());
            homePageAdapter = new HomePageAdapter(lists.get(loadedCatagoryNames.size()-1));
            DatabaseQuary.setFragmentData(homePageAdapter,getApplicationContext(),loadedCatagoryNames.size()-1,"Home");
        }else {
            homePageAdapter = new HomePageAdapter(lists.get(listPos));
        }
        catagoryRecyclerview.setAdapter(homePageAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.main_search_icon){
            //todo:Need a search Activity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
