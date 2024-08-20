import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x ,int y) {
        this.x= x;
        this.y=y;
    }
}
public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[][] result;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0}; // 상,하,좌,우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];

        for (int i =0; i <n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j =0; j <m ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x =0; int y=0;
        for (int i =0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x,y);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    result[i][j] = -1;
                }
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static public void bfs(int a ,int b){
        Queue<Node> queue = new LinkedList<>();
        visited[a][b]= true;
        result[a][b]= 0;

        queue.add(new Node(a,b));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx >= 0 && ny >=0 &&nx < n && ny < m  && !visited[nx][ny] && graph[nx][ny]==1){
                    queue.add(new Node(nx,ny));
                    visited[nx][ny]=true;
                    result[nx][ny]=result[node.x][node.y]+1;
                }
            }

        }
    }
}