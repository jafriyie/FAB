package gh.com.firstatlanticbank.firstatlanticaccountopening;

/**
 * Created by Asante-PC on 1/26/2016.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import java.io.File;
import helpers.BitmapUtil;


public class PictureActivity extends AppCompatActivity {

    private Button btnTakePhoto;
    private ImageView imgPassportPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();
    }

    private void initialize()
    {
        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);
        imgPassportPic = (ImageView)findViewById(R.id.imgPassportPic);

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            File f = new File(Environment.getExternalStorageDirectory().toString());
            for(File temp : f.listFiles()) {
                if(temp.getName().equals("temp.jpg")){
                    f = temp;
                    break;
                }
            }

            try {
               Bitmap bitmap;
                BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);
                imgPassportPic.setImageBitmap(bitmap);
                byte[] bytes = BitmapUtil.getByteArray(bitmap);

                f.delete();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
