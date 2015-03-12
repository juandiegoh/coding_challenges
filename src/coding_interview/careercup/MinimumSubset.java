package coding_interview.careercup;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.careercup.com/question?id=5634050834300928
 */
public class MinimumSubset {

    public static void main(String [] args) {
        new MinimumSubset().printSubset(new int[]{2, 6, 7, 9, 1, 0, 1, 2, 3, 6});
        new MinimumSubset().printSubset(new int[]{6,6,5,5,4,4,3,3,2,2,2,1,0,7,7,7,7});
        new MinimumSubset().printSubset(new int[]{0,0,-1,-1,-9,9,-9,9,-9,9,-9,-10,9});
    }

    public void printSubset(int[] a) {
        if(a == null || a.length == 0) {
            System.out.println("The result is (,) with count = 0");
        }

        Map<Integer, Integer> values = new HashMap<Integer, Integer>();

        for(int i = 0; i < a.length; i++) {
            int key = a[i];
            values.put(key, values.containsKey(key) ? values.get(key) + 1 : 1);
            values.put(key-1, values.containsKey(key-1) ? values.get(key-1) + 1 : 1);
        }

        Integer result = null;
        Integer maxCount = 0;
        for(Integer key : values.keySet()) {
            Integer count = values.get(key);
            if(count > maxCount) {
                result = key;
                maxCount = count;
            }
        }

        if(maxCount > 0) {
            System.out.println("For " + a + " the result is (" + result + ", " + (result+1) + ") with count = " + maxCount);
        } else {
            System.out.println("The result is (,) with count = 0");
        }

    }

}
