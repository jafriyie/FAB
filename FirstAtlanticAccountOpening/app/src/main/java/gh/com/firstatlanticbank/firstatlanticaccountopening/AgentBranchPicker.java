package gh.com.firstatlanticbank.firstatlanticaccountopening;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Jason on 25/01/2016.
 */
public class AgentBranchPicker extends DialogFragment {

    final CharSequence[] selBranch = {"Head Office, Ridge West", "Airport Branch, Airport Residential Area",
            "North Industrial Area, Dadeban Road", "North Ridge, Near Alisa Hotel",
            "Spintex Road Branch, Adjacent Finatrade Building", "East Legon, America House Junction",
            "Accra Central, Central Business District", "Kantamanto, Tarzan House",
            "Max Mart, 1st Floor Maxmart Building", "Abossey Okai, Korle Bu Road",
            "Osu Oxford Street, Opposite KFC Restaurant", "Abeka Lapaz, Fraga Oil Premises",
            "Tema Community 1, Efua Halam House Tema", "Tema Harbour Road, Plot# B12 & 13 Harbour Area",
            "Nhyiaeso, No. 7 Ellis Avenue", "Suame, Suame Magazine"};
    String selection;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please Select The Agent's Branch...");

        builder.setSingleChoiceItems(selBranch, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:

                        selection = (String) selBranch[which];
                        break;

                    case 1:

                        selection = (String) selBranch[which];
                        break;

                    case 2:

                        selection = (String) selBranch[which];
                        break;

                    case 3:

                        selection = (String) selBranch[which];
                        break;

                    case 4:

                        selection = (String) selBranch[which];
                        break;

                    case 5:

                        selection = (String) selBranch[which];
                        break;

                    case 6:

                        selection = (String) selBranch[which];
                        break;

                    case 7:

                        selection = (String) selBranch[which];
                        break;

                    case 8:

                        selection = (String) selBranch[which];
                        break;

                    case 9:

                        selection = (String) selBranch[which];
                        break;

                    case 10:

                        selection = (String) selBranch[which];
                        break;

                    case 11:

                        selection = (String) selBranch[which];
                        break;

                    case 12:

                        selection = (String) selBranch[which];
                        break;

                    case 13:

                        selection = (String) selBranch[which];
                        break;

                    case 14:

                        selection = (String) selBranch[which];
                        break;

                    case 15:

                        selection = (String) selBranch[which];
                        break;

                }
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "You selected  : " + selection, Toast.LENGTH_LONG).show();
                CreateAgentActivity.agentBranch.setText(selection);

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