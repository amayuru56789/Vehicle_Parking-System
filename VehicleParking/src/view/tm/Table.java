package view.tm;

public class Table {
    String number;
    String type;
    int weight;
    int passengers;

    public Table() {
    }

    public Table(String number, String type, int weight, int passengers) {
        this.number = number;
        this.type = type;
        this.weight = weight;
        this.passengers = passengers;
    }
}
