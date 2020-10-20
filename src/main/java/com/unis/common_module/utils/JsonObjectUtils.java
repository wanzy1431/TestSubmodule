package com.unis.common_module.utils;

import org.json.JSONObject;

import java.util.HashMap;

public
class JsonObjectUtils {
    public static JSONObject getJson(HashMap<String, Object> hashMap) {
        JSONObject jsonObject = new JSONObject(hashMap);
        return jsonObject;
    }
}
