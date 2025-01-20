package homeworks.homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Хлеб", 40));
        products.add(new Product("Молоко", 60));
        products.add(new Product("Торт", 1000));
        products.add(new Product("Кофе растворимый", 879));
        products.add(new Product("Масло", 150));
        products.add(new Product("Мороженое", 200));
        products.add(new Product("Макароны", 800));

        List<Person> people = new ArrayList<>();
        String[] names = {"Павел Андреевич", "Анна Петровна", "Борис", "Женя", "Света"};
        double[] money = {10000, 2000, 10, 0, -3}; // Включаем отрицательные деньги для Светы

        for (int i = 0; i < names.length; i++) {
            try {
                people.add(new Person(names[i], money[i]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " для " + names[i]);
            }
        }

        // Обработка покупок
        for (Person person : people) {
            System.out.println(person.getName() + " = " + person.getMoney());
            while (true) {
                System.out.print(person.getName() + ", выберите продукт для покупки (или введите 'END' для завершения): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("END")) {
                    break;
                }
                boolean found = false;
                for (Product product : products) {
                    if (product.getName().equalsIgnoreCase(choice)) {
                        found = person.buyProduct(product);
                        if (found) {
                            break;
                        }
                    }
                }
                if (!found) {
                    System.out.println("Продукт не найден. Пожалуйста, выберите другой продукт.");
                }
            }
            System.out.println(person);
        }

        scanner.close();
    }
}

