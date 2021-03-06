package com.macinsiders.chat.resource;

import java.util.List;

public class Login implements Resource {

    public static final String KEY_USERNAME = "username";
    public static final String KEY_COOKIE = "cookie";
    public static final String KEY_MODHASH = "modhash";

    private String mUsername;
    private String mPassword;
    private List<String> mCookies;
    private String mModhash;

    public Login(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public Login(String username, List<String> cookies, String modhash) {

        if (username == null || cookies == null || modhash == null) {
            throw new IllegalArgumentException("null argument");
        }

        mUsername = username;
        for (String cookie : cookies) {
            mCookies.add(cookie);
        }
        mModhash = modhash;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setCookie(List<String> cookies) {
        mCookies = cookies;
    }

    public List<String> getCookies() {
        return mCookies;
    }

    public void setModhash(String modhash) {
        mModhash = modhash;
    }

    public String getModHash() {
        return mModhash;
    }
}
