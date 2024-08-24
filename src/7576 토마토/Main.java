
import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int z;
    int l;
    public Node(int x ,int y,int z,int l ) {
        this.x= x;
        this.y=y;
        this.z=z;
        this.l = l;
    }
}
public class Main {
    static int[][][] graph;

    static int c, r,z;
    static int[] dx = {-1, 1, 0, 0,0,0};
    static int[] dy = {0, 0, -1, 1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static List<Node> startNodes ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        graph = new int[r][c][z];
        startNodes = new LinkedList<>();
        for(int k =0;k<z;k++){
            for (int i =0; i <r ; i++){
                st = new StringTokenizer(br.readLine());
                for (int j =0; j <c ; j++){
                    int num =Integer.parseInt(st.nextToken());
                    graph[i][j][k] =num;
                }
            }
        }

        for(int k =0;k<z;k++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (graph[i][j][k] == 1) {
                        startNodes.add(new Node(i, j, k,0));
                    }
                }
            }
        }
        int result = bfs(startNodes);
        boolean alldone = true;
        for(int k =0;k<z;k++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (graph[i][j][k] == 0) {
                        alldone = false;
                        break;
                    }
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
        queue.addAll(startNodes);
        Node node = new Node(0,0,0,0);
        while (!queue.isEmpty()) {
           node =  queue.poll();
            for(int i=0;i<6;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];
                int nl = node.l+1;
                if(nx >= 0 && ny >=0 &&nx < r && ny < c &&nz >=0&& nz<z && graph[nx][ny][nz]==0){
                    queue.add(new Node(nx,ny,nz,nl));
                    graph[nx][ny][nz]=1;
                }
            }
        }
        return node.l;
    }
}