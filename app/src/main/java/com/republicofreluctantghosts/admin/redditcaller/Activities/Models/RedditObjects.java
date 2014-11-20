package com.republicofreluctantghosts.admin.redditcaller.Activities.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 11/19/14.
 */
public class RedditObjects implements Parcelable {

    private String postAuthor;
    private String postTitle;
    private String postBody;

    public RedditObjects() {
    }

    private RedditObjects (Parcel in) {
        postAuthor = in.readString();
        postTitle = in.readString();
        postBody = in.readString();
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(postAuthor);
        parcel.writeString(postTitle);
        parcel.writeString(postBody);
    }

    public static final Parcelable.Creator<RedditObjects> CREATOR = new Parcelable.Creator<RedditObjects>() {
        public RedditObjects createFromParcel(Parcel source) {
            return new RedditObjects(source);
        }

        public RedditObjects[] newArray(int size) {
            return new RedditObjects[size];
        }
    };
}
