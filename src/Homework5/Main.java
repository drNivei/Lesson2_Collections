package Homework5;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Comparator.comparingInt;

public class Main {
    public static void main(String[] args) {
        Verifications ver = new Verifications();

        System.out.println("Predicate");

        System.out.println("Task 1: Напишите метод, который принимает Predicate<Integer> и список чисел, возвращает список чисел, удовлетворяющих условию предиката.");
        Predicate<Integer> predicateInteger = num -> num > 10;
        List<Integer> list = new ArrayList<>();
        list.add(8); list.add(9); list.add(10); list.add(11);list.add(12);
        System.out.println(ver.myIntPrediction(predicateInteger, list));
        System.out.println();

        System.out.println("Task 2: Создайте Predicate<String>, проверяющий, что строка начинается с заглавной буквы.");
        ver.upperLetter("hello world!");
        ver.upperLetter("Hello world!");
        System.out.println();

        System.out.println("Task 3: Объедините два предиката (and, or) для проверки, что число четное и больше 10.");
        ver.numberCheckEvenAndMoreThanTen(10);
        ver.numberCheckEvenAndMoreThanTen(11);
        ver.numberCheckEvenAndMoreThanTen(12);
        System.out.println();

        System.out.println("Function");

        System.out.println("Task 4: Напишите метод, принимающий Function<String, Integer> и список строк, возвращающий список их длин.");
        Function<String, Integer> functionStringLength = String::length;
        List<String> str = new ArrayList<>();
        str.add("1234"); str.add("1234567"); str.add("12345"); str.add("123");
        System.out.println(ver.stringLength(functionStringLength, str));
        System.out.println();

        System.out.println("Task 5: Преобразуйте список чисел в список их квадратов, используя Function<Integer, Integer>.");
        List<Integer> numQudr = new ArrayList<>();
        numQudr.add(1);numQudr.add(2);numQudr.add(3);numQudr.add(4);
        System.out.println(ver.intQuadro(numQudr));
        System.out.println();

        System.out.println("Task 6: Создайте цепочку функций: String -> Integer (длина строки) -> Integer (квадрат числа).");
        Function<Integer, Integer> func = num -> num * num;
        Function<String, Integer> funcStringLength = String::length;
        funcStringLength = funcStringLength.andThen(func);
        System.out.println(funcStringLength.apply("12345"));
        System.out.println();

        System.out.println("Consumer");
        System.out.println("Task 7: Напишите метод, который принимает Consumer<String> и список строк, применяя его к каждому элементу.");
        Consumer<String> consumer = System.out::println;
        List<String> consStrList = new ArrayList<>();
        consStrList.add("Mama");consStrList.add("Papa");
        ver.myConsumer(consumer,consStrList);
        System.out.println();

        System.out.println("Task 8: Создайте Consumer, который печатает строку в верхнем регистре.");
        Function<String, String> toUpCase = String::toUpperCase;
        Consumer<String> consToUpCase = str1 -> System.out.println(toUpCase.apply(str1));
        consToUpCase.accept("upper case string");
        System.out.println();

        System.out.println("Task 9: Используйте andThen для двух Consumer: первый печатает строку, второй – её длину.");
        Consumer<String> consumer1 = System.out::println;
        Consumer<String> consumer2 = str3 -> System.out.println(str3.length());
        consumer1 = consumer1.andThen(consumer2);
        consumer1.accept("IT'S ME, MARIO!");
        System.out.println();

        System.out.println("Supplier");
        System.out.println("Task 10: Напишите Supplier, возвращающий случайное число от 1 до 100");
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
        System.out.println(randomNumberSupplier.get());
        System.out.println();

        System.out.println("Task 11: Создайте метод, который принимает Supplier<List<String>> и возвращает список из 5 элементов, сгенерированных поставщиком.");
        Supplier<List<String>> newRandomString = () -> Collections.singletonList("Sasha"+ new Random().nextInt(100));
        System.out.println(ver.generateRandomString(newRandomString));

        System.out.println("Комбинированные задания");
        System.out.println("Task 12: Напишите метод, принимающий Function и Predicate, и возвращающий новый Predicate.");
        Predicate<String> srt11 = str11 -> str11.startsWith("T");
        Function<String, String> fn11 = String::toLowerCase;
        Predicate<String> srt11_new = ver.newPredicateMe(srt11, fn11);
        System.out.println(srt11_new.test("true"));
        System.out.println(srt11_new.test("other"));
        System.out.println();

        System.out.println("Task 13: Создайте Comparator с использованием Function для сортировки объектов по определенному полю.");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("B", 3, "C"));
        personList.add(new Person("C", 2, "D"));
        personList.add(new Person("A", 1, "N"));
        personList.add(new Person("D", 4, "G"));

        personList.sort(Comparator.comparing(p -> p.name));
        System.out.println(personList);
        personList.sort((p1, p2) -> p2.name.compareTo(p1.name));
        System.out.println(personList);

        personList.sort(Comparator.comparing(p -> p.age));
        System.out.println(personList);
        personList.sort((p1, p2) -> p2.age.compareTo(p1.age));
        System.out.println(personList);



    }
}
