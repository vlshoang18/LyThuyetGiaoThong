package com.example.lythuyetgiaothong.sliders;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lythuyetgiaothong.R;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class SliderActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        viewFlipper = findViewById(R.id.view_flipper);
        int images[] = {R.drawable.img_1, R.drawable.img_2,
                R.drawable.img_3, R.drawable.img_4 };
        for (int image : images) {
            flipperImages(image);
        }

    }
    public void flipperImages(int image) {
        ImageView imageView = new ImageView(SliderActivity.this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2900);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(SliderActivity.this, android.R.anim.slide_in_left);
    }


}