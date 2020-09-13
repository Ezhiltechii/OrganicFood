package com.sbtechnologies.organicfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeNavigationActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    String get_user_name=null;
    String get_user_location=null;
    TextView header_name,header_address;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("myprefe",0);
        get_user_name =sharedPreferences.getString("name",null);
        Log.d("HomeNavigationActivity","-----------------"+get_user_name);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.Home, R.id.Search, R.id.Categories, R.id.order, R.id.MyProfile, R.id.Logut)
                .setDrawerLayout(drawer)
                .build();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View navigation_info = navigationView.getHeaderView(0);
        header_name = navigation_info.findViewById(R.id.navi_name);
        header_address = navigation_info.findViewById(R.id.navi_address);
        if (get_user_name != null)
            header_name.setText(get_user_name);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

        CustomBottomNavigationView1 customBottomNavigationView1 = findViewById(R.id.customBottomBar);
        customBottomNavigationView1.inflateMenu(R.menu.bottom_menu);
        customBottomNavigationView1.setOnNavigationItemSelectedListener(navListener);

        final FloatingActionButton floatingActionButton = findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment setFragment = null;
                switch (floatingActionButton.getId()){
                    case R.id.fab:
                        setFragment = new HomeFragment();
                        Toast.makeText(getApplicationContext(), "HomeFragment selected", Toast.LENGTH_LONG).show();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, setFragment).commit();
                return;
            }
        });



    }

    private void init() {


    }

    private CustomBottomNavigationView1.OnNavigationItemSelectedListener navListener =
            new CustomBottomNavigationView1.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.bottom_nav_category:
                    Toast.makeText(getApplicationContext(), "CategoryFragment selected", Toast.LENGTH_LONG).show();
                    selectedFragment = new CategoryFragment();
                    break;
                case R.id.bottom_nav_cart:
                    Toast.makeText(getApplicationContext(), "CartFragment selected", Toast.LENGTH_LONG).show();
                    selectedFragment = new CartFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                Intent home = new Intent(this, HomeFragment.class);
                startActivity(home);
                break;

            case R.id.Categories:
                Intent favourites = new Intent(this, CategoryFragment.class);
                startActivity(favourites);
                break;

                case R.id.Cart:
                Intent cart = new Intent (this, CartFragment.class);
                startActivity(cart);
                break;

            case R.id.order:
                Intent Order = new Intent(this, OrdersActivity.class);
                startActivity(Order);
                break;

            case R.id.MyProfile:
                Intent myprofile = new Intent(this, ProfileActivity.class);
                startActivity(myprofile);
                break;

            case R.id.Logut:
                Intent i = new Intent (this,LogoutActivity.class);
                startActivity(i);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}