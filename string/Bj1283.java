package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        boolean[] alphabet = new boolean[26];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for(int i = 0; i < n; i++) {
            if(arr[i].contains(" ")) {
                boolean check = false;
                String[] s = arr[i].split(" ");
                for(int j = 0; j < s.length; j++) {
                    if(!alphabet[Character.toUpperCase(s[j].charAt(0)) - 65]) {
                        alphabet[Character.toUpperCase(s[j].charAt(0)) - 65] = true;
                        s[j] = "[" + s[j].substring(0, 1) + "]" + s[j].substring(1);
                        check = true;
                        break;
                    }
                }

                arr[i] = String.join(" ", s);

                if(!check) {
                    for(int j = 0; j < arr[i].length(); j++) {
                        if(arr[i].charAt(j) != ' ') {
                            if(!alphabet[Character.toUpperCase(arr[i].charAt(j)) - 65]) {
                                alphabet[Character.toUpperCase(arr[i].charAt(j)) - 65] = true;
                                arr[i] = arr[i].substring(0, j) + "[" + arr[i].substring(j, j + 1) + "]" + arr[i].substring(j + 1);
                                break;
                            }
                        }
                    }
                }
            }else {
                for(int j = 0; j < arr[i].length(); j++) {
                    if(!alphabet[Character.toUpperCase(arr[i].charAt(j)) - 65]) {
                        alphabet[Character.toUpperCase(arr[i].charAt(j)) - 65] = true;
                        arr[i] = arr[i].substring(0, j) + "[" + arr[i].substring(j, j + 1) + "]" + arr[i].substring(j + 1);
                        break;
                    }
                }
            }
        }

        for(String str : arr) {
            System.out.println(str);
        }
    }
}
