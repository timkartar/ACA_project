package com.example.dushyant.imagecapture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.content.pm.PackageInfo;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView kumarImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kumarButton = (Button) findViewById(R.id.kumarbutton);
        kumarImageView = (ImageView) findViewById(R.id.kumarImageView);

        if(!hasCamera())
            kumarButton.setEnabled(false);

    }

    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View view){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
           Bundle extras = data.getExtras();
           Bitmap photo = (Bitmap) extras.get("data");
           kumarImageView.setImageBitmap(photo);
       }
    }
}
