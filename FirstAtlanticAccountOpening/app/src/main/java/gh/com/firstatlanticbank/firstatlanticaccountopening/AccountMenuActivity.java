package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AccountMenuActivity extends AppCompatActivity {

    public static ImageView verifComplete, branchComplete, reqComplete, pdComplete, contComplete, photoComplete;

    public static String accBranch, accType, accCurrency, accCard, accEbank, accTransAlert, accStatePref, accStateFreq;
    public static String accCheqReq, accCheqPref;
    public static String accTitle, accSurname, accFirstName, accOtherNames, accMaiden, accGender, accNationality;
    public static String accDOB, accNonNat, accPermit, accPermIssue, accPermExpiry, accPhone, accEmail;

    LinearLayout menuIDVer, menuBranchSel, menuRequired, menuPersDets, menuContactDet, menuPhoto;
    Button btnComplete, btnCancel;

    @Override
    public void onBackPressed() {
        Intent closeIntent = new Intent(AccountMenuActivity.this, DashActivity.class);
        startActivity(closeIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        menuIDVer = (LinearLayout) findViewById(R.id.menuIDVerif);
        menuBranchSel = (LinearLayout) findViewById(R.id.menuBranchSel);
        menuRequired = (LinearLayout) findViewById(R.id.menuReqServ);
        menuPersDets = (LinearLayout) findViewById(R.id.menuPersDet);
        menuContactDet = (LinearLayout) findViewById(R.id.menuContDet);
        menuPhoto = (LinearLayout) findViewById(R.id.menuPhoto);

        verifComplete = (ImageView) findViewById(R.id.verifComplete);
        branchComplete = (ImageView) findViewById(R.id.branchComplete);
        reqComplete = (ImageView) findViewById(R.id.reqComplete);
        pdComplete = (ImageView) findViewById(R.id.pdComplete);
        contComplete = (ImageView) findViewById(R.id.contComplete);
        photoComplete = (ImageView) findViewById(R.id.photoComplete);


        if(!TextUtils.isEmpty(accBranch)){

            branchComplete.setImageResource(R.drawable.complete3);

        }
        else{
            branchComplete.setImageResource(R.drawable.incomplete3);
        }



        menuIDVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountMenuActivity.this, VerifyActivity.class);
                startActivity(intent);
            }
        });

        menuBranchSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(AccountMenuActivity.this, BranchActivity.class);
                startActivity(myIntent2);
            }
        });

        menuRequired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent3 = new Intent(AccountMenuActivity.this, RequiredServicesActivity.class);
                startActivity(myIntent3);
            }
        });

        menuPersDets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent4 = new Intent(AccountMenuActivity.this, PersonalDetailsActivity.class);
                startActivity(myIntent4);
            }
        });

        menuContactDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent5 = new Intent(AccountMenuActivity.this, ContactActivity.class);
                startActivity(myIntent5);
            }
        });

        menuPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent6 = new Intent(AccountMenuActivity.this, PictureActivity.class);
                startActivity(myIntent6);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
