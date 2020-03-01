package com.example.recipechooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findFoodAndRecepiesButton)
    Button mfindFoodAndRecepiesButton;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");


        mfindFoodAndRecepiesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mfindFoodAndRecepiesButton) {
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            startActivity(intent);
        }
    }
}
