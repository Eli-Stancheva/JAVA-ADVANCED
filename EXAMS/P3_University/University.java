package ADVANCED.EXAMS.Exam_5_14_April_2021.P3_University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder builder = new StringBuilder();
        if (getStudentCount() < capacity) {
            if (students.contains(student)){
                builder.append("Student is already in the university");
            } else {
                students.add(student);
                builder.append(String.format("Added student %s %s\n", student.getFirstName(), student.getLastName()));
            }
        } else {
            builder.append("No seats in the university");
        }

        return builder.toString();
    }

    public String dismissStudent(Student student) {
        for (Student student1 : students) {
            if (students.contains(student)){
                students.remove(student1);
                return "Removed student " + student.getFirstName() + " " + student.getLastName();
            }
        }
        return "Student not found";
    }

    public String getStudent(String firstName, String lastName) {
        StringBuilder builder = new StringBuilder();
        for (Student s : students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
              builder.append(s.toString());
            }
        }
       return builder.toString().trim();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Student s : students) {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s\n", s.getFirstName(), s.getLastName(), s.getBestSubject()));
        }
        return builder.toString().trim();
    }
}
