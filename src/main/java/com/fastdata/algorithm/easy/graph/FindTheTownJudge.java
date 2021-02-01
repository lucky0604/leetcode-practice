package com.fastdata.algorithm.easy.graph;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-the-town-judge/
 * @Date: create in 1/19/21 - 11:23 AM
 */
// TODO: to be understand
public class FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {
        if (N == 1) return N;
        int[][] inOutDeg = new int[N][2];       // 0 -> indegree, 1 -> outdegree  in index
        for (int[] t: trust) {
            inOutDeg[t[1] - 1][0] ++;
            inOutDeg[t[0] - 1][1] ++;
        }
        for (int i = 0; i < N; i ++) {
            if (inOutDeg[i][0] == N - 1 && inOutDeg[i][1] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
