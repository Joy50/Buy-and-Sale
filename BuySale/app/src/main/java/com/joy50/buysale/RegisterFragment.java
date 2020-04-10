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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    private ImageView crossBtn;
    private EditText nameData,emailData,passwordData,confirmPasswordData;
    private ProgressBar progressBar;
    private Button signUpButton;
    private FirebaseAuth auth;
    private FrameLayout parentFrameLayout;
    private TextView alreadyHaveanAccount;
    private FirebaseFirestore firestore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        parentFrameLayout = getActivity().findViewById(R.id.loginRegister);
        crossBtn = view.findViewById(R.id.crossreg);
        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MenuActivity.class));
                getActivity().finish();
            }
        });
        nameData = view.findViewById(R.id.name);
        emailData = view.findViewById(R.id.emailAddress);
        passwordData = view.findViewById(R.id.password);
        confirmPasswordData = view.findViewById(R.id.confirmpassword);
        progressBar = view.findViewById(R.id.progressBar);
        signUpButton = view.findViewById(R.id.signup);
        alreadyHaveanAccount = view.findViewById(R.id.alreadyHaveanAccount);
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        progressBar.setVisibility(View.INVISIBLE);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: Create Account
                progressBar.setVisibility(View.VISIBLE);
                final String name = nameData.getText().toString();
                final String email = emailData.getText().toString();
                String password = passwordData.getText().toString();
                String confirmPassword = confirmPasswordData.getText().toString();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPassword)){
                    if (isValid(email)){
                        if(password.equals(confirmPassword)){
                            //Todo: Store data to Firebase and create account
                            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //Todo:Create Account
                                    if (task.isSuccessful()){
                                        Map<Object,String> userdata = new HashMap<>();
                                        userdata.put("Name",name);
                                        userdata.put("email",email);
                                        firestore.collection("USER_INFO").add(userdata).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                                if (task.isSuccessful()){
                                                    startActivity(new Intent(getActivity(),MenuActivity.class));
                                                    getActivity().finish();
                                                }
                                                else {
                                                    Toast.makeText(getActivity(),"Failed To Store data",Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                    else {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        Toast.makeText(getActivity(),"Failed",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(),"Passwords Doesn't Match",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getActivity(),"Invalid Email Address",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getActivity(),"Fill Up all Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
        alreadyHaveanAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTranscation(new LoginFragment());
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
