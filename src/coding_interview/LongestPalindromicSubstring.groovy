package coding_interview

class LongestPalindromicSubstring {

    def getLongestPalindromic(String str) {
        if(str == null || str.isEmpty()) {
            return ""
        }

        def longestPalindromic = ""
        for(int i = 0; i < str.length(); i++) {
            def maxLength = str.length() - i
            if(maxLength <= longestPalindromic.length()) {
                return longestPalindromic
            }
            for(int j = i + 1; j < str.length(); j++) {
                def substring = str.substring(i, j + 1)
                if(isPalindromic(substring)) {
                    longestPalindromic = substring
                }
            }
        }
        return longestPalindromic
    }

    def isPalindromic(String str) {
        return str.length() > 1 && str == str.reverse()
    }

    def reverse(String str) {
        def result = []
        str.each {
            result.push(it)
        }
        return result
    }

    def reverseWithQueue(String str) {
        def queue = new LinkedList<String>()
        str.each { queue.add(it) }
        return queue
    }
}
