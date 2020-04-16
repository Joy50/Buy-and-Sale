package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;

    private static final int HOME_FRAGMENT = 0;
    private static final int ORDER_FRAGMENT = 1;
    private static final int CART_FRAGMENT = 3;

    private static int CurrentFragment = -1;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        frameLayout = findViewById(R.id.mainframe_layout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);

        mDrawerLayout = findViewById(R.id.navDrawer);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
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
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        if (id == R.id.search_main_menu){
            //todo:
        }else if(id == R.id.cart_main_menu){
            myCart();
        }else if (id == R.id.notification_main_menu){
            //todo:
        }
        return super.onOptionsItemSelected(item);
    }
    private void myCart(){
        invalidateOptionsMenu();
        setFragment(new MyCartFragment(),CART_FRAGMENT);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.home:
                //Todo:
                invalidateOptionsMenu();
                startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                navigationView.getMenu().getItem(0).setChecked(true);
                return true;
            case R.id.myOrders:
                //Todo:
                invalidateOptionsMenu();
                setFragment(new MyOrdersFragment(),ORDER_FRAGMENT);
                navigationView.getMenu().getItem(1).setChecked(true);
                return true;
            case R.id.rewards:
                //Todo:
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.myCart:
                invalidateOptionsMenu();
                myCart();
                navigationView.getMenu().getItem(3).setChecked(true);
                return true;
            case R.id.myWishlist:
                //Todo:
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.myAccount:
                //Todo:
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.signout:
                //Todo:
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                return true;
            default:
                mDrawerLayout.closeDrawer(id);
                return false;
        }
    }

}
