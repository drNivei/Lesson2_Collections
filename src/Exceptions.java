import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Exceptions {
    public static void main(String[] args) {
        ArrayList<String> exc = new ArrayList<String>(){
            {
                add("Word1");
                add("Word2");
                add("Word3");
            }

            public void printinfo(){
                System.out.println("INFO");
            }


            @Override
            public boolean add(String s) {
                System.out.println(
                        "Element was added"
                );
                return super.add(s);
            }
        };
        try {
            for (int i = 0; i <= exc.size(); i++) {
                System.out.println(exc.get(i));
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }

        System.out.println("Test");
        try {
            FileReader fileReader = new FileReader("nonexistent.txt");
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        throw new IllegalArgumentException("Не нашли файл");
    }
}
