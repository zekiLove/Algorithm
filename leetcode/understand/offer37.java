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
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

class Solution {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root==null) {
			return "null";
		}
		List<Integer> res = new ArrayList<>();
		res.add(root.val);
		Queue<TreeNode> list = new LinkedList<>();
		list.offer(root);
		while (!list.isEmpty()) {
			TreeNode node = list.poll();
			if (node.left != null) {
				res.add(node.left.val);
				list.offer(node.left);
			} else {
				res.add(null);
			}

			if (node.right != null) {
				res.add(node.right.val);
				list.offer(node.right);
			} else {
				res.add(null);
			}
		}
		return res.toString();
	}

//	 Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("null")) {
			return null;
		}
		
		String str = data.substring(1, data.length() - 1);
		List<Integer> list = new ArrayList<>();
		String[] s = str.split(",");
		for (int i = 0; i < s.length; i++) {
			String temp = s[i].trim();
			if (!temp.equals("null")) {
				list.add(Integer.parseInt(temp));
			} else {
				list.add(null);
			}
		}

		Queue<TreeNode> que = new LinkedList<>();
		TreeNode root = new TreeNode(list.get(0));
		que.offer(root);
		int i = 1;
		while (!que.isEmpty()) {
			TreeNode node = que.poll();
			if (list.get(i) != null) {
				node.left  = new TreeNode(list.get(i));
				que.offer(node.left);
			}
			i++;
			
			if(list.get(i)!=null) {
				node.right= new TreeNode(list.get(i));
				que.offer(node.right);
			}
			i++;
		}
		
		return root;
		

	}

}
