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

public class CorporateActivity extends AppCompatActivity {

    /*Spinner corpType, corpCurrency;*/
    public static EditText corpType, corpCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corporate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        corpCurrency = (EditText) findViewById(R.id.corpCurrency);
        corpType = (EditText) findViewById(R.id.corpType);

        corpCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorpCurrencyPicker myDialog = new CorpCurrencyPicker();
                myDialog.show(getSupportFragmentManager(), "myDialog");
            }
        });

        corpType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorpTypePicker myDialog2 = new CorpTypePicker();
                myDialog2.show(getSupportFragmentManager(), "myDialog2");
            }
        });

        /*corpType = (Spinner) findViewById(R.id.corpType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.corporateTypes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        corpType.setAdapter(adapter);

        corpCurrency = (Spinner) findViewById(R.id.corpCurrency);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        corpCurrency.setAdapter(adapter1);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
