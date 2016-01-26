package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Jason on 22/01/2016.
 */
public class ReqCardPicker extends DialogFragment {

    final CharSequence[] cardType = {"MasterCard Debit", "MasterCard Credit", "Visa Debit", "Visa Credit", "AMEX Card"};
    String selection;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please Select A Card Type...");

        builder.setSingleChoiceItems(cardType, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        selection = (String) cardType[which];
                        break;

                    case 1:
                        selection = (String) cardType[which];
                        break;

                    case 2:
                        selection = (String) cardType[which];
                        break;

                    case 3:
                        selection = (String) cardType[which];
                        break;

                    case 4:
                        selection = (String) cardType[which];
                        break;
                }
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RequiredServicesActivity.reqCardType.setText(selection);
                Toast.makeText(getActivity(), "Your selected Card Type is : " + selection, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "You Did Not Make A Selection", Toast.LENGTH_LONG).show();
            }
        });

        return builder.create();
    }

}