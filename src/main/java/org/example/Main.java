package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {


        Dog muhtar = new Dog("Мухтар", 3, " Овчарка", 5);
        Dog sharik = new Dog("Шарик", 10, " Дворняга", 4);

        Cat murzik = new Cat("Мурзик", 2, "Белый", 3);
        Cat kesha = new Cat("Кеша", 1, "Ражий", 2);


        Animal[] animals = {muhtar, sharik, murzik, kesha};


        Integer indexMap = 0;
        Map<Integer, List<String>> animalMap = new HashMap<>();

        for (Animal animal : animals) {
            Class clazz = animal.getClass();
            // эквивалентно




            //Поля супер класса

            Class superclass = clazz.getSuperclass();

            Field[] fields2 = superclass.getDeclaredFields();

//Создадим хэш мапу для  животного

            //Зададим индекс(ключ) для животного

            indexMap = indexMap + 1;


            //Создаем лист стринг жобавляем туда данные кокрентному животному

            List<String> fieldsValuesAnimal = new ArrayList<>();


            for (Field field : fields2) {


                //по итогу как закончена итерация лист отправляем в мапу


                Field superField = clazz.getSuperclass().getDeclaredField(field.getName().toString());

                //строка для листа мапы
                String fieldName = superField.getName();


                //строка для листа мапы
                String fieldValue = superField.get(animal).toString();


                //добавляем строки в лист

                fieldsValuesAnimal.add(fieldName);
                fieldsValuesAnimal.add(fieldValue);


                // System.out.println( fieldName);

                // System.out.println( fieldValue);

            }
            //Как наполнили лист по животному отправляем лист в мапу по текущему индексу

            animalMap.put(indexMap, fieldsValuesAnimal);

        }

        //теперь делаем вторую итерацию по животным и доставанию полей где будем обращаться к мепе по ключу и
        // пытаться обратиться к значению в виде листа и добавить туда данные

        //обнуляем счетчик
        indexMap = 0;


        for (Animal animal : animals) {
            Class clazz = animal.getClass();
            // эквивалентно

//Поля обычные


            Field[] fields = clazz.getDeclaredFields();

            //Поля супер класса


//Создадим хэш мапу для  животного

            //Зададим индекс(ключ) для животного

            indexMap = indexMap + 1;


            //Создаем лист стринг жобавляем туда данные кокрентному животному

            //List<String> fieldsValuesAnimal = new ArrayList<>();


            for (Field field : fields) {


                //по итогу как закончена итерация лист отправляем в мапу


                Field superField = clazz.getDeclaredField(field.getName().toString());

                //строка для листа мапы
                String fieldName = superField.getName();


                //строка для листа мапы
                String fieldValue = superField.get(animal).toString();

                animalMap.get(indexMap).add(fieldName);
                animalMap.get(indexMap).add(fieldValue);


                //добавляем строки в лист

                //fieldsValuesAnimal.add(fieldName);
                //fieldsValuesAnimal.add(fieldValue);


            }
            //Как наполнили лист по животному отправляем лист в мапу по текущему индексу

            //animalMap.put(indexMap, fieldsValuesAnimal);

        }


        System.out.println("Печатаем MAP с полями объектов, ключ-уникальный номер объекта");

        System.out.println(animalMap);

        for (Animal animal : animals) {
            Class clazz = animal.getClass();

            Method[] methods = animal.getClass().getMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName == "makesound") {
                    System.out.println("Найдет метод  '" +  methodName + "'!  для животного по имени  " + animal.name);
                    System.out.println("Вызывем метод ниже:");

                    method.invoke(animal);

                    System.out.println("Метод вызван успешно");
                    System.out.println("_______________________________________");


                }


           /* System.out.println("Method name : " + method.getName());
            System.out.println("Return type : " +
                    method.getReturnType().getName());

            Class<?>[] params = method.getParameterTypes();
            System.out.print("Parameters : ");
            for (Class<?> paramType : params) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();

            */
            }


            //Class classCat =Class.forName("org.example.Cat");
            //Constructor[] catConstructors = classCat.getConstructors();


        }
    }
}

