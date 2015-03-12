package coding_interview

class ArrayToInteger {

    def positive = { it -> it }
    def negative = { it -> -it }

    def signMap = [
            '+' : positive,
            '-' : negative
    ]

    def numberMap = [
            "0" : 0,
            "1" : 1,
            "2" : 2,
            "3" : 3,
            "4" : 4,
            "5" : 5,
            "6" : 6,
            "7" : 7,
            "8" : 8,
            "9" : 9
    ]

    def atoi(String str, base = 10) {
        if(str == null || str.isEmpty() || !(str ==~ /^[+-]?\d+$/) ) {
            return null
        }

        def sign = positive

        def newSign = signMap.get(str.substring(0,1))
        if (newSign) {
            sign = newSign
            str = str.substring(1)
        }


        def pos = str.length() - 1
        def result = str.inject(0) { acc, val ->
            acc = acc + (numberMap.get(val) * (base**pos))
            pos--
            return acc
        }

        return sign(result)
    }
}
