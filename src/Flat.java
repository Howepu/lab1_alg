public class Flat {
    private int roomCount; // Количество комнат
    private int floor;     // Этаж
    private double area;   // Площадь
    private String address; // Адрес

    public Flat(int roomCount, int floor, double area, String address) {
        this.roomCount = roomCount;
        this.floor = floor;
        this.area = area;
        this.address = address;
    }

    // Геттеры
    public int getRoomCount() {
        return roomCount;
    }

    public int getFloor() {
        return floor;
    }

    public double getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    // Метод для отображения данных о квартире
    @Override
    public String toString() {
        return "Квартира: " +
                "Количество комнат: " + roomCount +
                ", Этаж: " + floor +
                ", Площадь: " + area + " кв.м" +
                ", Адрес: " + address;
    }
}
