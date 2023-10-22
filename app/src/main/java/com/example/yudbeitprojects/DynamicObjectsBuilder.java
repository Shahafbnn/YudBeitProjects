package com.example.yudbeitprojects;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicObjectsBuilder {
    public static ImageView createImageView(Context context, int imageResource, ImageView.ScaleType scaleType, int width, int height, int padLeft, int padRight, int padTop, int padBottom) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageResource);


// Set layout parameters to control dimensions
        LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(
                width, // Width
                height  // Height
        );
        imageView.setLayoutParams(imageLayoutParams);

        // Set scale type
        imageView.setScaleType(scaleType);

        // Set padding to create spacing
        imageView.setPadding(padLeft, padTop, padRight, padBottom); // Left, Top, Right, Bottom

        imageView.setVisibility(View.VISIBLE);

        return imageView;
    }

    public static Button createButton(Context context, View.OnClickListener onClickListener, String text) {
        Button button = new Button(context);
        button.setText(text);
        button.setOnClickListener(onClickListener);
        return button;
    }

    public static Button createButton(Context context, View.OnClickListener onClickListener, String text, int backgroundColor, int textColor, int width, int height) {
        Button button = new Button(context);
        button.setText(text);
        button.setOnClickListener(onClickListener);
        button.setBackgroundColor(backgroundColor);
        button.setTextColor(textColor);
        button.setWidth(width);
        button.setHeight(height);
        return button;
    }
}
