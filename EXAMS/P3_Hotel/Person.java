package ADVANCED.EXAMS.Exam_2_23_October_2021.P3_Hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown = "n/a";

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getHometown() {
        return hometown;
    }

    public String toString(){
        return String.format("Person %s: %d, Age: %d, Hometown: %s", name, id, age, hometown);
    }
}
