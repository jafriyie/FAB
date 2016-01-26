package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.DialogFragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PersonalDetailsActivity extends AppCompatActivity {

    Button pdSave, pdCancel;
    public static EditText dateBirth, issueD, expiryD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pdSave = (Button) findViewById(R.id.pdSave);
        pdCancel = (Button) findViewById(R.id.pdCancel);

        dateBirth = (EditText) findViewById(R.id.pdDOB);
        issueD = (EditText) findViewById(R.id.pdIssue);
        expiryD = (EditText) findViewById(R.id.pdExpiry);

        dateBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickerDialogs pickerDialogs = new PickerDialogs();
                pickerDialogs.show(getSupportFragmentManager(), "date_picker");
            }
        });

        issueD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IssuePickerDialog issuePickerDialog = new IssuePickerDialog();
                issuePickerDialog.show(getSupportFragmentManager(), "date_picker2");
            }
        });

        expiryD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExpiryPickerDialog expiryPickerDialog = new ExpiryPickerDialog();
                expiryPickerDialog.show(getSupportFragmentManager(), "date_picker3");
            }
        });

        pdSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(PersonalDetailsActivity.this, AccountMenuActivity.class);
                startActivity(myIntent);
                AccountMenuActivity.pdComplete.setImageResource(R.drawable.complete3);
            }
        });


        pdCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(PersonalDetailsActivity.this, AccountMenuActivity.class);
                startActivity(myIntent2);
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

    public void showDOBDialog(View view){
        PickerDialogs pickerDialogs = new PickerDialogs();
        pickerDialogs.show(getSupportFragmentManager(), "date_picker");
    }


}
