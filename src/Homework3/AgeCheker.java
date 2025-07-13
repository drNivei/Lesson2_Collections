package Homework3;

public class AgeCheker{
    public void ageCheck(int age){
        if(age<18){
            throw new TooYoungException("Слишком молодой!");
        } else if (age>120) {
            throw new TooYoungException("Слишком старый!");
        } else{
            System.out.println("Возраст корректный!");
        }
    }

}
