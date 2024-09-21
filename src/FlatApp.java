import java.util.InputMismatchException;
import java.util.Scanner;

public class FlatApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FlatList flatList = new FlatList();

    public static void main(String[] args) {
        // Создаем начальный список квартир
        initializeFlats();

        while (true) {
            System.out.println("\nБюро обмена квартир");
            System.out.println("1. Добавить квартиру");
            System.out.println("2. Показать все квартиры");
            System.out.println("3. Подать заявку на обмен");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    addFlat();
                    break;
                case 2:
                    flatList.displayFlats();
                    break;
                case 3:
                    submitExchangeRequest();
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    // Метод для инициализации начального списка квартир
    private static void initializeFlats() {
        flatList.addFlat(new Flat(2, 3, 55.0, "ул. Ленина, д. 10"));
        flatList.addFlat(new Flat(3, 5, 75.5, "ул. Гагарина, д. 5"));
        flatList.addFlat(new Flat(1, 2, 35.0, "ул. Мира, д. 15"));
        flatList.addFlat(new Flat(4, 7, 120.0, "ул. Советская, д. 20"));
        flatList.addFlat(new Flat(2, 1, 45.0, "ул. Победы, д. 3"));

        System.out.println("Начальный список квартир успешно добавлен.");
    }

    // Метод для добавления новой квартиры
    private static void addFlat() {
        System.out.print("Введите количество комнат: ");
        int roomCount = getIntInput();

        System.out.print("Введите этаж: ");
        int floor = getIntInput();

        System.out.print("Введите площадь в кв.м: ");
        double area = getDoubleInput();

        System.out.print("Введите адрес: ");
        scanner.nextLine(); // Считываем оставшийся символ новой строки
        String address = scanner.nextLine();

        Flat newFlat = new Flat(roomCount, floor, area, address);
        flatList.addFlat(newFlat);
        System.out.println("Квартира успешно добавлена.");
    }

    // Метод для подачи заявки на обмен и поиска подходящих квартир
    private static void submitExchangeRequest() {
        System.out.println("Подача заявки на обмен");

        // Дополнительный вызов nextLine() для корректного перехода на новую строку
        scanner.nextLine();

        // Ввод количества комнат
        Integer roomCount = getOptionalIntInput("Введите желаемое количество комнат (или оставьте пустым для пропуска): ");

        // Ввод этажа
        Integer floor = getOptionalIntInput("Введите желаемый этаж (или оставьте пустым для пропуска): ");

        // Ввод минимальной площади
        Double minArea = getOptionalDoubleInput("Введите минимальную площадь (или оставьте пустым для пропуска): ");

        // Ввод максимальной площади
        Double maxArea = getOptionalDoubleInput("Введите максимальную площадь (или оставьте пустым для пропуска): ");

        System.out.println("Поиск подходящих квартир...");
        flatList.findExchangeOptions(roomCount, floor, minArea, maxArea);
    }



    // Метод для получения целого числа с проверкой на корректность
    private static int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // Очистка некорректного ввода
            }
        }
    }

    // Метод для получения дробного числа с проверкой на корректность
    private static double getDoubleInput() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next(); // Очистка некорректного ввода
            }
        }
    }

    // Метод для получения необязательного целого числа
    private static Integer getOptionalIntInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Пожалуйста, введите целое число или оставьте поле пустым.");
            return getOptionalIntInput(prompt);
        }
    }

    // Метод для получения необязательного дробного числа
    private static Double getOptionalDoubleInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Пожалуйста, введите число или оставьте поле пустым.");
            return getOptionalDoubleInput(prompt);
        }
    }
}
