package com.zeki.pojo;

import java.util.ArrayList;
import java.lang.Character;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

class Solution {
	String s;
	String str[];
	List<String> list = new ArrayList<String>();
	HashSet<String> set = new HashSet<>();

	public String[] permutation(String s) {
		int index=0;
		this.s = s;
		for (int i = 1; i <= s.length(); i++) {
			list.add(s.substring(i - 1, i));
		}
		StringBuilder sb = new StringBuilder();
		getString(list, sb);
		String arr[] = new String[set.size()];
		for(String str:set) {
			arr[index++]=str;
		}
		return arr;
	}

	public void getString(List<String> list,StringBuilder s) {
		if(list.isEmpty()) {
			set.add(s.toString());
			return;
		}
		List<String> tempList = new ArrayList<String>();
		tempList.addAll(list);
		for(String str:tempList) {
			s.append(str);
			list.remove(str);
			getString(list,s);  
			s.delete(s.length()-str.length(), s.length());
			list.add(str);
		}
	}

}
