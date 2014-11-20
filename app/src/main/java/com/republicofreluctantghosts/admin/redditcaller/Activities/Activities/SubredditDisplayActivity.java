package com.republicofreluctantghosts.admin.redditcaller.Activities.Activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.republicofreluctantghosts.admin.redditcaller.Activities.Fragments.SearchResultsFragment;
import com.republicofreluctantghosts.admin.redditcaller.R;

/**
 * Created by admin on 11/17/14.
 */
public class SubredditDisplayActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            Bundle subredditName = getIntent().getExtras();
            SearchResultsFragment resultsFragment = new SearchResultsFragment();
            resultsFragment.setArguments(subredditName);
            transaction.add(R.id.container, resultsFragment);
            transaction.commit();
        }
    }
}
