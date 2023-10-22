package com.example.yudbeitprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.widget.GridLayout;

public class DynamicKeyboardBuilderActivity extends AppCompatActivity {
    public LinearLayout linearLayout;
    public GridLayout englishKeyboardLayout;
    public GridLayout hebrewKeyboardLayout;
    //public LinearLayout specialCharsKeyboardLayout;
    public TextView textBar;
    public final char[] ENGLISH_KEYBOARD_ARRAY = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\',
            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};

    public final int BUTTONS_COUNT = 60;

    private void createGridLayoutButton(char id, GridLayout gridLayout) {
        int numColumns = gridLayout.getColumnCount();

        Button button = DynamicObjectsBuilder.createButton(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBar.setText(textBar.getText().toString() + id);
            }
        }, String.valueOf(id));

        // Calculate the width of each button based on the number of columns
        int buttonWidth = getResources().getDisplayMetrics().widthPixels / numColumns;

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 0); // Set the width to 0

        button.setLayoutParams(params);
        button.getLayoutParams().width = buttonWidth; // Set the calculated width
        button.getLayoutParams().height = GridLayout.LayoutParams.WRAP_CONTENT;
        button.setPadding(0,0,0,0);
        gridLayout.addView(button);

    }


    private void createGridLayoutButton(char[] id, GridLayout gridLayout) {
        int numColumns = 10; // Set the number of columns to 10

        for (char character : id) {
            Button button = DynamicObjectsBuilder.createButton(this, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textBar.setText(textBar.getText().toString() + character);
                }
            }, String.valueOf(character));

            // Calculate the width of each button based on the number of columns
            int buttonWidth = getResources().getDisplayMetrics().widthPixels / numColumns;

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 0); // Set the width to 0

            button.setLayoutParams(params);
            button.getLayoutParams().width = buttonWidth; // Set the calculated width
            button.getLayoutParams().height = GridLayout.LayoutParams.WRAP_CONTENT;
            button.setPadding(0,0,0,0);
            gridLayout.addView(button);
        }
    }

    private void createGridLayoutButton(char id, GridLayout gridLayout, View.OnClickListener onClickListener) {
        int numColumns = gridLayout.getColumnCount();

        Button button = DynamicObjectsBuilder.createButton(this, onClickListener, String.valueOf(id));

        // Calculate the width of each button based on the number of columns
        int buttonWidth = getResources().getDisplayMetrics().widthPixels / numColumns;

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 0); // Set the width to 0

        button.setLayoutParams(params);
        button.getLayoutParams().width = buttonWidth; // Set the calculated width
        button.getLayoutParams().height = GridLayout.LayoutParams.WRAP_CONTENT;
        button.setPadding(0,0,0,0);
        gridLayout.addView(button);

    }

    private void createGridLayoutButton(char id, GridLayout gridLayout, View.OnClickListener onClickListener, int resId) {
        int numColumns = gridLayout.getColumnCount();

        Button button = DynamicObjectsBuilder.createButton(this, onClickListener, String.valueOf(id));

        // Calculate the width of each button based on the number of columns
        int buttonWidth = getResources().getDisplayMetrics().widthPixels / numColumns;

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 0); // Set the width to 0

        button.setLayoutParams(params);
        button.getLayoutParams().width = buttonWidth; // Set the calculated width
        button.getLayoutParams().height = GridLayout.LayoutParams.WRAP_CONTENT;
        button.setBackgroundResource(resId);
        button.setPadding(0,0,0,0);
        gridLayout.addView(button);

    }

    private void createGridLayoutButton(char id, GridLayout gridLayout, int resId, boolean isAutomaticMeasurement) {
        int numColumns = gridLayout.getColumnCount();
        Button button = DynamicObjectsBuilder.createButton(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBar.setText(textBar.getText().toString() + id);
            }
        }, String.valueOf(id));
        int buttonWidth = getResources().getDisplayMetrics().widthPixels / numColumns;
        Drawable drawable = getResources().getDrawable(resId);
        int originalWidth = drawable.getIntrinsicWidth();
        int originalHeight = drawable.getIntrinsicHeight();

        // Calculate the width of each button based on the number of columns
        //int buttonWidth = getResources().getDisplayMetrics().widthPixels / numColumns;

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 0); // Set the width to 0

        button.setLayoutParams(params);
        button.getLayoutParams().height = button.getHeight();
        button.getLayoutParams().width = buttonWidth; // Set the calculated width
        button.setBackgroundResource(resId);
        button.setPadding(0,0,0,0);
        gridLayout.addView(button);


    }



    private GridLayout buildKeyboard(GridLayout gridLayout, char[] keyboardArray, int rows, int cols) {
        // Create a GridLayout
        gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(cols);
        gridLayout.setRowCount(rows);
        createGridLayoutButton(keyboardArray, gridLayout);
        createGridLayoutButton('⌫', gridLayout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = textBar.getText().length();
                if(len!=0) textBar.setText(textBar.getText().toString().substring(0, len-1));
            }
        });


        createGridLayoutButton(' ', gridLayout, R.drawable.space, true);
        createGridLayoutButton('\n', gridLayout, R.drawable.enter, true);

        // Add the hidden keyboards to the main linear layout
        linearLayout.addView(gridLayout);
        linearLayout.setVisibility(LinearLayout.VISIBLE);

        return gridLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_keyboard_builder);
        linearLayout = findViewById(R.id.activity_dynamic_keyboard_builder);

        englishKeyboardLayout = new GridLayout(this);
        hebrewKeyboardLayout = new GridLayout(this);

        textBar = new TextView(this);
        textBar.setText("Hello!");

        // Creating the English keyboard with 10 buttons per row
        englishKeyboardLayout = buildKeyboard(englishKeyboardLayout, ENGLISH_KEYBOARD_ARRAY, 6, 10);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        textBar.setLayoutParams(layoutParams);
        layoutParams.setMargins(0, 20, 0, 20); // (left, top, right, bottom)
        linearLayout.addView(textBar);
    }
}
