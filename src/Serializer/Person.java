package Serializer;
import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    transient String name;
    int age;
    Date birthDate;
    String password;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                '}';
    }

    Person(){

    }

    Person(String name, int age, Date birthDate, String password){
        this.age = age;
        this.birthDate = birthDate;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
