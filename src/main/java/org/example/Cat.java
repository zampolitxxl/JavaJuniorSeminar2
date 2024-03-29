package org.example;

public class Cat extends  Animal {

    String  color;

    int wight;

    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat(String name, int age, String color, int wight) {
        super(name, age);
        this.color = color;
        this.wight = wight;
    }

    public  void drinkMilk(int mililitres){
        System.out.println("котик по  имени " + this.name + "выпил " + mililitres + " " +
                "милилитров молока и сказал мяу");

    }

    public  void  makesound(){
        System.out.println("Мяу");
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", wight=" + wight +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
