package shake;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class No3 {
    static int[] origin;
    static int[] parents;
    static int[] parents2;
    static int N;
    static HashSet<Integer> root = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        parents2 = new int[N + 1];
        origin = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            origin[i] = -1;
            parents[i] = -1;
            parents2[i] = -1;
        }
        st = new StringTokenizer(br.readLine());
        int M1 = Integer.parseInt(st.nextToken());
        int M2 = Integer.parseInt(st.nextToken());
        int M3 = Integer.parseInt(st.nextToken());

//        처음 모비스터디 기준
        for (int i = 0; i < M1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, origin);
        }
//        int idx = 0;
//        for (int i : origin) {
//            System.out.println("idx: " + idx + " parent: " + i);
//            idx++;
//        }

        for (int i = 0; i < M2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, parents);
        }

        for (int i = 0; i < M3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, parents2);
        }

//        root 모음
        ArrayList<Integer>[] ans = new ArrayList[N + 1];
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] != -1) {
                if (ans[origin[i]] == null) {
                    root.add(origin[i]);
                    ans[origin[i]] = new ArrayList<>();
                    ans[origin[i]].add(origin[i]);
                    ans[origin[i]].add(i);
                } else {
                    ans[origin[i]].add(i);
                }
            }
        }
//        printStudy(ans);
        ans = updateConnection(ans, parents);
//        printStudy(ans);
        ans = updateConnection(ans, parents2);
//        printStudy(ans);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
//        굉장한 모비스터디들 정렬
        for (int i : root) {
            Collections.sort(ans[i]);
//                굉장한 모비스터디의 가장 작은 수가 작은 것이 먼저 오도록 pq
            pq.add(ans[i]);
        }
        System.out.println(root.size());
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Integer> arr : pq){
            for(int i : arr){
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int a, int[] parents) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a], parents);
    }

    private static void union(int a, int b, int[] parents) {
        a = find(a, parents);
        b = find(b, parents);
        if (a == b) return;
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public static ArrayList<Integer>[] updateConnection(ArrayList<Integer>[] ans, int[] parents) {
        boolean[] visited = new boolean[N + 1];
        HashSet<Integer> newRoot = new HashSet<>();
        ArrayList<Integer>[] update = new ArrayList[N + 1];
        for (int i : root) {
            for (int j = 0; j < ans[i].size(); j++) {
                if (!visited[ans[i].get(j)]) {
                    visited[ans[i].get(j)] = true;
                    for (int k = j + 1; k < ans[i].size(); k++) {
                        if (find(ans[i].get(j), parents) == find(ans[i].get(k), parents)) {
                            if (!visited[ans[i].get(k)]) {
                                visited[ans[i].get(k)] = true;
                                if (update[ans[i].get(j)] == null) {
                                    newRoot.add(ans[i].get(j));
                                    update[ans[i].get(j)] = new ArrayList<>();
                                    update[ans[i].get(j)].add(ans[i].get(j));
                                    update[ans[i].get(j)].add(ans[i].get(k));
                                } else {
                                    update[ans[i].get(j)].add(ans[i].get(k));
                                }
                            }
                        }
                    }
                }
            }
        }
        root = newRoot;
        return update;
    }

    public static void printStudy(ArrayList<Integer>[] ans){
        for(int i : root){
            System.out.println(ans[i].toString());
        }
    }
}
