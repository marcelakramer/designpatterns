package elevator;

import observer.Observer;
import state.ElevatorState;
import state.StoppedState;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private static Elevator instance;
    private ElevatorState state;
    private final int totalOfFloors;
    private int currentFloor = 0;
    private boolean doorOpen;
    private final List<Integer> requestQueue = new ArrayList<>();
    private final List<Integer> outUpRequestQueue = new ArrayList<>();
    private final List<Integer> outDownRequestQueue = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    private Elevator(int totalOfFloors) {
        this.state = new StoppedState(this);
        this.doorOpen = true;
        this.totalOfFloors = totalOfFloors;
    }

    public static Elevator getInstance(int totalOfFloors) {
        if (instance == null) {
            instance = new Elevator(totalOfFloors);
        }
        return instance;
    }

    public void selectFloor(int floor, boolean goingUp) {
        if (floor >= 0 && floor <= totalOfFloors && !requestQueue.contains(floor) && floor != currentFloor) {
            addRequest(floor);
            addOutRequest(floor, goingUp);
            notifyObservers();
        }
    }

    public void selectFloor(int floor) {
        if (floor >= 0 && floor <= totalOfFloors && !requestQueue.contains(floor) && floor != currentFloor) {
            addRequest(floor);
            notifyObservers();
        }
    }

    public void openDoor() {
        this.doorOpen = true;
        System.out.println("Opening door...");
    }

    public void closeDoor() {
        this.doorOpen = false;
        System.out.println("Closing door...");
    }

    public void move() {
        state.move();
    }

    public void setState(ElevatorState state) {
        this.state = state;
        notifyObservers();
    }

    private void addRequest(int floor) {
        requestQueue.add(floor);
    }

    private void addOutRequest(int floor, boolean goingUp) {
        if (goingUp) {
            outUpRequestQueue.add(floor);
        } else {
            outDownRequestQueue.add(floor);
        }
    }

    public void removeRequest(int floor) {
        requestQueue.remove(Integer.valueOf(floor));
        if (outUpRequestQueue.contains(floor)) {
            outUpRequestQueue.remove(Integer.valueOf(floor));
        }
        if (outDownRequestQueue.contains(floor)) {
            outDownRequestQueue.remove(Integer.valueOf(floor));
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        notifyObservers();
    }

    public int getTotalOfFloors() {
        return totalOfFloors;
    }

    public List<Integer> getRequestQueue() {
        return new ArrayList<>(requestQueue);
    }

    public List<Integer> getOutUpRequestQueue() {
        return outUpRequestQueue;
    }

    public List<Integer> getOutDownRequestQueue() {
        return outDownRequestQueue;
    }

    public boolean hasArrivedAtDestination() {
        return requestQueue.isEmpty();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentFloor, state.toString(), requestQueue);
        }
    }
}
