package com.example.gluttony;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gluttony.Fragments.Login;
import com.example.gluttony.Fragments.Register;
import com.example.gluttony.Adapters.ViewpageAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        tabLayout=findViewById(R.id.Tablayout);
        viewPager=findViewById(R.id.Viewpager);

        ViewpageAdapter adapter = new ViewpageAdapter(getSupportFragmentManager());

        adapter.addFragment(new Login(),"Login");
        adapter.addFragment(new Register(),"Register");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
