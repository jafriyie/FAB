package helpers;

/**
 * Created by Asante-PC on 1/26/2016.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class ApiExecute {
    public JSONObject HttpGetData(String url) throws Exception {

        URL json = new URL(url);
        URLConnection connection = json.openConnection();
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(20000);
        if (isInternetAvailable()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            String line = reader.readLine().toString();
            JSONObject jsonResponse = new JSONObject(line);
            reader.close();
            return jsonResponse;
        }
        return null;

    }

    public JSONObject HttpsGetData(String url) throws Exception {

        return null;
    }

    private boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            if (ipAddr.equals("")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
