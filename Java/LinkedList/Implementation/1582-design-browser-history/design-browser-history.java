class Node{
    String data;
    Node next;
    Node prev;

    public Node(String data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(String data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class BrowserHistory {
    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);

        current.next = null;

        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }
    
    public String back(int steps) {
        while (steps != 0) {
           if(current.prev != null){
                current = current.prev;
                steps--;
           }else{
                break;
           }
        }
        return current.data;
    }
    
    public String forward(int steps) {
        while (steps != 0) {
            if(current.next != null){
                current = current.next;
                steps--;
            }else{
                break;
            }
        }
        return current.data; 
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */