package com.example.recipechooser.models;

import com.example.recipechooser.BuildConfig;
import org.parceler.Parcel;

@Parcel

public class Constants {
    public static final String YELP_TOKEN = BuildConfig.YELP_API_KEY;
    public static final String YELP_BASE_URL = "https://api.yelp.com/v3/";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";
}