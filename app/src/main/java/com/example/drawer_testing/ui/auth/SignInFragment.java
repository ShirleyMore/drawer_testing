package com.example.drawer_testing.ui.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer_testing.R;
import com.example.drawer_testing.databinding.FragmentHomeBinding;
import com.example.drawer_testing.databinding.FragmentSignInBinding;
import com.example.drawer_testing.ui.home.HomeViewModel;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInFragment extends Fragment {

    private static final String TAG = SignInFragment.class.getSimpleName(); // for Log.d
    private AuthViewModel authViewModel;
    ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult( // writing the contract to Activity Result API
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent signInIntent = authViewModel.getSignInIntent();
        signInLauncher.launch(signInIntent);
    }

    // from the FireBase website
    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == Activity.RESULT_OK) {
            // Signed in successfully
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            updateUserInDataBase(user);
        }
        else {
            Log.d(TAG, "error sign in");
        }
    }
    private void updateUserInDataBase(FirebaseUser user) {
        Log.d(TAG, "update user in data base");
        authViewModel.signIn();
    }

}