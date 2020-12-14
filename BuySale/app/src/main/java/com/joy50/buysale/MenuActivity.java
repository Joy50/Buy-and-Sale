package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import static com.joy50.buysale.LoginRegisterActivity.setSignUpFragment;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;

    private static final int HOME_FRAGMENT = 0;
    private static final int ORDER_FRAGMENT = 1;
    private static final int MYREWARDS_FRAGMENT = 2;
    private static final int CART_FRAGMENT = 3;
    private static final int WISHLIST_FRAGMENT = 4;
    private static final int ACCOUNT_FRAGMENT = 5;
    public static Boolean showCart = false;

    private int CurrentFragment = -1;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView noInternetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        frameLayout = findViewById(R.id.mainframe_layout);
        navigationView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.navDrawer);
        mDrawerLayout = findViewById(R.id.navDrawer);
        navigationView.setNavigationItemSelectedListener(this);
        noInternetImage = findViewById(R.id.no_internet_connection);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        ///Testing purpose
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(networkInfo != null && networkInfo.isConnected()==true){
            noInternetImage.setVisibility(View.GONE);
            if (showCart) {
                //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                setFragment(new MyCartFragment(), -2);
            } else {
                setFragment(new HomeFragment(), HOME_FRAGMENT);
            }
        }else {
            //Todo:no internet connection
            Glide.with(getApplicationContext()).load(R.drawable.noconnection).into(noInternetImage);
            noInternetImage.setVisibility(View.VISIBLE);
        }
    }

    private void setFragment(Fragment fragment, int fragmentNO) {
        CurrentFragment = fragmentNO;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frameLayout.getId(), fragment);
        transaction.commit();
    }

    public void cartDialog(){
        final Dialog signIn = new Dialog(MenuActivity.this);
        signIn.setContentView(R.layout.sign_in_dialogue);
        signIn.setCancelable(true);
        signIn.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        Button signInBtn = signIn.findViewById(R.id.signIn);
        Button signUpBtn = signIn.findViewById(R.id.signup);
        final Intent registerIntent = new Intent(MenuActivity.this,LoginRegisterActivity.class);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn.dismiss();
                setSignUpFragment = false;
                startActivity(registerIntent);
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn.dismiss();
                setSignUpFragment = false;
                startActivity(registerIntent);
            }
        });
        signIn.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (CurrentFragment == HOME_FRAGMENT) {
            getMenuInflater().inflate(R.menu.mainmenu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)||(id == android.R.id.home)){
            if (mActionBarDrawerToggle.onOptionsItemSelected(item)){
                return true;
            }else if(id == android.R.id.home){
                if (showCart){
                    showCart = false;
                    finish();
                }
            }
        }
        if (id == R.id.search_main_menu) {
            //todo:
        } else if (id == R.id.cart_main_menu) {
            //myCart();
            cartDialog();
        } else if (id == R.id.notification_main_menu) {
            //todo:
        }
        return super.onOptionsItemSelected(item);
    }

    private void myCart() {
        invalidateOptionsMenu();
        setFragment(new MyCartFragment(), CART_FRAGMENT);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            invalidateOptionsMenu();
            setFragment(new HomeFragment(), HOME_FRAGMENT);
            //navigationView.getMenu().getItem(0).setChecked(true);
        } else if (id == R.id.myOrders) {
            invalidateOptionsMenu();
            setFragment(new MyOrdersFragment(), ORDER_FRAGMENT);
            //navigationView.getMenu().getItem(1).setChecked(true);
        } else if (id == R.id.rewards) {
            invalidateOptionsMenu();
            setFragment(new MyRewardsFragment(), MYREWARDS_FRAGMENT);
            //navigationView.getMenu().getItem(2).setChecked(true);
        } else if (id == R.id.myCart) {
            invalidateOptionsMenu();
            myCart();
            //navigationView.getMenu().getItem(3).setChecked(true);
        } else if (id == R.id.myWishlist) {
            invalidateOptionsMenu();
            setFragment(new MyWishListFragment(), WISHLIST_FRAGMENT);
            //navigationView.getMenu().getItem(4).setChecked(true);
        } else if (id == R.id.myAccount) {
            //Todo:
            invalidateOptionsMenu();
            setFragment(new MyAccountFragment(), ACCOUNT_FRAGMENT);
            //navigationView.getMenu().getItem(5).setChecked(true);
        } else if (id == R.id.signout) {
            //Todo:
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (CurrentFragment == HOME_FRAGMENT) {
                CurrentFragment = -1;
                super.onBackPressed();
            } else {
                if (showCart) {
                    showCart = false;
                    finish();
                } else {
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(), HOME_FRAGMENT);
                    navigationView.getMenu().getItem(0).setChecked(true);
                }
            }
        }
    }
}
