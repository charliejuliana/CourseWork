public class TrainCar {
    private String name;
    private TrainCar next;

    public TrainCar(String name) {
        this.name = name;
    }

    public void setNext(TrainCar next) { this.next = next; }
    public TrainCar getNext() { return next; }
    public String getName() { return name; }
}

