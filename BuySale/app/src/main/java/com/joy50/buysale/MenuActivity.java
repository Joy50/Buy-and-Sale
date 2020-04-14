package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MenuActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static int CurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        frameLayout = findViewById(R.id.mainframe_layout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);
    }

    private void setFragment(Fragment fragment,int fragmentNO){
        CurrentFragment = fragmentNO;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frameLayout.getId(),fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (CurrentFragment == HOME_FRAGMENT){
            getMenuInflater().inflate(R.menu.mainmenu,menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.search_main_menu:
                //Todo:
            case R.id.cart_main_menu:
                //Todo:
                myCart();
            case R.id.notification_main_menu:
                //Todo:
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void myCart(){
        invalidateOptionsMenu();
        setFragment(new MyCartFragment(),CART_FRAGMENT);
    }
}
