package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Item> listMenu = new ArrayList<>();

    /**
     * method add a child to the parent, serves to construct Menu
     *
     * @param parentName
     * @param child
     */
    public void add(String parentName, Item child) {
        if (!listMenu.isEmpty() && child == null) {
            listMenu.add(new Item(parentName));
        } else if (!listMenu.contains(parentName) && child == null) {
            listMenu.add(new Item(parentName));
        } else if (!listMenu.isEmpty()) {
            for (Item el : listMenu) {
                if (el.getName().equals(parentName) && !el.getItems().contains(child)) {
                    el.getItems().add(child);
                }
            }
        }

    }

    public void print() {
        StringBuffer bf = new StringBuffer();
        listMenu.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Menu newMenu = new Menu();
        newMenu.add("Задача 1", null);
        newMenu.add("Задача 2", null);
        Item newItm = new Item("Задача 1.1", new InputAction());
        Item newItm1 = new Item("Задача 1.2", new DeleteAction());
        Item newItm2 = new Item("Задача 2.1", new CloseAction());
        newMenu.add("Задача 1", newItm);
        newMenu.add("Задача 1", newItm1);
        newMenu.add("Задача 2", newItm2);
        newMenu.print();
    }

}
