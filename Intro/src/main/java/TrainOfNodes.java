public class TrainOfNodes {
    public static void main(String[] args) {

        // Creates 4 TrainCar objects
        TrainCar car1 = new TrainCar("Engine");
        TrainCar car2 = new TrainCar("Coal Car");
        TrainCar car3 = new TrainCar("Passenger Car");
        TrainCar car4 = new TrainCar("Caboose");

        // Links the train cars together
        car1.setNext(car2);
        car2.setNext(car3);
        car3.setNext(car4);

        System.out.println("Train cars:");
        printTrain(car1);
    }

    // Traverses from the first node and prints each car's name
    public static void printTrain(TrainCar start) {
        TrainCar current = start;

        while (current != null) {
            String car = current.getName();
            System.out.println(car);
            current = current.getNext();
        }
    }
}
