package com.madan.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Madan on 11/14/13.
 */
public class Cupcake {
    private String name;
    private String shortDescription;
    private String description;
    private String thumbnailURL;

    public Cupcake(JSONObject json)
    {
        try {
            this.name = json.get("name").toString();
            this.shortDescription = json.get("short_description").toString();
            this.description = json.get("description").toString();
            this.thumbnailURL = json.getJSONObject("images").get("thumbnail").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
