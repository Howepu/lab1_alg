public class FlatNode {
    Flat flat;      // Ссылка на объект квартиры
    FlatNode next;  // Ссылка на следующий элемент в списке

    public FlatNode(Flat flat) {
        this.flat = flat;
        this.next = null;
    }
}
