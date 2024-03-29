package org.example;

public class Dog extends  Animal{

    String breed;

    int height;


    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name, int age, String breed, int height) {
        super(name, age);
        this.breed = breed;
        this.height = height;
    }

    public void bark(){
        System.out.println("Собака по имени" + this.name + " гавкает");
    }


    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
