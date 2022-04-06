package com.example.intech_health_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.intech_health_app.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Homepage());

        binding.btmMenu.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.homepage:
                    replaceFragment(new Homepage());
                    break;
                case R.id.calendar:
                    replaceFragment(new calendar());
                    break;
                case R.id.emergency:
                    replaceFragment(new emergency());
                    break;
                case R.id.menu2:
                    replaceFragment(new menu());
                    break;
                case R.id.settings:
                    replaceFragment(new settings());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}