package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2644 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(br.readLine());        // 전체 사람의 수
        int[][] familyTree = new int[N][N];      // 족보 생성
        boolean[] visited = new boolean[N];

        stringTokenizer = new StringTokenizer(br.readLine());       // 촌수를 계산해야 하는 서로 다른 두 사람의 번호
        int target1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int target2 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int person1, person2;

        int M = Integer.parseInt(br.readLine());        // 부모 자식들 간의 관계의 개수
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            person1 = Integer.parseInt(stringTokenizer.nextToken());
            person2 = Integer.parseInt(stringTokenizer.nextToken());
            familyTree[person1 - 1][person2 - 1] = 1;
            familyTree[person2 - 1][person1 - 1] = 1;
        }

        int result = bfs(target1, target2, familyTree, visited);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static int bfs(int rootNode, int targetNode, int[][] familyTree, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int i = 0; i < familyTree[nowNode].length; i++) {
                if (familyTree[nowNode][i] > 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    for (int j = 0; j < familyTree[i].length; j++) {
                        if (familyTree[i][j] > 0) {
                            familyTree[i][j] = familyTree[nowNode][i] + 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < familyTree.length; i++) {
            if (familyTree[i][targetNode] > 1) {
                return familyTree[i][targetNode];
            }
        }

        return -1;
    }
}
