package com.cooper.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetMinMaxFromObjectList {

    public static class Student {

        private String name;
        private String age;

        public  Student(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}
    }

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Pea", "55"));
        studentList.add(new Student("Ni", "35"));
        studentList.add(new Student("Pang", "65"));
        studentList.add(new Student("Tum", "50"));
        studentList.add(new Student("Sombut", "45"));

        Student student =  Collections.max(studentList, Comparator.comparing(s -> s.getAge()));
        System.out.println("The older student is : " + student.getName());

        student =  Collections.min(studentList, Comparator.comparing(s -> s.getAge()));
        System.out.println("The youngest student is : " + student.getName());


    }
}