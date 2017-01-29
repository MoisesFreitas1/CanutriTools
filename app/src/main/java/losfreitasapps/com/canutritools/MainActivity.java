package losfreitasapps.com.canutritools;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager FM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        FM = getFragmentManager();
        FM.beginTransaction().replace(R.id.content_principal, new home()).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_imc) {
            FM.beginTransaction().replace(R.id.content_principal, new Imc()).commit();
        } else if (id == R.id.nav_pi) {
            FM.beginTransaction().replace(R.id.content_principal, new PesoIdeal()).commit();
        } else if (id == R.id.nav_ep) {
            FM.beginTransaction().replace(R.id.content_principal, new EstPeso()).commit();
        } else if (id == R.id.nav_ee) {
            FM.beginTransaction().replace(R.id.content_principal, new EstEstatura()).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_abreviaturas) {
            FM.beginTransaction().replace(R.id.content_principal, new Abreviaturas()).commit();
        } else if (id == R.id.nav_sobre) {
            FM.beginTransaction().replace(R.id.content_principal, new Sobre()).commit();
        } else if (id == R.id.nav_home) {
            FM.beginTransaction().replace(R.id.content_principal, new home()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
