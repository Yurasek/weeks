package week3.graphs;

import java.util.LinkedList;

public class Graph {

    private String listVertices = WorkWithFiles.readFile("src/week3/Graph.txt");
    private int numberVertices = 0;
    private LinkedList<Integer>[] adjacVert;
    Graph(){
        fillGraph();
        print();
    }

    public LinkedList<Integer> getAdjacVert(int vertex) {
        return adjacVert[vertex];
    }

    public int getNumberVertices() {
        return numberVertices;
    }

    private int graphInit(){
        int index = 0;
        numberVertices = fetchNumber(index);
        index += Integer.toString(numberVertices).length()+1;
        adjacVert = new LinkedList[numberVertices+1];
        for(int i = 0; i< adjacVert.length-1; i++){
            adjacVert[i] = new LinkedList();
        }
        return index;
    }
    private void fillGraph(){
        int indexVertex = graphInit();
        while (indexVertex < listVertices.length()-1){
            int numberLength = Integer.toString(fetchNumber(indexVertex)).length()+1;
            addEdge(fetchNumber(indexVertex), fetchNumber(indexVertex+numberLength));
            indexVertex += numberLength;
            indexVertex += Integer.toString(fetchNumber(indexVertex)).length()+1;
        }
    }
    private int fetchNumber(int i){
        StringBuilder buf = new StringBuilder();
        while(Character.isDigit(listVertices.charAt(i))){
            buf.append(listVertices.charAt(i));
            i++;
        }
        return Integer.parseInt(buf.toString());
    }
    public void print(){
        for(int i = 0; i< adjacVert.length-1; i++){
            System.out.print(i+": [");
            for(int item: adjacVert[i]){
                System.out.print(item+", ");
            }
            System.out.println("]\n");

        }
    }
    private void addEdge(int firstVert, int secondVert){
        adjacVert[firstVert].addFirst(secondVert);
        adjacVert[secondVert].addFirst(firstVert);
    }
}
