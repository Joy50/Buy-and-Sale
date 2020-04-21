package com.joy50.buysale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class LoginRegisterActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    public static boolean setSignUpFragment = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        frameLayout = findViewById(R.id.loginRegister);
        if(setSignUpFragment){
            setSignUpFragment = false;
            setFragment(new RegisterFragment());
        }else {
            setFragment(new LoginFragment());
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.replace(frameLayout.getId(),fragment);
        transition.commit();
    }
}
