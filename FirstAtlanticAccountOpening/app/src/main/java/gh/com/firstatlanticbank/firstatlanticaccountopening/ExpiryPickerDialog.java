package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Jason on 21/01/2016.
 */
public class ExpiryPickerDialog extends DialogFragment{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        ExpiryDateSettings expiryDateSettings = new ExpiryDateSettings(getActivity());
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog;
        dialog = new DatePickerDialog(getActivity(), expiryDateSettings, year, month, day);

        return dialog;

    }
}
