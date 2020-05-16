import java.util.LinkedList;

public class BinarySearchTree {
    Node root;

    public static void visit(Node node) {
        if (node != null) {
            System.out.println(node.info);
        }
    }

    public static Node searchRecursion(Node node, int key) {
        if (node != null) {
            if (node.info == key) return node;
            else if (key < node.info) return searchRecursion(node.left, key);
            else return searchRecursion(node.right, key);
        }

        return node;
    }


    public void insert(int info) {
        if (root == null) {
            root = new Node(info);
        } else {
            Node prev = null;
            Node temp = root;
            while (temp != null) {
                prev = temp;
                if (info < temp.info) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }

            if (info < prev.info) {
                prev.left = new Node(info);
            } else {
                prev.right = new Node(info);
            }
        }
    }

    public Node deleteByMerging(int key) {
        // Check if the tree is empty
        if (root == null) {
            return null;
        } else {
            Node nodeForPrevToPointTo = null;

            // search for a deleted node
            Node prev = null;
            Node deletedNode = root;

            while (deletedNode != null) {
                prev = deletedNode;
                if (key == deletedNode.info) {
                    break;
                } else if (key < deletedNode.info && deletedNode.left != null) {
                    deletedNode = deletedNode.left;
                } else if (key > deletedNode.info && deletedNode.right != null) {
                    deletedNode = deletedNode.right;
                } else {
                    return null;
                }
            }

            // If deleted has left subtree
            if (deletedNode.left != null) {
                // Start merging

                // Search for rightmost node of the left subtree
                Node rightMost = deletedNode.left;

                while (rightMost.right != null) rightMost = rightMost.right;

                // Point the right of the rightmost to the right of deleted node
                rightMost.right = deletedNode.right;

                nodeForPrevToPointTo = deletedNode.left;
            } else {
                nodeForPrevToPointTo = deletedNode.right;
            }

            // Check if the deletedNode is root
            if (deletedNode == root) {
                root = nodeForPrevToPointTo;
            } else if (prev.left == deletedNode) {
                prev.left = nodeForPrevToPointTo;
            } else {
                prev.right = nodeForPrevToPointTo;
            }

            return deletedNode;
        }
    }

    //TODO: Fix deleteByCopying
    public Node deleteByCopying(int key) {
        // Check if the tree is empty
        if (root == null) {
            return null;
        } else {
            Node nodeForPrevToPointTo = null;

            // search for a deleted node
            Node parentOfDeletedNode = null;
            Node deletedNode = root;

            while (deletedNode != null) {
                parentOfDeletedNode = deletedNode;
                if (key == deletedNode.info) {
                    break;
                } else if (key < deletedNode.info && deletedNode.left != null) {
                    deletedNode = deletedNode.left;
                } else if (key > deletedNode.info && deletedNode.right != null) {
                    deletedNode = deletedNode.right;
                } else {
                    return null;
                }
            }

            // If deleted has left subtree
            if (deletedNode.left != null) {
                // Start copying

                // Search for rightmost node of the left subtree
                Node rightMost = deletedNode.left;
                Node parentOfRightMost = rightMost;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right;
                }

                nodeForPrevToPointTo = rightMost;
                parentOfRightMost.right = rightMost.left;
                rightMost.left = parentOfRightMost;
                rightMost.right = deletedNode.right;
            } else {
                nodeForPrevToPointTo = deletedNode.right;
            }

            // Check if the deletedNode is root
            if (deletedNode == root) {
                root = nodeForPrevToPointTo;
            } else if (parentOfDeletedNode.left == deletedNode) {
                parentOfDeletedNode.left = nodeForPrevToPointTo;
            } else {
                parentOfDeletedNode.right = nodeForPrevToPointTo;
            }

            return deletedNode;
        }
    }

    public Node search(int key) {
        Node temp = root;

        while (temp != null) {
            if (temp.info == key) {
                break;
            } else if (temp.left != null && key < temp.info) {
                temp = temp.left;
            } else if (temp.right != null && key >= temp.info) {
                temp = temp.right;
            } else {
                temp = null;
            }
        }
        return temp;
    }

    public void breathFirst() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            visit(temp);

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void preorder() {
        preorderRecursion(root);
    }

    private void preorderRecursion(Node node) {
        if (node != null) {
            visit(node);
            preorderRecursion(node.left);
            preorderRecursion(node.right);
        }
    }

    public void inorder() {
        inorderRecursion(root);
    }

    private void inorderRecursion(Node node) {
        if (node != null) {
            inorderRecursion(node.left);
            visit(node);
            inorderRecursion(node.right);
        }
    }

    public void postorder() {
        postorderRecursion(root);
    }

    private void postorderRecursion(Node node) {
        if (node != null) {
            postorderRecursion(node.left);
            postorderRecursion(node.right);
            visit(node);
        }
    }

    //TODO: Implement preorder/inorder/postorder Iterative version
    public void preorderIterative() {}
    public void inorderIterative() {}
    public void postorderIterative() {}

    public int height() {
        return heigthRecursion(root);
    }

    public int heigthRecursion(Node node) {
        if (node != null) {
            return Math.max(heigthRecursion(node.left), heigthRecursion(node.right)) + 1;
        }
        return 0;
    }
}
