package com.zeki.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public int openLock(String[] deadends, String target) {
        int step = 0;

        Queue<String> que = new LinkedList<>();
        que.offer("0000");

        HashSet<String> dead = new HashSet<>();
        for (String str : deadends) {
            dead.add(str);
        }

        //注意点1：deadends如果包含"0000"，则可以直接返回-1了
        if(dead.contains("0000")){
            return -1;
        }

        //注意点2：如果target=="0000"，则可以直接返回0了
        if(target.equals("0000")){
            return 0;
        }


        HashSet<String> isVis = new HashSet<String>();
        isVis.add("0000");

        while (!que.isEmpty()) {
            step++;
            int size = que.size();//这里需要事先定义size，因为接下来que会删除元素，那时的size就不准确了
            for (int i=0;i<size;i++) {//这里是将当前“层”的所有情况都遍历一遍，为了寻找当前层所有状态的下8种状态
                String indexStr = que.poll();//这里将que列表中的第一个元素取出，并且将其删除
                for (String str : getStatus(indexStr)) {
                    if (!isVis.contains(str) && !dead.contains(str)) {
                        if (target.equals(str)) {//找到结果
                            return step;
                        }
                        isVis.add(str);//表示该种状态已经访问过
                        que.offer(str);//再将该种状态加入到列表种，去查找这种状态的下一种状态
                    }
                }
            }
        }
        return -1;
    }

    public char numPre(char num) {
        return num == '0' ? '9' : (char) (num - 1);
    }

    public char numNext(char num) {
        return num == '9' ? '0' : (char) (num + 1);
    }


    /**
     * 这个函数用于递推 锁的密码 的当前状态的下一步是哪8种情况
     *
     * @param str
     * @return
     */
    public List<String> getStatus(String str) {
        List<String> list = new ArrayList<>();
        char arr[] = str.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = arr[i];
            arr[i] = numPre(num);
            list.add(new String(arr));
            arr[i] = numNext(num);
            list.add(new String(arr));
            arr[i] = num;
        }
        return list;
    }

}
