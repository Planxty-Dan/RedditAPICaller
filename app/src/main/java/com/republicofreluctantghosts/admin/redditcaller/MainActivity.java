package com.republicofreluctantghosts.admin.redditcaller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private final String SUBREDDIT_TAG = "subreddit name";
    private TextView enterSubredditPrompt;
    private EditText subredditEditText;
    private Button submitSubreddtButton;
    private String subredditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterSubredditPrompt = (TextView) findViewById(R.id.enter_subreddit_prompt);
        subredditEditText = (EditText) findViewById(R.id.subreddit_edittext);
        submitSubreddtButton = (Button) findViewById(R.id.submit_subbreddit);

        submitSubreddtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subredditName = subredditEditText.getText().toString().toLowerCase();
                Intent intent = new Intent(getApplicationContext(), SubredditDisplayActivity.class);
                intent.putExtra(SUBREDDIT_TAG, subredditName);
                startActivity(intent);
            }
        });
    }
}
