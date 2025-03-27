package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 트리_색칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Graph[] graphs = new Graph[Integer.parseInt(s)];


    }

    private static class Graph {
        int val;
        List<List<Integer>> adj;
    }
}
