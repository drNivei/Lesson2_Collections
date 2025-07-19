package Homework5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Задания на Stream API");
        System.out.println("Фильтрация и преобразование");
        System.out.println("TASK 1: Дан список строк. Отфильтруйте строки длиной больше 5 символов и преобразуйте их в верхний регистр.");
        List<String> listStr = new ArrayList<>();
        listStr.add("Asdfggsdg");listStr.add("Asdffadfg");listStr.add("Bsd");listStr.add("Bsdg");listStr.add("Bfg");listStr.add("Asdfgaf");
        System.out.println(listStr.stream().filter(str->str.length()>5).map(String::toUpperCase).collect(Collectors.toList()));
        System.out.println();

        System.out.println("TASK 2: Из списка чисел выберите только уникальные четные числа.");
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);listInt.add(2);listInt.add(3);listInt.add(4);listInt.add(4);listInt.add(6);
        System.out.println(listInt.stream().filter(num->num%2==0).distinct().collect(Collectors.toList()));
        System.out.println();

        System.out.println("TASK 3: Преобразуйте список людей в список их имен (класс Person с полем name).");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("B", 3, "C"));
        personList.add(new Person("C", 2, "D"));
        personList.add(new Person("A", 1, "N"));
        personList.add(new Person("D", 4, "G"));
        List<String> listName = personList.stream().map(Person::getName).toList();
        System.out.println(listName);
        System.out.println();

        System.out.println("Группировка и агрегация");
        System.out.println("TASK 4: Сгруппируйте список строк по их длине.");
        List<String> listStr1 = new ArrayList<>();
        listStr1.add("12345");listStr1.add("12345");listStr1.add("123");listStr1.add("1234");listStr1.add("123");listStr1.add("1234567");
        System.out.println(listStr1);
        System.out.println(listStr1.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println();

        System.out.println("TASK 5: Найдите среднее значение чисел в списке.");
        List<Integer> listInt1 = new ArrayList<>();
        listInt1.add(1);listInt1.add(2);listInt1.add(3);listInt1.add(4);listInt1.add(4);listInt1.add(6);
        System.out.println(listInt1);
        System.out.println(listInt1.stream().collect(Collectors.averagingDouble(Integer::intValue)));
        System.out.println();

        System.out.println("TASK 6: Посчитайте сумму всех чисел, больших 10.");
        List<Integer> listInt2 = new ArrayList<>();
        listInt2.add(1);listInt2.add(2);listInt2.add(3);listInt2.add(11);listInt2.add(13);listInt2.add(12);
        System.out.println(listInt2);
        System.out.println(listInt2.stream().filter(num->num>10).collect(Collectors.summingInt(Integer::intValue)));
        System.out.println((Integer) listInt2.stream().filter(num -> num > 10).mapToInt(Integer::intValue).sum());//same
        System.out.println();

        System.out.println("Работа с объектами");
        System.out.println("TASK 7: Дан список Person (с полями name, age). Найдите самого старшего человека.");
        List<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("B", 3, "C"));
        personList1.add(new Person("C", 2, "D"));
        personList1.add(new Person("A", 1, "N"));
        personList1.add(new Person("D", 4, "G"));
        System.out.println(personList1.stream().max(Comparator.comparingDouble(Person::getAge)));
        System.out.println();

        System.out.println("TASK 7: Отсортируйте список людей по имени в обратном порядке.");
        List<String> listStr3 = new ArrayList<>();
        listStr3.add("Alex");listStr3.add("Bob");listStr3.add("Cidney");listStr3.add("Vova");
        System.out.println(listStr3);
        System.out.println(listStr3.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println();

        System.out.println("TASK 8: Получите список имен людей, возраст которых больше 18.");
        List<Person> personList2 = new ArrayList<>();
        personList2.add(new Person("B", 3, "C"));
        personList2.add(new Person("C", 19, "D"));
        personList2.add(new Person("A", 1, "N"));
        personList2.add(new Person("D", 20, "G"));
        System.out.println(personList2);
        System.out.println(personList2.stream().filter(pr->pr.getAge() > 18).map(Person::getName).collect(Collectors.toList()));
        System.out.println();

        System.out.println("Продвинутые операции");
        System.out.println("TASK 9: Разделите список чисел на два: четные и нечетные (используйте partitioningBy).");
        List<Integer> listInt3 = new ArrayList<>();
        listInt3.add(1);listInt3.add(2);listInt3.add(3);listInt3.add(4);listInt3.add(5);listInt3.add(6);
        System.out.println(listInt3);
        System.out.println(listInt3.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0)));
        System.out.println();

        System.out.println("TASK 10: Объедините все строки из списка в одну, разделяя их запятой.");
        List<String> listStr4 = new ArrayList<>();
        listStr4.add("Alex");listStr4.add("Bob");listStr4.add("Cidney");listStr4.add("Vova");
        System.out.println(listStr4);
        System.out.println(listStr4.stream().collect(Collectors.joining(", ")));
        System.out.println(String.join(", ", listStr4));//same
        System.out.println();

        System.out.println("TASK 11: Разделите список чисел на два: четные и нечетные (используйте partitioningBy).");
        List<Integer> listInt4 = new ArrayList<>();
        listInt4.add(1);listInt4.add(2);listInt4.add(3);listInt4.add(4);listInt4.add(5);listInt4.add(6);
        System.out.println(listInt4);
        System.out.println(listInt4.stream().filter(num->num % 3 == 0).findFirst());
        System.out.println();

        System.out.println("Генерация и итерация");
        System.out.println("TASK 12: Создайте Stream из 10 случайных чисел и выведите их.");
        long streamSize = 10; // Generate 10 random integers
        Random random = new Random();
        IntStream limitedIntStream = random.ints(streamSize);
        limitedIntStream.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK 13: Сгенерируйте бесконечный поток чисел Фибоначчи и ограничьте его 10 элементами.");
        int limit = 10; // Number of Fibonacci numbers to generate
        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(limit)
                .map(fib -> fib[0]) // Extract the first element (the Fibonacci number)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("TASK 14: Преобразуйте массив строк в Stream, отсортируйте и соберите в список.");
        String[] listStr5 = {"apple", "banana", "cherry", "ananas"};
        Stream<String> stringStream = Arrays.stream(listStr5);
        listStr5 = stringStream.sorted().collect(Collectors.toList()).toArray(new String[0]);
        System.out.println(Arrays.toString(listStr5));







    }
}
