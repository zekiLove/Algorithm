package com.zeki.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ThroneInheritance {
    String kingName;
    HashSet<String> isDeath = new HashSet<>();
    HashMap<String,List<String>> map = new HashMap<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> list = map.getOrDefault(parentName,new ArrayList<>());
        list.add(childName);
        map.put(parentName,list);
    }

    public void death(String name) {
        isDeath.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        preOrder(list,kingName);
        return list;
    }


    /*
    这里类似于多叉树的前序遍历
     */
    public void preOrder(List<String> list,String name){
        //如果name还没死则加入到list中去
        if(!isDeath.contains(name)){
            list.add(name);
        }

        //这里需要讲解一下getOrDefault函数，
        //当调用map.getOrDefault(name,new ArrayList<>())时
        //假如集合map中有"name"这个key（键），则返回其对应的value（值），否则返回默认设置的"new ArrayList<>()"
        //该条语句主要用于获取当前name的孩子序列
        List<String> childList = map.getOrDefault(name,new ArrayList<>());
        //对当前name的孩子序列进行遍历操作
        for(String childName:childList){
            preOrder(list,childName);
        }
    }
}
