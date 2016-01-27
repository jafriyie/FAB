package helpers;

/**
 * Created by Asante-PC on 1/26/2016.
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {
    private Context context;

    public ConnectionDetector(Context _context) {
        this.context = _context;
    }

    public boolean checkCellularDataConnectivity(){
        ConnectivityManager connectivity =(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity != null){
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if(info != null){
                if(info.isConnected()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWifiConnectivnity(){
        ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity!=null)
        {
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if(info != null){
                if(info.isConnected())
                {
                    return true;
                }
            }
        }

        return false;
    }
}
