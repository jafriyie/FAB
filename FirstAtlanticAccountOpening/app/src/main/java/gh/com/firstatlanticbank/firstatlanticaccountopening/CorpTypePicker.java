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
public class CorpTypePicker extends DialogFragment {

    final CharSequence[] types = {"Private Limited Liability Company", "Public Limited Liability Company", "Company Limited by Guarantee", "Managed Fund",
            "Partnership", "State Owned Company/ Government Ministry/ Agency",
            "Sole Proprietor", "Other (Please Specify)"};
    String selection;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please Select A Currency...");

        builder.setSingleChoiceItems(types, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        selection = (String) types[which];
                        break;

                    case 1:
                        selection = (String) types[which];
                        break;

                    case 2:
                        selection = (String) types[which];
                        break;

                    case 3:
                        selection = (String) types[which];
                        break;
                    case 4:
                        selection = (String) types[which];
                        break;

                    case 5:
                        selection = (String) types[which];
                        break;

                    case 6:
                        selection = (String) types[which];
                        break;
                }
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CorporateActivity.corpType.setText(selection);
                Toast.makeText(getActivity(), "Your selected Company Type is : " + selection, Toast.LENGTH_LONG).show();
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
