package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DashActivity extends AppCompatActivity {

    private Toolbar toolbar;
    TextView welcomeUser, lastLoginDate;
    LinearLayout linPersonal, linCorporate, linActivity, linAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        welcomeUser = (TextView) findViewById(R.id.dashoardProfileCard_Username);
        lastLoginDate = (TextView) findViewById(R.id.dashoardProfileCard_LastLoginDate);

        linPersonal = (LinearLayout) findViewById(R.id.linPersonal);
        linCorporate = (LinearLayout) findViewById(R.id.linCorporate);
        linActivity = (LinearLayout) findViewById(R.id.linActivity);
        linAccount = (LinearLayout) findViewById(R.id.linAccount);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        welcomeUser.setText("Welcome Agent");
        lastLoginDate.setText("Last Login : DD/MM/YYYY");



        linPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashActivity.this, AccountMenuActivity.class);
                startActivity(myIntent);
            }
        });

        linCorporate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent (DashActivity.this, CorporateActivity.class);
                startActivity(myIntent2);
            }
        });

        linActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent myIntent3 = new Intent(DashActivity.this, AgentActivity.class);
                startActivity(myIntent3);*/
            }
        });

        linAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent4 = new Intent(DashActivity.this, EditAccountActivity.class);
                startActivity(myIntent4);
            }
        });


     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.actionSignOut:

                Intent logIntent = new Intent(DashActivity.this, LoginActivity.class);
                startActivity(logIntent);
                Toast signOut = Toast.makeText(DashActivity.this, "You Have Signed Out", Toast.LENGTH_LONG);
                signOut.show();
                finish();
                return true;


            default:

                return super.onOptionsItemSelected(item);

        }
    }

}
