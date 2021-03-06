package com.example.recipechooser.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recipechooser.R;
import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.findRecipesButton) Button mFindRecipesButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    //TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindRecipesButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v==mFindRecipesButton){
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}