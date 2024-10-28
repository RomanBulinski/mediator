package rom.buulaen.mediator.calculator;

import lombok.Data;

@Data
public class MathematicalOperationContener<T extends MathematicalOperationAbstract> {
    private T operation;

    public MathematicalOperationContener(T operation) {
        this.operation = operation;
    }

    public void executeOperation(double a, double b) {
        operation.calculate(a, b);
    }
}
