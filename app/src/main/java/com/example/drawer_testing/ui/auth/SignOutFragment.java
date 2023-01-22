package com.example.drawer_testing.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.drawer_testing.R;
import com.example.drawer_testing.databinding.FragmentHomeBinding;
import com.example.drawer_testing.databinding.FragmentSignOutBinding;
import com.example.drawer_testing.ui.home.HomeViewModel;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SignOutFragment extends Fragment {

    private static final String TAG = SignInFragment.class.getSimpleName();
    private FragmentSignOutBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        AuthUI.getInstance().signOut(requireContext()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                navController.navigate(R.id.action_nav_signOut_to_nav_home);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}