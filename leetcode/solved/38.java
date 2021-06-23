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

//另外一种解法（更加快捷）
//class Solution {
//	List<String> list = new ArrayList<String>();
//	boolean vis[];
//	public String[] permutation(String s) {
//		int n=s.length();
//		char ch[] = s.toCharArray();
//		//这个排序很关键，它让相同的字符相邻了
//		Arrays.sort(ch);
//		vis = new boolean[n];
//		backTrack(0,n,ch,new StringBuilder());
//		return list.toArray(new String[n]);	
//	}
//	
//	public void backTrack(int i,int n,char arr[],StringBuilder sb) {
//		if(i==n) {
//			list.add(sb.toString());
//			return;
//		}
//		
//		for(int j=0;j<n;j++) {
//			//这里因为已经遍历过重复的字符了，所以之后vis[x]被设置为false了，所以可以用 !vis[j]来确保下次不会遍历到它
//			if(vis[j] || (j>0 && !vis[j-1] && arr[j]==arr[j-1])) {
//				continue;
//			}
//			vis[j]=true;
//			sb.append(arr[j]);
//			backTrack(i+1,n,arr,sb);
//			sb.delete(sb.length()-1,sb.length());
//			vis[j]=false;
//		}
//	}
//}

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
