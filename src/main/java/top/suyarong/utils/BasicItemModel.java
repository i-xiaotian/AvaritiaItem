package top.suyarong.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicItemModel {

    public static String jsonGenerator(final String type, final String registerName) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("ccl_marker", 1);

        List<String> variantSets = new ArrayList<>();
        variantSets.add("type");
        jsonObject.put("variant_sets", variantSets);

        jsonObject.put("texture_domain", "avaritiaitem");

        Map<String, Object> defaults = new HashMap<>();
        defaults.put("model", "builtin/generated");

        Map<String, Object> textures = new HashMap<>();
        textures.put("layer0", "minecraft:dirt");
        defaults.put("textures", textures);

        defaults.put("transform", "ccl:default-item");
        jsonObject.put("defaults", defaults);

        Map<String, Object> variants = new HashMap<>();
        Map<String, Object> typeVariant = new HashMap<>();
        Map<String, Object> resource = new HashMap<>();
        Map<String, Object> resourceTextures = new HashMap<>();
        resourceTextures.put("layer0", "items/" + registerName);
        resource.put("textures", resourceTextures);
        typeVariant.put(type, resource);
        variants.put("type", typeVariant);
        jsonObject.put("variants", variants);

        return gson.toJson(jsonObject);

    }


}
