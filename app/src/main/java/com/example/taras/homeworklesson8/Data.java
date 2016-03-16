package com.example.taras.homeworklesson8;

import java.util.ArrayList;

/**
 * Created by taras on 15.03.16.
 */
public class Data {
    private static ArrayList<DataModel> mData = new ArrayList<DataModel>();

    public static String getFirstName(int i) {
        return mData.get(i).getFirstName();
    }

    public static int size() {
        return mData.size();
    }

    public static void add(DataModel newPerson) {
        mData.add(newPerson);
    }

    public static void remove(int listPosition) {
        mData.remove(listPosition);
    }

    public static DataModel get(int i) {
        return mData.get(i);
    }
}
