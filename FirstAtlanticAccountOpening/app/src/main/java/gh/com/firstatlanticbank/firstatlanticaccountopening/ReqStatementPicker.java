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
public class ReqStatementPicker extends DialogFragment {

    final CharSequence[] freqType = {"Daily", "Weekly", "Monthly", "Quarterly", "Semi-annually", "Annually"};
    String selection;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please Select Statement Frequency...");

        builder.setSingleChoiceItems(freqType, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        selection = (String) freqType[which];
                        break;

                    case 1:
                        selection = (String) freqType[which];
                        break;

                    case 2:
                        selection = (String) freqType[which];
                        break;

                    case 3:
                        selection = (String) freqType[which];
                        break;

                    case 4:
                        selection = (String) freqType[which];
                        break;

                    case 5:
                        selection = (String) freqType[which];
                        break;
                }
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RequiredServicesActivity.reqStateFreq.setText(selection);
                Toast.makeText(getActivity(), "You selected  : " + selection, Toast.LENGTH_LONG).show();
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