package com.joy50.buysale;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.transition.TransitionManager;
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
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends Fragment {

    public ResetPasswordFragment() {
        // Required empty public constructor
    }

    private FrameLayout parentFrameLayout;
    private TextView backButton;
    private EditText registeredEmail;
    private Button reset;
    private FirebaseAuth auth;
    private ViewGroup emailIconContainer;
    private ImageView emailIcon;
    private TextView emailIconText;
    private ProgressBar hori_progress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

        parentFrameLayout = getActivity().findViewById(R.id.loginRegister);
        backButton = view.findViewById(R.id.back);
        registeredEmail = view.findViewById(R.id.resetemail);
        reset = view.findViewById(R.id.reset);
        auth = FirebaseAuth.getInstance();
        emailIconContainer = view.findViewById(R.id.forgot_password_layout);
        emailIcon = view.findViewById(R.id.forgot_password_email_icon);
        emailIconText = view.findViewById(R.id.forgot_password_email_text);
        hori_progress = view.findViewById(R.id.progressBar2);
        emailIcon.setVisibility(View.INVISIBLE);
        emailIconText.setVisibility(View.INVISIBLE);
        hori_progress.setVisibility(View.INVISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo:back to Login
                setTranscation(new LoginFragment());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo:Reset Password
                TransitionManager.beginDelayedTransition(emailIconContainer);
                emailIcon.setVisibility(View.VISIBLE);
                emailIconText.setVisibility(View.VISIBLE);
                hori_progress.setVisibility(View.VISIBLE);
                String email = registeredEmail.getText().toString();
                if (!TextUtils.isEmpty(email)){
                    if (isValid(email)){
                        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    //todo:Change Icon and Text
                                    emailIconText.setText("Reset Link is sent to your Email");
                                    emailIcon.setImageResource(R.drawable.sentmail_foreground);
                                    emailIcon.setVisibility(View.VISIBLE);
                                    emailIconText.setVisibility(View.VISIBLE);
                                    emailIconText.setTextColor(getResources().getColor(R.color.colorGreenish));
                                    hori_progress.setVisibility(View.GONE);
                                    TransitionManager.beginDelayedTransition(emailIconContainer);
                                }else {
                                    emailIconText.setText("Failed to reset");
                                    emailIcon.setVisibility(View.VISIBLE);
                                    emailIconText.setTextColor(getResources().getColor(R.color.colorPrimary));
                                    hori_progress.setVisibility(View.GONE);
                                    TransitionManager.beginDelayedTransition(emailIconContainer);
                                }
                            }
                        });
                    }else {
                        Toast.makeText(getActivity(),"Invalid Email ",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(),"Email is empty",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private void setTranscation(Fragment fragment) {
        FragmentTransaction transition = getActivity().getSupportFragmentManager().beginTransaction();
        transition.replace(parentFrameLayout.getId(),fragment);
        transition.commit();
    }
    private static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
