package com.republicofreluctantghosts.admin.redditcaller.Activities.JSON;

import android.util.Log;

import com.republicofreluctantghosts.admin.redditcaller.Activities.Models.RedditObjects;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by admin on 11/20/14.
 */
public class RedditJSONparse {

    private String redditJSON = "";


    public RedditJSONparse(String searchResultsJSON) {
        redditJSON = searchResultsJSON;
    }

    public ArrayList<RedditObjects> parseJSON() {
        ArrayList<RedditObjects> parsedJSONobjects = new ArrayList<RedditObjects>();
        try {
            JSONObject jsonObject = new JSONObject(redditJSON);
        }
        catch (JSONException e) {
            Log.v("JSON PARSE", "parsing JSON exception");
        }
        try {
            
        }
    }
}
