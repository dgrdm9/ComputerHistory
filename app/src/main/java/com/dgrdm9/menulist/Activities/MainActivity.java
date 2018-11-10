package com.dgrdm9.menulist.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.dgrdm9.menulist.Fragments.FirstFragment;
import com.dgrdm9.menulist.Fragments.ForthFragment;
import com.dgrdm9.menulist.Fragments.HomeFragment;
import com.dgrdm9.menulist.Fragments.PrehFragment;
import com.dgrdm9.menulist.Fragments.SecondFragment;
import com.dgrdm9.menulist.Fragments.ThirdFragment;
import com.dgrdm9.menulist.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        setFragmentByDefault();

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        fragment = new HomeFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_prehistory:
                        fragment = new PrehFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_first_gen:
                        fragment = new FirstFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_second_gen:
                        fragment = new SecondFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_third_gen:
                        fragment = new ThirdFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_forth_gen:
                        fragment = new ForthFragment();
                        fragmentTransaction = true;
                        break;
                }
                if (fragmentTransaction) {
                    changeFragment(fragment, menuItem);
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });
    }

    private void changeFragment(Fragment fragment, MenuItem menuItem) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        menuItem.setChecked(true);
        getSupportActionBar().setTitle(menuItem.getTitle());
    }

    private void setToolbar() {
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault() {
        changeFragment(new HomeFragment(), navigationView.getMenu().getItem(0));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
