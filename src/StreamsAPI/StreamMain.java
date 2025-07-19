package StreamsAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Masha");
        names.add("Masha1");names.add("Masha2");
        names.add("Sasha");
        names.add("Pasha");
        System.out.println(names);

        System.out.println(names.stream().filter(element -> element.startsWith("M")).map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList()));
    }
}
