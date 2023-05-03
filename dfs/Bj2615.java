package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] board = new int[19][19];

        for(int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 19; j++) {
                int input = Integer.parseInt(st.nextToken());
                board[i][j] = input;
            }
        }

        int[][] direction = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};

        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(board[j][i] == 1 || board[j][i] == 2) {
                    for(int k = 0; k < 4; k++) {
                        int nextX = j;
                        int nextY = i;
                        int count = 1;

                        while (true) {
                            nextX += direction[k][0];
                            nextY += direction[k][1];
                            if(0 <= nextX && nextX < 19 && 0 <= nextY && nextY < 19) {
                                if(board[j][i] == board[nextX][nextY]) {
                                    count++;
                                }else {
                                    break;
                                }
                            }else  {
                                break;
                            }
                        }

                        nextX = j;
                        nextY = i;

                        while (true) {
                            nextX -= direction[k][0];
                            nextY -= direction[k][1];
                            if(0 <= nextX && nextX < 19 && 0 <= nextY && nextY < 19) {
                                if(board[j][i] == board[nextX][nextY]) {
                                    count++;
                                }else {
                                    break;
                                }
                            }else  {
                                break;
                            }
                        }

                        if(count == 5) {
                            System.out.println(board[j][i]);
                            System.out.println((j + 1) + " " + (i + 1));

                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
