package com.republicofreluctantghosts.admin.redditcaller.Activities.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.republicofreluctantghosts.admin.redditcaller.R;

/**
 * Created by admin on 11/19/14.
 */
public class SinglePostViewFragment extends Fragment {

    private final String REDDIT_OBJECT = "reddit object";
    private TextView postAuthor;
    private TextView postTitle;
    private TextView postBody;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single_post_view, container, false);
        
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
