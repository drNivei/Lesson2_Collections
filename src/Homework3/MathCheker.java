package Homework3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MathCheker {
    public static void main(String[] args) {
        try{
        Scanner new_value = new Scanner(System.in);
        Integer a, b;
        System.out.println("Введите делимое");
        a =  Integer.valueOf(new_value.nextLine());
        System.out.println("Введите делитель");
        b =  Integer.valueOf(new_value.nextLine());
            System.out.println("Результат деления: " + a/b);
        } catch (InputMismatchException e) {
            System.out.println("Деление возможно только для чисел!");
        } catch (ArithmeticException e) {
            System.out.println("Делить на ноль нельзя!");
        } catch(NumberFormatException e){
            System.out.println("Деление возможно только для чисел!");
        }
    }
}
