package coding_interview

import spock.lang.Specification

class LongestPalindromicSubstringTest extends Specification {

    LongestPalindromicSubstring longestPalindromicSubstring

    void setup() {
        this.longestPalindromicSubstring = new LongestPalindromicSubstring()
    }

    void "test longest palindromic"() {
        given:
        def expr = expression

        when:
        def result = this.longestPalindromicSubstring.getLongestPalindromic(expr)

        then:
        expectedResult == result

        where:
        expression      << ["absbd", "abracadabra", "melem"]
        expectedResult  << ["bsb"  , "ada"        , "melem"]
    }
}
