package com.androidtutz.anushka.memberapp.models;

import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 1/23/2018.
 */

public class MemberDataManager {

    private String memberStatus;
    private ArrayList<Member> members = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private static final String COUNT_KEY = "count";
    private int currentCount;

    public MemberDataManager(SharedPreferences pref) {

        sharedPreferences = pref;

        populateData();
    }

    public MemberDataManager(SharedPreferences pref, NetworkManager networkManager) {

        sharedPreferences = pref;

        populateData();
    }

    public String checkMemberStatus(String userInput) {

        memberStatus = "Access Denied";

        for (Member m : members) {


            if ((m.getMemberId().equals(userInput))) {

                updateAccessCount();
                memberStatus = "Access Granted : Access count is " + getCurrentCount();

            }


        }


        return memberStatus;
    }

    public int getCurrentCount() {
        currentCount = sharedPreferences.getInt(COUNT_KEY, 0);
        return currentCount;
    }

    private void updateAccessCount() {
        sharedPreferences.edit()
                .putInt(COUNT_KEY, getCurrentCount() + 1)
                .apply();

    }


    private void populateData() {

        members.add(new Member("123", "Tom", "tom@gmail.com"));
        members.add(new Member("127", "Sam", "sam@gmail.com"));
        members.add(new Member("670", "Jack", "jack@gmail.com"));
        members.add(new Member("230", "Frank", "frank@gmail.com"));
        members.add(new Member("118", "Mary", "mary@gmail.com"));
        members.add(new Member("602", "Sara", "sara@gmail.com"));


    }


}
