package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdminDashActivity extends AppCompatActivity {

    TextView welcomeAdmin, adminLastLogin;
    LinearLayout linAgent, linAgActivity, linAdAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        welcomeAdmin = (TextView) findViewById(R.id.dashoardAdminCard_Username);
        adminLastLogin = (TextView) findViewById(R.id.dashoardAdminCard_LastLoginDate);

        welcomeAdmin.setText("Welcome Admin");
        adminLastLogin.setText("Last Login : DD/MM/YYYY");

        linAgent = (LinearLayout) findViewById(R.id.linAgent);
        linAgActivity = (LinearLayout) findViewById(R.id.linAgActivity);
        linAdAccount = (LinearLayout) findViewById(R.id.linAdAccount);

        linAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(AdminDashActivity.this, CreateAgentActivity.class);
                startActivity(myIntent);
            }
        });

        linAgActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });

        linAdAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


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

                Intent logIntent = new Intent(AdminDashActivity.this, LoginActivity.class);
                startActivity(logIntent);
                Toast signOut = Toast.makeText(AdminDashActivity.this, "You Have Signed Out", Toast.LENGTH_LONG);
                signOut.show();
                finish();
                return true;


            default:

                return super.onOptionsItemSelected(item);

        }
    }

}
