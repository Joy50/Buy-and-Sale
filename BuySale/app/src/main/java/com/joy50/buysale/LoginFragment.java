package com.joy50.buysale;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }


    private ImageView crossButton;
    private EditText emailData,passwordData;
    private TextView forgetPass,dontHaveanAccount;
    private Button loginButton;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private FrameLayout parentFrameLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        crossButton = view.findViewById(R.id.crossreg);
        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MenuActivity.class));
                getActivity().finish();
            }
        });

        emailData = view.findViewById(R.id.emailForm);
        passwordData = view.findViewById(R.id.password);
        forgetPass = view.findViewById(R.id.forgetpass);
        progressBar = view.findViewById(R.id.progress);
        loginButton = view.findViewById(R.id.loginbutton);
        dontHaveanAccount = view.findViewById(R.id.donthaveanid);
        parentFrameLayout = getActivity().findViewById(R.id.loginRegister);
        auth = FirebaseAuth.getInstance();
        progressBar.setVisibility(View.INVISIBLE);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo:Login using email & password using firebase
                String email = (String) emailData.getText().toString();
                String pass = (String) passwordData.getText().toString();
                progressBar.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && isValid(email)) {
                    auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Todo:Change Activity
                            if (task.isSuccessful()){
                                progressBar.setVisibility(View.INVISIBLE);
                                startActivity(new Intent(getActivity(),MenuActivity.class));
                                getActivity().finish();
                            }
                            else{
                                Toast.makeText(getActivity(),"Login Failed",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }else if (TextUtils.isEmpty(email)){
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getActivity(),"Email is Empty",Toast.LENGTH_SHORT).show();
                } else if (!isValid(email)){
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getActivity(),"Email is not Valid",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(pass)){
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getActivity(),"Pass is Empty",Toast.LENGTH_SHORT).show();
                }else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getActivity(),"Blank Email & Password",Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo:Forgot password
                setTranscation(new ResetPasswordFragment());
            }
        });

        dontHaveanAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: Signup Account
                setTranscation(new RegisterFragment());
            }
        });
        return view;
    }

    private static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private void setTranscation(Fragment fragment) {
        FragmentTransaction transition = getActivity().getSupportFragmentManager().beginTransaction();
        transition.replace(parentFrameLayout.getId(),fragment);
        transition.commit();
    }
}
