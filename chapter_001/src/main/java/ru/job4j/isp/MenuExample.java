package ru.job4j.isp;

import java.util.List;

/**
 * Создать меню.[4748#254047] *
 * Задача 1.
 * ---- Задача 1.1.
 * --------- Задача 1.1.1.
 * --------- Задача 1.1.2.
 * ---- Задача 1.2.
 */

class MenuExample {
    private static List<String> spisok;

    MenuExample(List<String> spisok) {
        this.spisok = spisok;
    }

    interface MenuOne {

        default void print() {
            spisok.get(0);
        }

    }

    interface MenuRangeOne {

        static void printOne() {
            System.out.println(spisok.get(1));
        }
    }

    interface MenuRangeTwo {

        static void printTwo() {
            System.out.println(spisok.get(2));
        }
    }

    interface MenuRangeThree {

        static void printThree() {
            System.out.println(spisok.get(3));
        }
    }

    interface CommonInterface extends MenuRangeOne, MenuRangeTwo, MenuRangeThree {

        static void printMenu() {
            spisok.forEach(System.out::println);
        }

        static void selectPointMenu(String numer) {
            switch (numer) {
                case "1":
                    MenuRangeOne.printOne();
                    break;
                case "1.1":
                    MenuRangeTwo.printTwo();
                    break;
                case "1.2":
                    MenuRangeThree.printThree();
                    break;
                default:
                    System.out.println("Please, select menu option");
            }
        }
    }

    public static void main(String[] args) {
        new MenuExample(List.of("Задача 1.", "---- Задача 1.1.", "--------- Задача 1.1.1.", "--------- Задача 1.1.1.", "--------- Задача 1.1.2."));
        CommonInterface.printMenu();

        System.out.println("User select menu option  1.1 and result is:");

        CommonInterface.selectPointMenu("1.2");
    }
}
