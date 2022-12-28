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
import com.example.drawer_testing.databinding.FragmentSignOutBinding;
import com.example.drawer_testing.ui.home.HomeViewModel;

public class SignOutFragment extends Fragment {

    private FragmentSignOutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SignOutViewModel signOutViewModel =
                new ViewModelProvider(this).get(SignOutViewModel.class);

        binding = FragmentSignOutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSignOut;
        signOutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}