package com.example.felipesantos.abas.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.felipesantos.abas.Fragment.EmAltaFragment;
import com.example.felipesantos.abas.Fragment.HomeFragment;
import com.example.felipesantos.abas.Fragment.IncricoesFragment;
import com.example.felipesantos.abas.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Youtube");

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Home", HomeFragment.class)
                .add("Inscrições", IncricoesFragment.class)
                .add("Em Alta", EmAltaFragment.class)
                .create());

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        smartTabLayout = (SmartTabLayout) findViewById(R.id.viewPagertab);
        smartTabLayout.setViewPager(viewPager);
    }
}
