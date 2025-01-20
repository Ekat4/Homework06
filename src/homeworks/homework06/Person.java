package homeworks.homework06;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Person {
    private String name;
    private double money;
    private List<Product> basket;

    public Person(String name, double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными.");
        }
        this.name = name;
        this.money = money;
        this.basket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public boolean buyProduct(Product product) {
        if (product.getPrice() <= money) {
            basket.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил " + product.getName());
            return true;
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
            return false;
        }
    }

    @Override
    public String toString() {
        if (basket.isEmpty()) {
            return name + " - Ничего не куплено";
        }
        StringBuilder sb = new StringBuilder(name + " - ");
        for (Product product : basket) {
            sb.append(product.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2); // Удаляем последнюю запятую
    }
}

