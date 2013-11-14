package com.madan.mapping;

import com.madan.model.Cupcake;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madan on 11/14/13.
 */
public class CupcakeMapping {

    public static List<Cupcake> parse(String json){
        try {
            JSONObject rootObject = new JSONObject(json);
            JSONArray jsonArray = new JSONArray(rootObject.get("cupcakes").toString());
            List cupcakes = new ArrayList<Cupcake>();
           for (int i=0;i<jsonArray.length();i++){
               Cupcake cupcake = new Cupcake(jsonArray.getJSONObject(i));
              cupcakes.add(cupcake);
           }
            return cupcakes;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
