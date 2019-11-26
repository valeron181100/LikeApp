package com.example.likeapp;

import android.location.Location;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class User {
    private UUID mUserId;
    private String mName;
    private int mAge;
    private ArrayList<String> mInterests;
    private ArrayList<String> mPhotoLinks;
    private String mAvatarLink;
    private int mGrowthSm;
    private Location mLocation;
    private boolean mIsMan;

    public User(String name, int age, boolean isMan, boolean withLocation){
        mName = name;
        mAge = age;
        mUserId = UUID.randomUUID();
        mIsMan = isMan;
        if(withLocation){
            //TODO: defining user location
        }
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public ArrayList<String> getInterests() {
        return mInterests;
    }

    public void setInterests(ArrayList<String> interests) {
        mInterests = interests;
    }

    public ArrayList<String> getPhotoLinks() {
        return mPhotoLinks;
    }

    public void setPhotoLinks(ArrayList<String> photoLinks) {
        mPhotoLinks = photoLinks;
    }

    public String getAvatarLink() {
        return mAvatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        mAvatarLink = avatarLink;
    }

    public int getGrowthSm() {
        return mGrowthSm;
    }

    public void setGrowthSm(int growthSm) {
        mGrowthSm = growthSm;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public boolean isMan() {
        return mIsMan;
    }

    public void setIsMan(boolean isman) {
        mIsMan = isman;
    }

    public JSONObject generateFullJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", mName);
            jsonObject.put("age", mAge);
            jsonObject.put("interests", mInterests);
            jsonObject.put("photos", mPhotoLinks);
            jsonObject.put("avatar", mAvatarLink);
            jsonObject.put("growth", mGrowthSm);
            jsonObject.put("location", mLocation);
            jsonObject.put("isman", mIsMan);
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}
