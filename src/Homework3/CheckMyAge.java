package Homework3;

import java.util.Scanner;

public class CheckMyAge {
    public static void main(String[] args) {
        AgeCheker age = new AgeCheker();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Введите ваш возраст");
        age.ageCheck(Integer.valueOf(scnr.nextLine()));
    }
}
