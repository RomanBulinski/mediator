package rom.buulaen.mediator.calculator;

import lombok.AllArgsConstructor;

public class CalculatorService {

    public CalculatorService() {
        MathematicalOperationContener<AddOperation> add = new MathematicalOperationContener<>(new AddOperation());
        add.executeOperation(10,5);
        double x = add.getOperation().abstractResult;

        MathematicalOperationContener<SubtractOperation> subtract = new MathematicalOperationContener<>(new SubtractOperation());
        subtract.executeOperation(10,5);
        double y = subtract.getOperation().abstractResult;

        MathematicalOperationInterface addInIterface = new AddOperation();
        System.out.println(addInIterface.calculateForInterface(10,5));
    }

}
