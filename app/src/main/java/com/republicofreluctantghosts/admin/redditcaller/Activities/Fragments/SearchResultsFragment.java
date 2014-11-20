package com.republicofreluctantghosts.admin.redditcaller.Activities.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.republicofreluctantghosts.admin.redditcaller.Activities.APIcalls.RedditAPI;
import com.republicofreluctantghosts.admin.redditcaller.Activities.Models.RedditObjects;
import com.republicofreluctantghosts.admin.redditcaller.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11/18/14.
 */
public class SearchResultsFragment extends ListFragment {

    private final String SUBREDDIT_TAG = "subreddit name";
    private final String REDDIT_OBJECT = "reddit object";
    private List<RedditObjects> redditPosts = new ArrayList<RedditObjects>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new ListView(getActivity());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final ResultsAdapter adapter = new ResultsAdapter(getActivity(), redditPosts);
        setListAdapter(adapter);
        RedditAPI redditAPI = new RedditAPI(getArguments().getString(SUBREDDIT_TAG), new RedditAPI.OnDataLoadedListener() {
            @Override
            public void dataLoaded(ArrayList<RedditObjects> redditObjectsArrayList) {
                adapter.clear();
                adapter.addAll(redditObjectsArrayList);
                adapter.notifyDataSetChanged();
            }
        });
        redditAPI.execute();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        final SinglePostViewFragment singlePostViewFragment = new SinglePostViewFragment();
        RedditObjects redditObject = (RedditObjects) getListAdapter().getItem(position);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (fragmentTransaction.isEmpty()) {
            Bundle bundle =new Bundle();
            bundle.putParcelable(REDDIT_OBJECT, redditObject);
            singlePostViewFragment.setArguments(bundle);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.container, singlePostViewFragment);
            fragmentTransaction.commit();
        }
    }

    public class ResultsAdapter extends ArrayAdapter<RedditObjects> {
        private List<RedditObjects> redditPosts;

        public ResultsAdapter(Context context, List<RedditObjects> redditObjectsModels) {
            super(context, android.R.layout.simple_list_item_1, redditObjectsModels);
            redditPosts = redditObjectsModels;
        }

        @Override
        public int getCount() {
            return super.getCount();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = LayoutInflater.from(getContext()).inflate(R.layout.single_postlist_item, parent, false);
            TextView authorTextView = (TextView) rowView.findViewById(R.id.postlist_single_item_author);
            TextView titleTextView = (TextView) rowView.findViewById(R.id.postlist_single_item_title);
            RedditObjects currentRedditPost = redditPosts.get(position);
            authorTextView.setText(currentRedditPost.getPostAuthor());
            titleTextView.setText(currentRedditPost.getPostTitle());

            return rowView;
        }
    }
}
