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

/*
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。

请返回所有可行解 s 中最长长度

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
	public int snakesAndLadders(int[][] board) {
		int n = board.length; //先定义长度
		Queue<int[]> que = new LinkedList<>();
		boolean isVis[] = new boolean[n * n + 1];
		que.offer(new int[] { 1, 0 });
		while (!que.isEmpty()) {
			int p[] = que.poll();
			for (int i = 1; i <= 6; i++) {
				int next = p[0] + i; //当前id是多少
				if (next > n * n) { //如果超出棋盘，则接下来的i也会超出棋盘，所以可以break
					break;
				}
				int[] l = getLocaltion(next, n); //根据next获得数组位置
				if (board[l[0]][l[1]] != -1) { //判断此时这个位置有没有梯子或蛇
					next = board[l[0]][l[1]];
				}
				//如果此时next等于了棋盘长度那么就返回步数。这里注意，因为这是广度优先搜索
				//所以如果next=n*n时，那就说明这是最少的步数。
				if (next == n * n) {
					return p[1]+1; 
					
				}
				//标记该next点已经被访问过
				if(!isVis[next]) {
					isVis[next]=true;
					que.offer(new int[] {next,p[1]+1});
				}

			}
		}
		return -1;
	}

	public int[] getLocaltion(int id, int n) {
		int r = (id - 1) / n, c = (id - 1) % n;
		if (r % 2 == 1) {
			c = n - c - 1;
		}
		return new int[] { n - 1 - r, c };
	}
}
