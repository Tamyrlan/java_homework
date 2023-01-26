package oop_7.CalkJava;

public class Presenter {
    View view;
    Model model;

    public Presenter(Model m) {
        model = m;
    }

    public Presenter() {
        super();
    }

    public Presenter(View v) {
        view = v;
    }

    public void buttonStart() {
        int num = view.menuCalc();
        if (num == 0) {
            System.exit(0);
        } else {
            model = new OperModel();
            buttonClick(num);
        }
    }

    public void buttonClick(int num) {
        double a = view.getValue("Enter first number: ");
        double b = view.getValue("Enter second number: ");
        model.setX(a);
        model.setY(b);
        double result;
        if (num == 1) {
            result = model.sumResult();
            view.print(result, "Addition result: ");
        } else if (num == 2) {
            result = model.subResult();
            view.print(result, "Substract result: ");
        } else if (num == 3) {
            result = model.multResult();
            view.print(result, "Multiplication result: ");
        } else if (num == 4) {
            result = model.divResult();
            view.print(result, "Division result: ");
        }
    }
}
