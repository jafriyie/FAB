package gh.com.firstatlanticbank.firstatlanticaccountopening;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Jason on 26/01/2016.
 */
public class ExitDialog extends DialogFragment{

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are You Sure You Want To Exit? Doing So Will Clear Any Saved Changes");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent closeIntent = new Intent(getActivity(), DashActivity.class);
                startActivity(closeIntent);
                AccountMenuActivity.accBranch = "";
                getActivity().finish();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

       return builder.create();
    }
}
