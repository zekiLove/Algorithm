package com.zeki.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Character;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
/*
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。

请返回所有可行解 s 中最长长度

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	
    	//方法1
    	//return Integer.bitCount(n);
    	
    	
    	//方法2 '>>>'是无符号右移， '>>'是有符号右移
//    	int res=0;
//    	while(n!=0) {
//    		res+=n&1;
//    		n=n>>>1;
//    	}
    	
    	//方法3
//	    	int res=0;
//	    	while(n!=0) {
//	    		n &= n-1;
//	    		res++;
//	    	}
    	
    	
    	int cur=0;
    	String s = Integer.toBinaryString(n);
    	for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='1') {
				cur++;
			}
		}
    	return cur;
    }
}
