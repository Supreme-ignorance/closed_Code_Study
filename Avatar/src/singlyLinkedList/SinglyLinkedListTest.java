package singlyLinkedList;

class Node {
	public String data;
	public Node link;
	
	//생성자
	public Node (String data) {
		this.data = data;
		this.link = null;
	}
}

class SinglyLinkedList {
	private Node head;
	private int size;
	
	public SinglyLinkedList () {
		this.head = null;
		this.size = 0;
	}
	
	public Node get (int idx) {
		if (idx >= this.size || idx < 0) return null;
		Node temp = this.head;
		
		for (int i = 0; i < idx; i++) {
			temp = temp.link;
		}
		
		return temp;
	}
	
	public void addtoFirst (String data) {
		Node node = new Node(data);
		node.link = this.head;
		this.head = node;
		this.size++;
	}
	
	public void addtoLast (String data) {
		if (this.head == null) {
			addtoFirst (data);
		} else {
			Node node = new Node(data);
			Node prenode = get(this.size-1);
			prenode.link = node;
			this.size++;
		}
	}
	
	public void add(int idx, String data) {
		if (idx > this.size || idx < 0) {
			System.out.println("잘못된 접근입니다.");
			return;
		}
		if (idx == 0) addtoFirst(data);
		else if (idx == this.size) addtoLast(data);
		else {
			Node node = new Node(data);
			Node prenode = get(idx-1);
			node.link = prenode.link;
			prenode.link = node;
			size++;
		}
	}
	
	public String remove(int idx) {
		if (idx > this.size || idx < 0) {
			System.out.println("잘못된 접근입니다.");
			return null;
		}
		String data = "";
		if (idx == 0) {
			if (head == null) return null;
			else {
				data = this.head.data;
				this.head = this.head.link;
			}
		} else {
			Node prenode = get(idx-1);
			data = prenode.link.data;
			prenode.link = prenode.link.link;
		}
		return data;
	}
	
	public void printList() {
		Node temp = this.head;
		if (this.head == null) {
			System.out.println("비어있습니다.");
			return;
		}

		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.link;
		}

		System.out.println();
	}
}

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.addtoFirst("이해건");
		sll.addtoFirst("1");
		sll.addtoFirst("2");
		sll.addtoLast("3");
		sll.add(2, "4");		
		sll.printList();
		sll.remove(2);
		sll.printList();
	}
}
