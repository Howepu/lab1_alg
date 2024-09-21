public class FlatList {
    private FlatNode head; // Начало связного списка

    // Метод для добавления квартиры в список
    public void addFlat(Flat flat) {
        FlatNode newNode = new FlatNode(flat);
        if (head == null) {
            head = newNode;
        } else {
            FlatNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Метод для вывода всех квартир в списке
    public void displayFlats() {
        FlatNode current = head;
        if (current == null) {
            System.out.println("Картотека пуста.");
            return;
        }

        while (current != null) {
            System.out.println(current.flat);
            current = current.next;
        }
    }

    // Метод для поиска подходящих квартир по заявке на обмен
    public void findExchangeOptions(Integer roomCount, Integer floor, Double minArea, Double maxArea) {
        FlatNode current = head;
        boolean found = false;

        while (current != null) {
            Flat flat = current.flat;

            // Проверка параметров с учетом возможности игнорирования параметров
            boolean roomMatch = (roomCount == null || flat.getRoomCount() == roomCount);
            boolean floorMatch = (floor == null || flat.getFloor() == floor);
            boolean areaMatch = (minArea == null || flat.getArea() >= minArea)
                    && (maxArea == null || flat.getArea() <= maxArea);

            if (roomMatch && floorMatch && areaMatch) {
                System.out.println("Подходящая квартира: " + flat);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Подходящих квартир не найдено.");
        }
    }
}
