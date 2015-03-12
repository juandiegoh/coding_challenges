package coding_interview

/**
 * Created by jherenu on 7/29/14.
 */
class EvaluateReversePolishNotation {

    /**
     *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     *  Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     *
     *  Some examples:
     *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public evaluate(String arithmeticExpression) {
        def array = this.stringToArrayOfExpressions(arithmeticExpression)
        def queue = []

        array.each {
            switch (it) {
                case "+":
                    applyOperand(queue) {a,b -> a + b}
                    break
                case "-":
                    applyOperand(queue) {a,b -> a - b}
                    break
                case "*":
                    applyOperand(queue) {a,b -> a * b}
                    break
                case "/":
                    applyOperand(queue) {a,b -> a / b}
                    break
                case ~/^\d+$/: //number
                    queue.push(Integer.valueOf(it))
                    break
                default:
                    assert false, "Invalid char"
                    break
            }
        }

        return queue.pop()
    }

    private void applyOperand(queue, closure) {
        def secondValue = queue.pop()
        def firstValue = queue.pop()
        queue.push(closure(firstValue, secondValue))
    }

    def stringToArrayOfExpressions(String arithmeticExpression) {
        return arithmeticExpression.split(" ")
    }
}
