package com.example.recipechooser.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipechooser.R;
import com.example.recipechooser.adapters.FoodListAdapter;
import com.example.recipechooser.models.Business;
import com.example.recipechooser.network.YelpApi;
import com.example.recipechooser.network.YelpBusinessSearchResponse;
import com.example.recipechooser.network.YelpClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodListActivity extends AppCompatActivity {

    public static final String TAG = FoodListActivity.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private FoodListAdapter mAdapter;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    public List<Business> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ButterKnife.bind(this);
//        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
//        mListView = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        Log.d(TAG, "In the onCreate Method!");
        YelpApi client = YelpClient.getClient();
        Call<YelpBusinessSearchResponse> call = client.getRestaurants(location, "recipes");
        Log.d(TAG, "After Location");
        call.enqueue(new Callback<YelpBusinessSearchResponse>() {
            @Override
            public void onResponse(Call<YelpBusinessSearchResponse> call, Response<YelpBusinessSearchResponse> response) {
                hideProgressBar();
                Log.d(TAG, "In the Override");
                if (response.isSuccessful()) {
                    Log.d(TAG, "Response Successful");
//
                    foods = response.body().getBusinesses();
                    mAdapter = new FoodListAdapter(FoodListActivity.this, foods);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(FoodListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showRestaurants();
                }else{
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<YelpBusinessSearchResponse> call, Throwable t) {
                Log.d(TAG, "Request not successful");
                Log.e(TAG, "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }
        });
    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}