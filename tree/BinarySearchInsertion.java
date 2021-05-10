public class BinarySearchInsertion {

    public static Node insert(Node root, int data) {
        Node toInsert = new Node(data);

        if(root == null){
            return toInsert;
        }
        Node node = root;
        Node prev = null;
        while (node != null) {
            prev = node;
            if (node.data < data)
                node = node.right;
            else
                node = node.left;
        }
        if (prev.data < data)
            prev.right = toInsert;
        else
            prev.left = toInsert;
        return root;
    }

}
