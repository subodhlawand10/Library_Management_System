package librarymanagementsystem;

import java.util.ArrayList;

class Student{

    private static ArrayList<Student> students = new ArrayList<>();

    private int id;
    private String name;

    public int getId(){
        return id;
    }

    public void setId(int id){
        if(id>0){
            this.id = id;
        } else {
            System.out.println("Invalid ID");
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name == null || name.trim().isEmpty()){
            System.out.println("Invalid Name");
        } else {
            this.name = name;
        }
    }

    public Student(int id, String name){
        setId(id);
        setName(name);
    }

    public static Student findStudent(String name){
        for(Student studentName : students){
            if(studentName.getName().equalsIgnoreCase(name)){
                return studentName;
            }
        }
        return null;
    }

    public static Student findStudent(int id){
        for (Student studentName : students) {
            if(studentName.getId()==id){
                return studentName;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student { id = " + id + ", Name = '" + name + "\'" + '}';
    }

    public static void registerStudent(Student s){
        students.add(s);
        System.out.println("Student Added : "+s);
    }

    public static void deleteStudent(Student s){
        students.remove(s);
        System.out.println("Student Deleted : "+s);
    }

    public static void getAllStudents() {
        if(students.isEmpty()){
            System.out.println("No Students Registered Yet...");
            return;
        }
        for (Student s: students){
            System.out.println(s);
        }
    }

}