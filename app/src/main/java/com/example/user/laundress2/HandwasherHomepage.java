package com.example.user.laundress2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HandwasherHomepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private HandwasherHomepage.SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    String handwasher_name;
    int handwasher_id, handwasher_lspid;
    private int backButton = 2;
    private View header;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handwasher_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nv);
        //header = navigationView.getHeaderView(R.layout.nav_header);
        name = navigationView.getHeaderView(0).findViewById(R.id.namenavbar);
        navigationView.setNavigationItemSelectedListener(this);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new HandwasherHomepage.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        handwasher_name = extras.getString("name");
        handwasher_id = extras.getInt("id");
        handwasher_lspid = extras.getInt("lspid");
        name.setText(handwasher_name);
/*        handwasher_name = getIntent().getStringExtra("name");
        handwasher_id = getIntent().getIntExtra("id", 0);
        handwasher_lspid = getIntent().getIntExtra("lspid", 0);*/
    }
    @Override
    public void onBackPressed() {
        if(backButton < 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            // Toast.makeText(this, "Press the back button once again", Toast.LENGTH_SHORT).show();
            backButton++;
            return;
        }
        super.onBackPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.notification){
            Bundle extras = new Bundle();
            extras.putString("handwasher_name",handwasher_name);
            extras.putInt("handwasher_id", handwasher_id);
            extras.putInt("handwasher_lspid", handwasher_lspid);
            Intent intent = new Intent(HandwasherHomepage.this, HandwasherNotification.class);
            intent.putExtras(extras);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.rating) {
            Bundle extras = new Bundle();
            extras.putString("handwasher_name",handwasher_name);
            extras.putInt("handwasher_id", handwasher_id);
            extras.putInt("handwasher_lspid", handwasher_lspid);
            Intent intent = new Intent(HandwasherHomepage.this, HandwasherRate.class);
            intent.putExtras(extras);
            startActivity(intent);
        } else if (id == R.id.laundryservices) {
            Bundle extras = new Bundle();
            extras.putString("handwasher_name",handwasher_name);
            extras.putInt("handwasher_id", handwasher_id);
            extras.putInt("handwasher_lspid", handwasher_lspid);
            Intent intent = new Intent(HandwasherHomepage.this, HandwasherLaundryServices.class);
            intent.putExtras(extras);
            startActivity(intent);

        }  else if (id == R.id.myclient) {
            Bundle extras = new Bundle();
            extras.putString("handwasher_name",handwasher_name);
            extras.putInt("handwasher_id", handwasher_id);
            extras.putInt("handwasher_lspid", handwasher_lspid);
            Intent intent = new Intent(HandwasherHomepage.this, HandwasherMyClients.class);
            intent.putExtras(extras);
            startActivity(intent);

        } else if (id == R.id.account) {
            Bundle extras = new Bundle();
                extras.putString("handwasher_name",handwasher_name);
                extras.putInt("handwasher_id", handwasher_id);
                extras.putInt("handwasher_lspid", handwasher_lspid);
                Intent intent = new Intent(HandwasherHomepage.this, HandwasherAccount.class);
            intent.putExtras(extras);
            startActivity(intent);
        } else if (id == R.id.history) {
            Bundle extras = new Bundle();
            extras.putString("handwasher_name",handwasher_name);
            extras.putInt("handwasher_id", handwasher_id);
            extras.putInt("handwasher_lspid", handwasher_lspid);
            Intent intent = new Intent(HandwasherHomepage.this, HandwasherHistory.class);
            intent.putExtras(extras);
            startActivity(intent);
        } else if (id == R.id.logout) {
            Intent intent = new Intent(HandwasherHomepage.this, ClientLogout.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return HandwasherMyLaundry.newInstance(handwasher_id, handwasher_name, handwasher_lspid);
                case 1:
                    return HandwasherBookings.newInstance(handwasher_id, handwasher_name, handwasher_lspid);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }
}
