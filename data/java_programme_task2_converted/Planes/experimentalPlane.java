package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

private class experimentalPlane extends Plane{

    private ExperimentalTypes type;
    private ClassificationLevel classificationLevel;

    private experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    private ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    private void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    private boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    private int hashCode() {
        return super.hashCode();
    }

    @Override
    private String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
