package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class Item {
    /**
     * it's a field name of the some action;
     */
    String name;
    /**
     * it's a field some of the some action due to catch menu option ;
     */
    Action action;
    /**
     * it's a field some child elements;
     */
    List<Item> items = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (!getName().equals(item.getName())) {
            return false;
        }
        if (!getAction().equals(item.getAction())) {
            return false;
        }
        return getItems().equals(item.getItems());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAction().hashCode();
        result = 31 * result + getItems().hashCode();
        return result;
    }

    public Item(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public Item(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        if (items.size() == 0 || items.contains(null)) {
            bf.append(this.getName());
        } else if (items.size() != 0) {
            bf.append("-").append(this.getName()).append('\n');
            items.forEach(e -> bf.append('\t').append("--").append(e).append('\n'));
        }
        return bf.toString();
    }
}
