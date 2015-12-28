package com.simplefacedetectionapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
    private final static int CAMERA_RETURN_CODE = 1410;
    private FaceImageView fiw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fiw = (FaceImageView) findViewById(R.id.facedet);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_RETURN_CODE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_RETURN_CODE) {
            Bitmap cameraBmp = (Bitmap) data.getExtras().get("data");
            //fiw.setImageBitmap(cameraBmp);
            fiw.setImage(cameraBmp);
            fiw.detectFaces();
        }
    }

}
