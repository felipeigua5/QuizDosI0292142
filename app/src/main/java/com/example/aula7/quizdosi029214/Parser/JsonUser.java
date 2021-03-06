package com.example.aula7.quizdosi029214.Parser;

import com.example.aula7.quizdosi029214.Models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AULA 7 on 19/04/2018.
 */

public class JsonUser {
    public static List<User> getData(String content) throws JSONException {

        JSONArray jsonArray = new JSONArray(content);
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);

            User user = new User();
            user.setEmail(item.getString("email"));
            user.setName(item.getString("name"));
            user.setUsername(item.getString("username"));

            JSONObject addressObject = item.getJSONObject("address");
            user.setStreet(addressObject.getString("street"));

            userList.add(user);

        }

        return userList;
    }
}
