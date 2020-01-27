package com.tema7.tema7ejemplo1.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;



import com.tema7.tema7ejemplo1.Adapters.PagerAdapter;
import com.tema7.tema7ejemplo1.Fragments.SecondFragment;
import com.tema7.tema7ejemplo1.Interfaces.OnPersonCreated;
import com.tema7.tema7ejemplo1.Models.Person;
import com.tema7.tema7ejemplo1.R;
public class MainActivity extends AppCompatActivity implements OnPersonCreated {
private ViewPager viewPager;
private PagerAdapter pagerAdapter;
private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);

//       setActionBar(myToolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Formulario"));
        tabLayout.addTab(tabLayout.newTab().setText("Lista"));

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setViewPager();

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            //En esta opcion le indicamos que nos envie a la pestaña principal
            case R.id.reiniciar:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            //En esta opcion indicamos que nos envie a otra activity
            case R.id.minimizar:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

            case R.id.salir:
                finish();
                break;
        }
        return true;
    }


    public void setViewPager(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
@Override



    public void createPerson(Person person){
        SecondFragment secondFragment= (SecondFragment)getSupportFragmentManager().getFragments().get(1);
        secondFragment.addPerson(person);
        viewPager.setCurrentItem(1);


    }
}