package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No17471 {

    static int N;
    static int[] peoples;
    static int populationDiff = Integer.MAX_VALUE / 2;
    static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            peoples[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int idx = 0; idx < N; idx++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < cnt; i++) {
                graph.get(idx + 1).add(Integer.parseInt(st.nextToken()));
            }
        }

        divide(0, new ArrayList<>(), new ArrayList<>());

        if(populationDiff == Integer.MAX_VALUE / 2){
            System.out.println(-1);
        }else{
            System.out.println(populationDiff);
        }
    }

    public static void divide(int currentIdx, List<Integer> aGroup, List<Integer> bGroup) {
        List<Integer> copyA = new ArrayList<>(aGroup);
        List<Integer> copyB = new ArrayList<>(bGroup);

        if (currentIdx == N) {
            if (checkDividePossible(aGroup) && checkDividePossible(bGroup)) {
                populationDiff = Math.min(populationDiff, getPopulationDiff(aGroup));
            }
            return;
        }
        copyA.add(currentIdx + 1);
        copyB.add(currentIdx + 1);
        divide(currentIdx + 1, copyA, bGroup);
        divide(currentIdx + 1, aGroup, copyB);
    }

    public static int getPopulationDiff(List<Integer> aGroup) {
        boolean[] selected = new boolean[N + 1];
        int firstPopulation = 0;
        int secondPopulation = 0;

        for (int selectedIdx : aGroup) {
            selected[selectedIdx] = true;
        }

        for (int i = 1; i < selected.length; i++) {
            if (selected[i]) {
                firstPopulation += peoples[i];
                continue;
            }
            secondPopulation += peoples[i];
        }
        return Math.abs(Math.subtractExact(firstPopulation, secondPopulation));
    }

    public static boolean checkDividePossible(List<Integer> group) {
        if (group.isEmpty()) return false;
        List<Integer> connectedGroup = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        stack.add(group.get(0));
        connectedGroup.add(group.get(0));

        while (!stack.isEmpty()) {
            int current = stack.remove(0);
            visited[current] = true;
            for (int next : graph.get(current)) {
                if (group.contains(next) && !visited[next]) {
                    stack.add(next);
                }
            }
        }

        for (int groupIndex : group) {
            if (!visited[groupIndex]) return false;
        }
        return true;
    }

}