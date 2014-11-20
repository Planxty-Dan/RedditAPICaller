package com.republicofreluctantghosts.admin.redditcaller.Activities.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.republicofreluctantghosts.admin.redditcaller.Activities.Models.RedditObjects;
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
        final RedditObjects currentRedditObject = getArguments().getParcelable(REDDIT_OBJECT);
        View rootView = inflater.inflate(R.layout.fragment_single_post_view, container, false);
        postAuthor = (TextView) rootView.findViewById(R.id.postlist_single_item_author);
        postTitle = (TextView) rootView.findViewById(R.id.single_view_title);
        postBody = (TextView) rootView.findViewById(R.id.single_view_body);

        postAuthor.setText(currentRedditObject.getPostAuthor());
        postTitle.setText(currentRedditObject.getPostTitle());
        postBody.setText(currentRedditObject.getPostBody());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
