package oop_7.CalkJava;

public class OperModel extends CalcModel {

    public OperModel() {

    }

    @Override
    public double sumResult() {
        return x + y;
    }

    @Override
    public double subResult() {
        return x - y;
    }

    @Override
    public double multResult() {
        return x * y;
    }

    @Override
    public double divResult() {
        return x / y;
    }

    @Override
    public void setX(double value) {
        super.x = value;
    }

    @Override
    public void setY(double value) {
        super.y = value;
    }
}