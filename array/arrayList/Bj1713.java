package array.arrayList;

import src.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Student[] students = new Student[101];
        List<Student> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num;
        for(int i = 0; i < m; i++) {
            num = Integer.parseInt(st.nextToken());

            if(students[num] == null) {
                students[num] = new Student(num, 0, 0, false);
            }

            if(students[num].posted) {
                students[num].count++;

            }else {
                if(list.size() == n) {
                    Collections.sort(list, (o1, o2) -> {
                        if (o1.count == o2.count) {
                            return o1.order - o2.order;
                        }
                        return o1.count - o2.count;
                    });

                    list.get(0).posted = false;
                    list.remove(0);
                }

                students[num].count = 1;
                students[num].order = i;
                students[num].posted = true;
                list.add(students[num]);
            }
        }

        Collections.sort(list, (Comparator.comparingInt(o -> o.index)));
        for(Student s : list) {
            System.out.print(s.index + " ");
        }

    }
    static class Student {
        int index;
        int count;
        int order;
        boolean posted;

        public Student(int index, int count, int order, boolean posted) {
            this.index = index;
            this.count = count;
            this.order = order;
            this.posted = posted;
        }
    }
}
