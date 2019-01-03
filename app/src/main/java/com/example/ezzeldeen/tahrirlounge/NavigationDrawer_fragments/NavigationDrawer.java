package com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.About_Us;
import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.Contact_us;
import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.Events_fragments;
import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.Our_Team;
import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.facebook_fragment;
import com.example.ezzeldeen.tahrirlounge.R;
import com.example.ezzeldeen.tahrirlounge.ViewPager_Fragments.Our_Partners;
import com.example.ezzeldeen.tahrirlounge.ViewPager_Fragments.TabFragment;
import com.example.ezzeldeen.tahrirlounge.ViewPager_Fragments.Twitter_frragment;
import com.example.ezzeldeen.tahrirlounge.ViewPager_Fragments.Youtube_fragment;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new TabFragment()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Hom) {
            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new TabFragment()).commit();
        }

        if (item.getItemId() == R.id.facebook) {
            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new facebook_fragment()).commit();

        }

        if (item.getItemId() == R.id.twi) {


            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new Twitter_frragment()).commit();
        }
        if (item.getItemId() == R.id.you) {


            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new Youtube_fragment()).commit();
        }
        if (item.getItemId() == R.id.eve) {


            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new Events_fragments()).commit();
        }
        if (item.getItemId() == R.id.Our) {

            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new Our_Team()).commit();
        }
        if (item.getItemId() == R.id.us) {

            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new Contact_us()).commit();

        }

        if (item.getItemId() == R.id.part) {

            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer, new Our_Partners()).commit();

        }


        if (item.getItemId()==R.id.about_us){

            getSupportFragmentManager().beginTransaction().replace(R.id.TabContainer,new About_Us()).addToBackStack(null).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
