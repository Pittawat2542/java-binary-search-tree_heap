public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(100);
        binarySearchTree.insert(50);
        binarySearchTree.insert(200);
        binarySearchTree.insert(25);
        binarySearchTree.insert(150);
        binarySearchTree.insert(80);
        binarySearchTree.insert(300);

        BinarySearchTree.visit(binarySearchTree.search(50));
        BinarySearchTree.visit(binarySearchTree.search(120));
        System.out.println("------------------------------------");

        BinarySearchTree.visit(BinarySearchTree.searchRecursion(binarySearchTree.root, 25));
        BinarySearchTree.visit(BinarySearchTree.searchRecursion(binarySearchTree.root, 120));
        System.out.println("------------------------------------");

        binarySearchTree.preorder();
        System.out.println("------------------------------------");
        binarySearchTree.inorder();
        System.out.println("------------------------------------");
        binarySearchTree.postorder();

        System.out.println("------------------------------------");
        binarySearchTree.breathFirst();

        System.out.println("------------------------------------");
        binarySearchTree.deleteByMerging(100);
        binarySearchTree.breathFirst();

        binarySearchTree.insert(80);
        binarySearchTree.insert(75);
        binarySearchTree.insert(60);

        System.out.println("------------------------------------");
        binarySearchTree.deleteByCopying(80);
        binarySearchTree.breathFirst();
    }
}
