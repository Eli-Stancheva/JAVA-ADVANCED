package ADVANCED.EXERCISE_6_Defining_Classes.P7_Google;

public class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString(){
        return childName + " " + childBirthday;
    }
}
