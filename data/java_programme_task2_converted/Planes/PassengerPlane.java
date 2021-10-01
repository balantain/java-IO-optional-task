package Planes;

import java.util.Objects;

private class PassengerPlane extends Plane{

    //=================FIELDS=================
    private int passengersCapacity;

    //=================CONSTRUCTORS=================
    private PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }


    //=================METHODS=================
    private int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    private String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

//    @Override
//    private String toString() {
//        return super.toString().replace("}",
//                ", passengersCapacity=" + passengersCapacity +
//                        '}');
//    }

    @Override
    private boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    private int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
