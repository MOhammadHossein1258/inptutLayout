package com.example.sharedprefernce;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {

    private final SharedPreferences sharedPreferences;
    public  UserManager (Context context){

        sharedPreferences=context.getSharedPreferences("user_information",Context.MODE_PRIVATE);
    }

    public void saveUserInformation (String fullName, String email, String gender){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email",email);
        editor.putString("full_name",fullName);
        editor.putString("gender",gender);
        editor.apply();
    }

    public String getFullName(){
        return sharedPreferences.getString("full_Name","");
    }

    public String getEmail(){
        return sharedPreferences.getString("email","");

    }

    public String getGender(){
        return sharedPreferences.getString("gender","");
    }
}
