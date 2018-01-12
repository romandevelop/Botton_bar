package com.example.roman.botton_bar;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    Fragment home, blank;
    FragmentManager fm;
    FragmentTransaction tx;
    public void cargaHome(){
        fm = getSupportFragmentManager();
        tx = fm.beginTransaction();
        home = new HomeFragment();
        tx.replace(R.id.contenedorFragment, home);
        tx.addToBackStack("");
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tx.commit();
    }

    public void cargaDash(){
        fm = getSupportFragmentManager();
        tx = fm.beginTransaction();
        blank = new BlankFragment();
        tx.replace(R.id.contenedorFragment, blank);
        tx.addToBackStack("");
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tx.commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    cargaHome();
                    return true;
                case R.id.navigation_dashboard:
                    cargaDash();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toolbar toolbar = findViewById(R.id.mi_toolbar);
        setSupportActionBar(toolbar);
        cargaHome();
    }

}
