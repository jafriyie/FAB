package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RequiredServicesActivity extends AppCompatActivity {

    /*private Spinner spinCurrency, spinCard, spinFrequency;*/

    public static EditText reqCurrency, reqCardType, reqStateFreq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_required_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reqCurrency = (EditText) findViewById(R.id.reqCurrency);
        reqCardType = (EditText) findViewById(R.id.reqCardType);
        reqStateFreq = (EditText) findViewById(R.id.reqStateFreq);

        reqCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReqCurrencyPicker myDialog = new ReqCurrencyPicker();
                myDialog.show(getSupportFragmentManager(), "myDialog");
            }
        });

        reqCardType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReqCardPicker myDialog2 = new ReqCardPicker();
                myDialog2.show(getSupportFragmentManager(), "myDialog2");
            }
        });

        reqStateFreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReqStatementPicker myDialog3 = new ReqStatementPicker();
                myDialog3.show(getSupportFragmentManager(), "myDialog3");
            }
        });

       /* spinCurrency = (Spinner) findViewById(R.id.spinCurrencies);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinCurrency.setAdapter(adapter);*/

        /*spinCard = (Spinner) findViewById(R.id.spinCard);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.cardPreferences, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinCard.setAdapter(adapter1);

        spinFrequency = (Spinner) findViewById(R.id.spinStatement);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.statementPreferences, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinFrequency.setAdapter(adapter2);
*/
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
       /* getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

}
