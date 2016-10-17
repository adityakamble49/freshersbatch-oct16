public class DoublyLinkList {
    public static void main(String args[]){

        NodeManager nm = new NodeManager();
        nm.addNode(10);
        nm.addNode(20);
        nm.addNode(30);
        nm.addNode(40);
        nm.printNodes();
        nm.deleteNode(30);
        nm.printNodes();
        System.out.println(nm.countNode());
    }
}

class Node{
   int number;
   Node next;
   Node prev;

   public Node(int number){
       this.number = number;
   }
}

class NodeManager{

    Node firstNode;
    Node currentNode;
    Node newNode;

    public void addNode(int number){

        if(firstNode == null){
            newNode = new Node(number);
            newNode.next = null;
            newNode.prev = null;
            firstNode = newNode;
            currentNode = firstNode;
        }else{
            newNode = new Node(number);
            newNode.prev = currentNode;
            newNode.next = null;
            currentNode.next = newNode;
            currentNode = newNode;
        }
    }

    public void deleteNode(int number){
        Node node;
        node = firstNode;

        while(node!=null){
            if(node.number==number){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                break;
            }
            node = node.next;
        }
    }

    public void printNodes(){

        Node node;
        node = firstNode;

        System.out.print("Nodes : ");
        while(node!=null){
            System.out.print(node.number + " ");
            node = node.next;
        }
        System.out.println();
    }

    public int countNode(){

        int nodeCounter = 0;
        Node node;
        node = firstNode;

        while(node!=null){
            nodeCounter++;
            node = node.next;
        }

        return nodeCounter;
    }
}
