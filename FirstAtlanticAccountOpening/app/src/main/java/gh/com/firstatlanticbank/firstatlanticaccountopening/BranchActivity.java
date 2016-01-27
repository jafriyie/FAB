package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class BranchActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        finish();
    }

    public static EditText pickedBranch;
    Button branchCancel, branchSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        pickedBranch = (EditText) findViewById(R.id.pickedBranch);
        branchSave = (Button) findViewById(R.id.branchSave);




        if(!TextUtils.isEmpty(AccountMenuActivity.accBranch)){
            pickedBranch.setText(AccountMenuActivity.accBranch);
        }
        else{
            pickedBranch.setText("");
        }

        pickedBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BranchPicker myDialog = new BranchPicker();
                myDialog.show(getSupportFragmentManager(), "myDialog");
            }
        });



        branchSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(AccountMenuActivity.accBranch)) {
                    Toast.makeText(BranchActivity.this, AccountMenuActivity.accBranch, Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(BranchActivity.this, AccountMenuActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                else{
                    Intent myIntent = new Intent(BranchActivity.this, AccountMenuActivity.class);
                    startActivity(myIntent);
                    finish();
                }

            }
        });



    }

}
