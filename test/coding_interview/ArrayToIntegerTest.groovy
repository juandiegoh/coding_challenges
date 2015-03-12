package coding_interview

import spock.lang.Specification
import spock.lang.Unroll

class ArrayToIntegerTest extends Specification {

    ArrayToInteger arrayToInteger

    void setup() {
        this.arrayToInteger = new ArrayToInteger()
    }

    @Unroll
    void "given #array it must return the number #expectedResult"() {
        given:
        def input = array

        when:
        def result = this.arrayToInteger.atoi(input)

        then:
        expectedResult == result

        where:
        array   | expectedResult
        "1"     | 1
        null    | null
        "1"     | 1
        "-1"    | -1
        "142"   | 142
        "-142"  | -142
        "+142"  | 142
        "10923" | 10923
    }
}
