
import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int z;
    public Node(int x ,int y,int z) {
        this.x= x;
        this.y=y;
        this.z=z;
    }
}
public class Main {
    static int[][] graph;

    static int c, r;
    static int[] dx = {-1, 1, 0, 0}; // 상,하,좌,우
    static int[] dy = {0, 0, -1, 1};
    static List<Node> startNodes ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new int[r][c];

        startNodes = new LinkedList<>();

        for (int i =0; i <r ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j =0; j <c ; j++){
                int num =Integer.parseInt(st.nextToken());

                graph[i][j] =num;
            }
        }

        for (int i =0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] == 1) {
                    startNodes.add(new Node(i,j,0));
                }
            }
        }
        int result = bfs(startNodes);
        boolean alldone = true;
        for (int i =0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] == 0) {
                   alldone=false;
                   break;
                }
            }
        }
        if(alldone) {
            System.out.println(result);
        } else{
            System.out.println(-1);
        }

    }
    static public int bfs(List<Node> startNodes){
        Queue<Node> queue = new LinkedList<>();
        for(Node n : startNodes){
            queue.add(n);
        }
        Node node = new Node(0,0,0);
        while (!queue.isEmpty()) {
           node =  queue.poll();
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + 1;
                if(nx >= 0 && ny >=0 &&nx < r && ny < c  && graph[nx][ny]==0){
                    queue.add(new Node(nx,ny,nz));
                    graph[nx][ny]=1;
                }
            }
        }
        return node.z;
    }
}