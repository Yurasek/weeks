package week3.graphs;

import java.util.Scanner;
import java.util.Stack;
public class DepthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstSearch(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.getNumberVertices()];
        marked = new boolean[G.getNumberVertices()];
        dfs(G, s);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.getAdjacVert(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public void pathTo(int v, Stack<Integer> path) {
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите исходную вершину: ");
        int from = scan.nextInt();//Integer.parseInt(args[1]);
        System.out.println("Введите вершину, путь в которую нужно найти: ");
        int to = scan.nextInt();
        DepthFirstSearch dfs = new DepthFirstSearch(G, from);

        //for (int v = 0; v < G.getNumberVertices(); v++) {
            if (dfs.hasPathTo(to)) {
                Stack<Integer> path = new Stack<>();
                System.out.printf("%d to %d: ", from, to);
                dfs.pathTo(to, path);
                while(!path.empty()) {
                    if (path.peek() == from) {
                        System.out.print(path.pop());
                    } else{
                        System.out.print("-" + path.pop());
                    }
                }
            } else{
                System.out.printf("%d to %d:  нет пути\n", from, to);
            }
        //}
    }

}
