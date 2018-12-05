package com.mnetsolutions.www.simpay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selecteditem = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selecteditem = new HomeFragment();
                    break;
                case R.id.navigation_sales:
                    selecteditem = new SalesFragment();
                    break;
                case R.id.navigation_settings:
                    selecteditem = new SettingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.containerUpper, selecteditem).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);


        //Set the icon size to the bottom navigation on the dashboard
        BottomNavigationMenuView menuView = (BottomNavigationMenuView)
                navigation.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView =
                    menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams =
                    iconView.getLayoutParams();
            final DisplayMetrics displayMetrics =
                    getResources().getDisplayMetrics();
            layoutParams.height = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30,
                            displayMetrics);
            layoutParams.width = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30,
                            displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

        //Set the default fragment to load into the dashboard
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerUpper, new HomeFragment())
                .commit();


    }

    @Override
    public void onClick(View view) {
       /* Intent i;
        switch (view.getId()){
            case R.id.airtime:i = new Intent(this, AirTime.class);
                startActivity(i);
                break;
            case R.id.internet:i = new Intent(this, AirTime.class);
                startActivity(i);
                break;
            case R.id.lotto:i = new Intent(this, AirTime.class);
                startActivity(i);
                break;
            case R.id.mobile_money:i = new Intent(this, AirTime.class);
                startActivity(i);
                break;
            case R.id.tv:i = new Intent(this, AirTime.class);
                startActivity(i);
                break;
            case R.id.utilities:i = new Intent(this, AirTime.class);
                startActivity(i);
                break;
            default: break;
        }*/

    }


    @Override
    public void onBackPressed()
    {

//        startActivity(new Intent(Dashboard.this, Dashboard.class));
//        finish();

       getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerUpper, new HomeFragment())
                .commit();

        super.onBackPressed();

    }

}
