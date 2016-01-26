package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Jason on 21/01/2016.
 */
public class DateSettings implements DatePickerDialog.OnDateSetListener{

    Context context;
    public DateSettings(Context context){

        this.context = context;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {



        if(dayOfMonth <= 9 && monthOfYear > 8 ){
            PersonalDetailsActivity.dateBirth.setText("0" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        }
        else if (dayOfMonth <= 9 && monthOfYear <=8){

            PersonalDetailsActivity.dateBirth.setText("0" + dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
        }
        else if (monthOfYear <= 8 && dayOfMonth > 9){
            PersonalDetailsActivity.dateBirth.setText(dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
        }
        else{
            PersonalDetailsActivity.dateBirth.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        }

    }
}