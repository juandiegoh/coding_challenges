package coding_interview

import spock.lang.Specification

class EvaluateReversePolishNotationTest extends Specification {

    EvaluateReversePolishNotation evaluateReversePolishNotation

    void setup() {
        this.evaluateReversePolishNotation = new EvaluateReversePolishNotation()
    }

    void "string to array of expressions"() {
        given:
        def expr = "1 2 + 20 *"

        when:
        def array = this.evaluateReversePolishNotation.stringToArrayOfExpressions(expr)

        then:
        ["1", "2", "+", "20", "*"] == array
    }

    void "given the sum polish notation expression #expression give the result #expectedResult"() {
        given:
        def expr = expression

        when:
        def result = this.evaluateReversePolishNotation.evaluate(expr)

        then:
        expectedResult == result

        where:
        expression << ["1 2 +", "2 1 + 3 *", "4 13 5 / +", "1 2 + 4 * 5 + 3 -"]
        expectedResult << [3, 9, 6.6, 14]
    }
}
