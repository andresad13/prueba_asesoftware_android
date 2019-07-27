package com.prueba.prueba_asesoftware;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailProduct extends AppCompatActivity {

    private ImageView img_product;
    private TextView product, desc, price,zoomImg;
    private String productImg,productName, productDesc, productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        img_product = findViewById(R.id.product_img);
        product = findViewById(R.id.title_prod);
        desc = findViewById(R.id.title_desc);
        price =  findViewById(R.id.title_price);
        zoomImg = findViewById(R.id.zoom_img);

        img_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               toViewImg();
            }
        });
        zoomImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toViewImg();
            }
        });

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                productName= null;
                productImg = null;
                productDesc = null;
                productPrice = null;
            } else {
                productImg= extras.getString("productImg");
                productName= extras.getString("productName");
                productDesc= extras.getString("productDesc");
                productPrice= extras.getString("productPrice");
                Picasso.get().load(productImg).into(img_product);
                product.setText(productName);
                desc.setText(productDesc);
                price.setText("$"+productPrice);
            }
        } else {
            productName= (String) savedInstanceState.getSerializable("productName");
        }
    }

    private void toViewImg(){
        Intent i = new Intent(DetailProduct.this, PhotoDetail.class);
        i.putExtra("productImgDetail", productImg);
        startActivity(i);

    }
}
