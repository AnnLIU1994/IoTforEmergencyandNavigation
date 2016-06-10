package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.UpdatesFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d(TAG, "Drawer Opened");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d(TAG, "Drawer Closed");
            }
        });

        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                showWindow(menuItem);
                Log.d(TAG, "Selected " + menuItem);
                mDrawerLayout.closeDrawer(mNavigationView);
                return false;
            }
        });
    }

    private void showWindow(final MenuItem menuItem) {
        final int itemId = menuItem.getItemId();
        switch (itemId) {
            case R.id.nav_updates:
                final android.support.v4.app.Fragment nextFragment = new UpdatesFragment();
                Toast.makeText(MainActivity.this, "nav updates", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, nextFragment)
                        .commit();
                break;
            case R.id.nav_guest:
                final Intent intent = new Intent(this, GuestActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalArgumentException("No Fragment for the given item");
        }

    }
}
