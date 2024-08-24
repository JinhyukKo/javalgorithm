
import java.io.*;
import java.util.*;
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       int  start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        System.out.println(bfs(start,end));

    }


        static public int bfs(int start,int end){
             if (start == end) return 0;
             Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(start,0));
            while (!queue.isEmpty()) {
                Node node =  queue.poll();
                int[] nextPositions = {node.x - 1, node.x + 1, node.x * 2};
                for (int neighbor : nextPositions) {
                    if (neighbor < 0 || neighbor > 100000|| visited[neighbor]) continue;
                    if(neighbor == end) return node.y+1;
                    visited[neighbor] = true;
                    queue.offer(new Node(neighbor,node.y+1));

                }

            }
            return -1;
        }
    }

