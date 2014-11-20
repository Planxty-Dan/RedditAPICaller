package com.republicofreluctantghosts.admin.redditcaller.Activities.APIcalls;

import android.os.AsyncTask;
import android.util.Log;

import com.republicofreluctantghosts.admin.redditcaller.Activities.JSON.RedditJSONparse;
import com.republicofreluctantghosts.admin.redditcaller.Activities.Models.RedditObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by admin on 11/19/14.
 */
public class RedditAPI extends AsyncTask<Object, Void, String> {

    private final String baseUrl = "http://www.reddit.com/r/";
    private final String resultsType = "/top";
    private String subreddit = "";
    private OnDataLoadedListener onDataLoadedListener;
    private String redditResults = "";

    public RedditAPI (String subreddit, OnDataLoadedListener onDataLoadedListener) {
        this.subreddit = subreddit;
        this.onDataLoadedListener = onDataLoadedListener;
    }

    public interface OnDataLoadedListener {
        public void dataLoaded(ArrayList<RedditObjects> redditObjectsArrayList);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object[] objects) {
        InputStream inputStream;
        HttpURLConnection urlConnection;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String fullUrl = baseUrl + subreddit + resultsType;
            URL redditURL = new URL(fullUrl);
            urlConnection = (HttpURLConnection) redditURL.openConnection();
            urlConnection.setRequestMethod("GET");
            inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            redditResults = stringBuilder.toString();
            inputStream.close();
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            Log.e("URL TAG", e.getLocalizedMessage());
        } catch (IOException e) {
            Log.e("URL CONNECTION", e.getLocalizedMessage());
        }
        return redditResults;
    }

    @Override
    protected void onPostExecute(String results) {
        super.onPostExecute(results);
        if (redditResults == null) {
            Log.v("NULL TAG", "null search results in Etsy post ex");
        }
        else {
            RedditJSONparse jsonData = new RedditJSONparse();
            jsonData.setSearchResults(searchResult);
            ArrayList<RedditObjects> redditResultsArray = jsonData.parseJson();
            onDataLoadedListener.dataLoaded(redditResultsArray);
        }
    }

    @Override
    protected void onProgressUpdate() {
        super.onProgressUpdate();
    }
}
