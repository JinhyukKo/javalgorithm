import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Boolean> map = new HashMap<>();
        for(int i =0;i<N;i++){
            map.put(br.readLine(),false);
        }
        for(int i =0;i<M;i++){

            map.get(br.readLine());
        }



}}