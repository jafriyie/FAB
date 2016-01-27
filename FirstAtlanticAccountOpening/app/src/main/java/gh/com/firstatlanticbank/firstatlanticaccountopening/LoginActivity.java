package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class LoginActivity extends Activity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin =(Button) findViewById(R.id.bLogIn);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent myIntent = new Intent(LoginActivity.this, DashActivity.class);
                startActivity(myIntent);

                /*isMobileDataAvailable = mobileData.checkMobileInternetConn();
                isWifiAvailable = wifiData.checkMobileInternetConn();
                //
                String username = "/" + txtUsername.getText().toString();
                String password = "/" + txtPassword.getText().toString();

                if (txtUsername.getText().toString().contentEquals("")) {
                    Toast.makeText(LoginActivity.this, "Please provide Username.", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.getText().toString().contentEquals("")) {
                    Toast.makeText(getApplicationContext(), "Please provide Password", Toast.LENGTH_SHORT).show();
                } else {
                    if (isMobileDataAvailable != false || isWifiAvailable != false) {
                        new Primary_AuthTask(URL + username + password).execute();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "No Internet Connectivity", Toast.LENGTH_LONG).show();
                    }
                }*/

               /* finish();*/
            }
        });

     /*   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
