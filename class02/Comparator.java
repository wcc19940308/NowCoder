package NowCoder.class02;

import java.util.TreeMap;
import java.util.TreeSet;

public class Comparator {
    static class Student {
        int id;

        public Student(int id) {
            this.id = id;
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(3);
        TreeSet<Student> treeSet = new TreeSet<>(new java.util.Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.id - o1.id;
            }
        });
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        for (Student s : treeSet) {
            System.out.println(s.id);
        }
    }
}
