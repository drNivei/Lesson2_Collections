package Homework4;

public class Main {
    public static void main(String[] args) {
        try (FileLogger res_new = new FileLogger("C:\\Users\\Alex\\IdeaProjects\\Lesson2_Collections\\src\\Homework4\\example.txt")) {
            res_new.log("THIS IS A NEW ROW - 1");
            res_new.log("THIS IS A NEW ROW - 2");
            res_new.log("THIS IS A NEW ROW - 3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
