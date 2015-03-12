package coding_interview.careercup;

public class Node {
    public final Integer value;
    public final Node left, right;

    public Node(Integer value, Node l, Node r) {
        this.value = value;
        this.left = l;
        this.right = r;
    }
}
