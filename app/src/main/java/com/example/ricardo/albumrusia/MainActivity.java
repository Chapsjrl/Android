package com.example.ricardo.albumrusia;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadFragment(new AlbumActivity());


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_album:
                fragment = new AlbumActivity();
                break;

            case R.id.navigation_tienda:
                fragment = new ShopActivity();
                break;

            case R.id.navigation_avance:
                fragment = new AvanceActivity();
                break;

            case R.id.navigation_intercambio:
                fragment = new TradeActivity();
                break;
        }

        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.navigation_album, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
