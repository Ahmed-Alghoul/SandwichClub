package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");
            String description=jsonObject.getString("description");
            JSONArray alsoKnownAsJSON = name.getJSONArray("alsoKnownAs");
            JSONArray Ingredientsjson=jsonObject.getJSONArray("ingredients");

            ArrayList<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJSON.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJSON.get(i).toString());
            }

            ArrayList<String> ingredients = new ArrayList<>();
            for (int i = 0; i < Ingredientsjson.length(); i++) {
                ingredients.add(Ingredientsjson.get(i).toString());
            }


            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String image = jsonObject.getString("image");

            Sandwich sandwich = new Sandwich();
            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredients);
            sandwich.setDescription(description);
            return sandwich;
        } catch (Exception e) {
            Log.e("Exc", e.toString());
        }
        return null;
    }
}
