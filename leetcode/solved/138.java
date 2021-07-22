class Solution {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		HashMap<Node, Node> map = new HashMap<>();
		Node temp = head;
		Node newRoot = new Node(temp.val);
		Node pre = newRoot;
		map.put(temp, pre);
		temp = temp.next;
		while (temp != null) {
			Node next = new Node(temp.val);
			map.put(temp, next);
			pre.next = next;
			pre = next;
			temp = temp.next;
		}

		temp = head;
		pre = newRoot;
		while (temp != null) {
			pre.random = map.get(temp.random);
			temp=temp.next;
			pre=pre.next;
		}
		return newRoot;
	}
}
