package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

/**
 * Created by Jason on 21/01/2016.
 */
public class IssueDateSettings implements DatePickerDialog.OnDateSetListener{

    Context context;
    public IssueDateSettings(Context context){

        this.context = context;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        if(dayOfMonth <= 9 && monthOfYear > 8 ){
            PersonalDetailsActivity.issueD.setText("0" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        }
        else if (dayOfMonth <= 9 && monthOfYear <=8){

            PersonalDetailsActivity.issueD.setText("0" + dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
        }
        else if (monthOfYear <= 8 && dayOfMonth > 9){
            PersonalDetailsActivity.issueD.setText(dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
        }
        else{
            PersonalDetailsActivity.issueD.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        }
    }
}
