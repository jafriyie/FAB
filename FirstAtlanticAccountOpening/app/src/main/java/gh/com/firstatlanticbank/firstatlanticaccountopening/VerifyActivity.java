package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import java.net.InetAddress;
import helpers.ApiExecute;
import helpers.ConnectionDetector;
import helpers.SaveSharedPreference;

/**
 * Created by Asante-PC on 1/26/2016.
 */
public class VerifyActivity extends AppCompatActivity {

    Button btnVerify;
    TextView lblResultMessage;
    EditText txtIdNumber;

    private Boolean hasDataConnectivity = false;
    private Boolean hasWifiConnectivity = false;
    private AsyncTask<Void, Void, JSONObject> verifyTask;

    private ConnectionDetector connection;
    private static String gviveUsername = "";
    private static String gvivePassword = "";
    private static String URL = "http://197.159.128.38/gvivewebservice/GviveWebservice.svc/voter?voterid=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();
    }



    public void initialize(){
        btnVerify = (Button)findViewById(R.id.btnVerify);
        lblResultMessage = (TextView)findViewById(R.id.lblResult);
        txtIdNumber = (EditText)findViewById(R.id.txtIdNo);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblResultMessage.setText("");
                Context context = getApplicationContext();
                InputMethodManager imm = (InputMethodManager) context
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(txtIdNumber.getWindowToken(), 0);

                connection = new ConnectionDetector(VerifyActivity.this);
                hasDataConnectivity = connection.checkCellularDataConnectivity();
                hasWifiConnectivity = connection.checkWifiConnectivnity();

                if (txtIdNumber.getText().toString().contentEquals("")) {
                    Toast.makeText(getApplicationContext(), "Enter an ID Number!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (hasDataConnectivity != false
                            || hasWifiConnectivity != false) {
                        String voterId = txtIdNumber.getText().toString().trim();
                        String username = "&username="
                                + gviveUsername;
                        String password = "&password="
                                + gvivePassword;

                        verifyTask = new VerifyAPIAsyncTask(URL + voterId
                                + username + password).execute();

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "No Internet Connectivity", Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }
        });
    }


    private class VerifyAPIAsyncTask extends AsyncTask<Void, Void, JSONObject> {

        private ProgressDialog Dialog = new ProgressDialog(VerifyActivity.this);
        private JSONObject jsonObject;

        String url;

        public VerifyAPIAsyncTask(String _url) {
            url = _url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage("Verifying...");
            Dialog.show();
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
            Dialog.dismiss();
            try {
                String response = result.getString("ResponseCode");
                if (response.contentEquals("201")) {
                    lblResultMessage.setText("Id card number not found!");
                } else if (response.contentEquals("301")) {
                            //Wrong Credentials
                    SaveSharedPreference.clear(VerifyActivity.this);
                    Intent i = new Intent(VerifyActivity.this, LoginActivity.class);
                    startActivity(i);
                } else {
                    lblResultMessage.setText("Verified!");
                }
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } catch (Throwable e) {
                Toast.makeText(getApplicationContext(),
                        "Connection Lost", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            if (isInternetAvailable()) {

                try {
                    ApiExecute webservice = new ApiExecute();
                    jsonObject = webservice.HttpGetData(url).getJSONObject(
                            "GetVoterResult");
                    return jsonObject;
                } catch (JSONException e) {
                    Dialog.dismiss();
                    Toast.makeText(getApplicationContext(), e.getMessage(),
                            Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Dialog.dismiss();
//					Toast.makeText(getApplicationContext(),
//							"Internet connectivity Lost", Toast.LENGTH_LONG)
//							.show();
                }

            }
            return null;
        }

    }
    private boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            if (ipAddr.equals("")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
