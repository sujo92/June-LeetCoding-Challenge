import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LargestFromEachLelel {
    static class Node
    {
        int val;
        Node left, right;
    };
    static Node newNode(int data)
    {
        Node temp = new Node();
        temp.val = data;
        temp.left = temp.right = null;
        return temp;
    }
    public static void main(String[] args) {
         /* Let us construct a Binary Tree
        4
    / \
    9 2
    / \ \
    3 5 7 */

        Node root = null;
        root = newNode(4);
        root.left = newNode(9);
        root.right = newNode(2);
        root.left.left = newNode(3);
        root.left.right = newNode(5);
        root.right.right = newNode(7);

        List<Integer> res = largestValues(root);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i)+" ");

    }
    static List<Integer> largestValues(Node root)
    {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private static void helper(List<Integer> res, Node root) {
        Deque<Node> q = new ArrayDeque();
        q.add(root);

        while(! q.isEmpty()){
            int size= q.size();
            int maxAtLevel=0;
            for(int j=0; j<size; j++) {
                Node curr = q.remove();
                maxAtLevel= Math.max(maxAtLevel, curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
            res.add(maxAtLevel);
        }
    }
}
