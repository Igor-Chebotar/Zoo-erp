package com.zoo;

import com.zoo.model.*;
import com.zoo.service.Zoo;
import com.zoo.service.VetClinic;
import com.zoo.service.VetClinicImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("com.zoo")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Zoo zoo = context.getBean(Zoo.class);
        Scanner sc = new Scanner(System.in);

        System.out.println("Московский зоопарк\n");

        while (true) {
            System.out.println("1. Добавить животное");
            System.out.println("2. Добавить вещь");
            System.out.println("3. Все животные");
            System.out.println("4. Сколько еды нужно");
            System.out.println("5. Для контактного зоопарка");
            System.out.println("6. Инвентаризация");
            System.out.println("0. Выход");
            System.out.print("> ");

            String cmd = sc.nextLine();

            if (cmd.equals("0")) break;

            switch (cmd) {
                case "1": addAnimal(zoo, sc); break;
                case "2": addThing(zoo, sc); break;
                case "3": showAnimals(zoo); break;
                case "4": System.out.println("Нужно еды: " + zoo.getTotalFood() + " кг/день\n"); break;
                case "5": showContactAnimals(zoo); break;
                case "6": showInventory(zoo); break;
            }
        }

        context.close();
    }

    static void addAnimal(Zoo zoo, Scanner sc) {
        System.out.print("Тип (1-обезьяна, 2-кролик, 3-тигр, 4-волк): ");
        String type = sc.nextLine();

        System.out.print("Имя: ");
        String name = sc.nextLine();

        System.out.print("Еда кг/день: ");
        int food = Integer.parseInt(sc.nextLine());

        System.out.print("Здоров? (да/нет): ");
        boolean healthy = sc.nextLine().equalsIgnoreCase("да");

        Animal animal;
        if (type.equals("1") || type.equals("2")) {
            System.out.print("Доброта (1-10): ");
            int kind = Integer.parseInt(sc.nextLine());
            animal = type.equals("1")
                    ? new Monkey(name, food, healthy, kind)
                    : new Rabbit(name, food, healthy, kind);
        } else {
            animal = type.equals("3")
                    ? new Tiger(name, food, healthy)
                    : new Wolf(name, food, healthy);
        }

        if (zoo.addAnimal(animal)) {
            System.out.println("Принят, номер: " + animal.getNumber() + "\n");
        } else {
            System.out.println("Не прошел ветосмотр\n");
        }
    }

    static void addThing(Zoo zoo, Scanner sc) {
        System.out.print("Тип (1-стол, 2-компьютер): ");
        String type = sc.nextLine();

        System.out.print("Название: ");
        String name = sc.nextLine();

        Thing thing = type.equals("1") ? new Table(name) : new Computer(name);
        zoo.addThing(thing);
        System.out.println("Добавлено, номер: " + thing.getNumber() + "\n");
    }

    static void showAnimals(Zoo zoo) {
        System.out.println("Животные:");
        for (Animal a : zoo.getAnimals()) {
            System.out.println("  " + a.getNumber() + ". " + a.getName() + " (" + a.getClass().getSimpleName() + ") - " + a.getFood() + " кг/день");
        }
        System.out.println();
    }

    static void showContactAnimals(Zoo zoo) {
        System.out.println("Для контактного зоопарка:");
        for (Herbo h : zoo.getContactAnimals()) {
            System.out.println("  " + h.getNumber() + ". " + h.getName() + " (доброта: " + h.getKindness() + ")");
        }
        System.out.println();
    }

    static void showInventory(Zoo zoo) {
        System.out.println("Инвентаризация:");
        for (Animal a : zoo.getAnimals()) {
            System.out.println("  #" + a.getNumber() + " " + a.getName() + " (" + a.getClass().getSimpleName() + ")");
        }
        for (Thing t : zoo.getThings()) {
            System.out.println("  #" + t.getNumber() + " " + t.getName() + " (" + t.getClass().getSimpleName() + ")");
        }
        System.out.println();
    }
}