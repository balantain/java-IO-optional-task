package Planes;

import models.MilitaryType;

import java.util.Objects;

private class MilitaryPlane extends Plane{

    private MilitaryType type;

    private MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    private MilitaryType getType() {
        return type;
    }

    @Override
    private String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                '}');
    }

    @Override
    private boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return type == that.type;
    }

    @Override
    private int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
