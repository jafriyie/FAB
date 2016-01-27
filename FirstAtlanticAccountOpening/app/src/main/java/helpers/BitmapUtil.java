package helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by Asante-PC on 1/26/2016.
 */
public class BitmapUtil {

    public static byte[] getByteArray(Bitmap bitmap)
    {
        ByteArrayOutputStream bos= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, bos);
        return bos.toByteArray();
    }

    public static Bitmap getBitmap(byte[] bitmap){
        return BitmapFactory.decodeByteArray(bitmap,0,bitmap.length);
    }
}
