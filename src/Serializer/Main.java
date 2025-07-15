package Serializer;

import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Sasha", 21, new Date(), "dkaskfoasfoi");
        Person person1 = new Person("MAsha", 26, new Date(), "dkafsjkdnfsdygoasfoi");
        serializeObject("person.txt", person);
        serializeObject("person1.txt", person1);

        Person desObj = (Person) deserializeObject("person.txt");
        System.out.println(desObj.toString());
    }

    public static void serializeObject(String fileName, Object Person) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(Person);
            System.out.println("Object successfully serialized!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserializeObject(String fileName) {
        Object person = null;
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            person = in.readObject();
            System.out.println("Deserialization completed!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
