package rom.buulaen.mediator.calculator;

public class AddOperation extends MathematicalOperationAbstract implements  MathematicalOperationInterface{

    @Override
    public void calculate(double a, double b) {
        abstractResult = a + b;
    }

    @Override
    public double calculateForInterface(double a, double b) {
        return a + b;
    }
}
