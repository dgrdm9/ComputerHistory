package com.dgrdm9.menulist.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.dgrdm9.menulist.Fragments.FirstFragment;
import com.dgrdm9.menulist.Fragments.ForthFragment;
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

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (menuItem.getItemId()) {
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
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();
                    menuItem.setChecked(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });
    }


    private void setToolbar() {
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
