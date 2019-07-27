package com.prueba.prueba_asesoftware;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PhotoDetail extends AppCompatActivity {

    private ImageView photoDetail;
    private String photoUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        photoDetail = findViewById(R.id.photo_product);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                photoUrl= null;

            } else {
                photoUrl= extras.getString("productImgDetail");

                Picasso.get().load(photoUrl).into(photoDetail);



            }
        } else {
            photoUrl= (String) savedInstanceState.getSerializable("productImgDetail");
        }

    }
}
