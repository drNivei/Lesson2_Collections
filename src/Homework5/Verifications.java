package Homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Verifications {
    //Task1
    public List<Integer> myIntPrediction (Predicate<Integer> predicate, List<Integer> a){
        List<Integer> checkList = new ArrayList<>();
        for (Integer i: a){
            if (predicate.test(i)) {
                checkList.add(i);
            }
        }
        return checkList;
    }
    //Task2
    public void upperLetter (String a){
        Predicate<Character> predicate = Character::isUpperCase;
        char firstChar = a.charAt(0);
        if (predicate.test(firstChar)){
            System.out.println("String starts with upper case!");
        }else {
            System.out.println("String starts with lower case!");
        }
    }

    //Task3
    public void numberCheckEvenAndMoreThanTen(Integer a){
        Predicate<Integer> predicateTen = num -> num > 10;
        Predicate<Integer> predicateEven = num -> num % 2 == 0;
        Predicate<Integer> predicate = predicateTen.and(predicateEven);

        if(predicate.test(a)){
            System.out.println("Число больше 10 и четное!");
        }else {
            System.out.println("Число подобрано неверно!");
        }

    }

    public List<Integer> stringLength(Function<String, Integer> func, List<String> str){
        List<Integer> strNum = new ArrayList<>();
        for(String x: str){
            strNum.add(func.apply(x));
        }
        return strNum;
    }

    public List<Integer> intQuadro (List<Integer> intMass){
        List<Integer> strNum = new ArrayList<>();
        Function<Integer, Integer> func = num -> num * num;
        for(Integer x: intMass){
            strNum.add(func.apply(x));
        }
        return strNum;
    }

    public void myConsumer (Consumer<String> consumer, List<String> str){
        for (String x: str){
            consumer.accept(x);
        }
    }

    public List<String> generateRandomString(Supplier<List<String>> supplier) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i<5; i++){
            list.addAll(supplier.get());
        }
        return list;
    }


}
