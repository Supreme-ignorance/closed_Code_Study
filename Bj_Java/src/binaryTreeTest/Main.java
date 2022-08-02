package binaryTreeTest;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        Node node = new Node(3);
        Node node1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(4);
        Node node4 = new Node(2);

        bt.push(node);
        bt.push(node1);
        bt.push(node2);
        bt.push(node3);
        bt.push(node4);
        
        bt.removeLastNode();

        System.out.println("BFS로 탐색합니다");
        bt.printBFS(node);

        System.out.println("\nDFS로 탐색합니다");
        bt.printDFS(node);
    }
}