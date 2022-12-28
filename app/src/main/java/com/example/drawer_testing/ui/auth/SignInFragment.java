package com.example.drawer_testing.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer_testing.databinding.FragmentHomeBinding;
import com.example.drawer_testing.databinding.FragmentSignInBinding;
import com.example.drawer_testing.ui.home.HomeViewModel;

public class SignInFragment extends Fragment {

    private FragmentSignInBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SignInViewModel signInViewModel =
                new ViewModelProvider(this).get(SignInViewModel.class);

        binding = FragmentSignInBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSignIn;
        signInViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}