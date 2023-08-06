package org.example;

public class Elevator {
    boolean isOpen = true;
    boolean isUnderMaintenance;
    int floorNumber;
    State state = State.SECURE;

    public Elevator() {
    }

    public Elevator(boolean isOpen, boolean isUnderMaintenance, int floorNumber, State state) {
        this.isOpen = isOpen;
        this.isUnderMaintenance = isUnderMaintenance;
        this.floorNumber = floorNumber;
        this.state = state;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isUnderMaintenance() {
        return isUnderMaintenance;
    }

    public void setUnderMaintenance(boolean underMaintenance) {
        isUnderMaintenance = underMaintenance;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void move(int flag) {
        this.isOpen = false;
        if (flag < -2 || flag > 10){
            throw new IllegalArgumentException("Floor number should be between -2 and 10");
        }
        if (this.isUnderMaintenance == true && this.state == State.INSECURE){
            throw new RuntimeException("Elevator is insecure");
        }
        if (this.floorNumber == flag){
            this.isOpen = true;

        }

        this.floorNumber = flag;
    }
    public void open(){

        this.isOpen = true;

    }

    public void startMaintenance(){
        this.state = State.INSECURE;
        this.isUnderMaintenance = true;
    }

    public void finishMaintenance(){
        this.state = State.SECURE;
        this.isUnderMaintenance = false;
    }

    public void close(){
        this.isOpen = false;
    }
}
