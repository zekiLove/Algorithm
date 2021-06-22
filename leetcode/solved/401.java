package com.zeki.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    HashSet<String> set = new HashSet<>();
    int turnedOn;

    public List<String> readBinaryWatch(int turnedOn) {
        this.turnedOn = turnedOn;
        getTime(0,0,0,0);
        List<String> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    public void getTime(int start, int cur, int hour, int minute) {
        if (cur == turnedOn) {
            formatTime(hour, minute);
            return;
        }
        for (int i = start; i < 10; i++) {
            if (i < 4) {
                int t = (int) Math.pow(2, i);
                if (hour + t > 11) {
                    getTime(i + 1, cur, hour, minute);
                } else {
                    getTime(i + 1, cur + 1, hour + t, minute);
                }
            } else {
                int t = (int) Math.pow(2, i - 4);
                if (minute + t > 59) {
                    getTime(i + 1, cur, hour, minute);
                } else {
                    getTime(i + 1, cur + 1, hour, minute + t);
                }
            }
        }
    }

    public void formatTime(int hour, int minute) {
        if (minute < 10) {
            set.add("" + hour + ":0" + minute);
        } else {
            set.add("" + hour + ":" + minute);
        }
    }
}
