package coding_interview.careercup;

import java.util.ArrayList;
import java.util.List;

/**
 * Link all the level order nodes to makes a linked list with the first node of each level acting as the root of that linklist.
 * <p/>
 * <p/>
 * 10
 * / \
 * 6 17
 * / / \
 * 4	14 19
 * So the Linklist will be
 * 10->null
 * 6->17->null
 * 4->14->19->null
 */
public class TreeLevelOrderLinker {

    public static void main(String[] args) {
        Node ll = new Node(4, null, null);
        Node l = new Node(6, ll, null);

        Node rl = new Node(14, null, null);
        Node rr = new Node(19, null, null);
        Node r = new Node(17, rl, rr);

        Node h = new Node(10, l, r);

        System.out.println(generateLinkedList(h));
    }

    public static List<List<Integer>> generateLinkedList(Node h) {
        return doGenerateLinkedList(h, new ArrayList<List<Integer>>(), 0);
    }

    public static List<List<Integer>> doGenerateLinkedList(Node h, ArrayList<List<Integer>> levels, Integer level) {
        if (levels.size() > level) {
            List<Integer> particularLevel = levels.get(level);
            particularLevel.add(h.value);
        } else {
            List<Integer> newLevel = new ArrayList<Integer>();
            newLevel.add(h.value);
            levels.add(level, newLevel);
        }

        if (h.left != null) {
            doGenerateLinkedList(h.left, levels, level + 1);
        }

        if (h.right != null) {
            doGenerateLinkedList(h.right, levels, level + 1);
        }

        return levels;
    }
}
