package com.madan.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Madan on 11/14/13.
 */
public class Cupcake {
    private String name;
    private String shortDescription;
    private String description;

    public Cupcake(JSONObject json)
    {
        try {
            this.name = json.get("name").toString();
            this.shortDescription = json.get("short_description").toString();
            this.description = json.get("description").toString();
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
}
