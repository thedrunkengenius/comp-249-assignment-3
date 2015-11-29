import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CellList implements Cloneable {
    //Beginning of CellNode inner class
    private class CellNode {
        private CellPhone cellPhone;
        private CellNode next;

        private CellNode() {
            cellPhone = null;
            next = null;
        }
        private CellNode(CellPhone cellPhone, CellNode nodeReference) {
            this.cellPhone = cellPhone;
            this.next = nodeReference;
        }
        private CellNode(CellNode cellNode) {
            this.cellPhone = cellNode.cellPhone;
            this.next = cellNode.next;
        }
        private CellPhone getCellPhone() {
            return cellPhone;
        }

        private void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }
        private CellNode getNode() {
            return this.next;
        }
        private void setNode(CellNode node) {
            this.next = node;
        }

    }//End of Node inner class

    //Beginning of Iterator2 inner class
    //Iterator allows for more granular and organized navigation through the Linked List
    private class Iterator2 {
        private CellNode position;
        private CellNode previous;

        public Iterator2() {
            position = head;
            previous = null;
        }
        public void restart() {
            position = head;
            previous = null;
        }
        public CellPhone next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            CellPhone toReturn = position.cellPhone;
            previous = position;
            position = position.next;
            return toReturn;
        }

        public boolean hasNext() {
            return (position != null);
        }
        public CellPhone peek() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            return position.cellPhone;
        }
    }//End of Iterator inner class

    //Beginning of CellList outer class

    private CellNode head; //Link to first node of list
    private int size; //Number of elements in list

    //CellList default constructor
    public CellList() {
        head = null;
        size = 0;
    }

    //CellList copy constructor
    public CellList(CellList cellList) {
        if (cellList == null) {
            throw new NullPointerException();
        }
        if (cellList.head == null) {
            head = null;
        }
        else {
            head = copyList(cellList.head);
        }
    }

    //Add cellPhone to beginning of list
    public void addToStart(CellPhone cellPhone) {
        head = new CellNode(cellPhone, head);
        //increment size of list
        size++;
    }

    //Insert cellPhone at specified index
    public void insertAtIndex(CellPhone cellPhone, int index) {
        if (index < 0 || index > (this.size() - 1)) {
            throw new NoSuchElementException();
        }
        //increment size of list
        size++;
    }

    //Delete cellPhone from specified index
    public void deleteFromIndex(int index) {
        int counter = 0;
        if (index < 0 || index > (this.size() - 1)) {
            throw new NoSuchElementException("No such element.");
        }
        //trivial, use deleteFromStart() method
        if (index == 0) {
            deleteFromStart();
        }
        //if head==null, list is empty so no elements to delete
        else if (head == null) {
            System.out.println("List is empty, nothing to delete.");
        }
        //Actual case
        else {
            Iterator2 i = new Iterator2();
            while (counter < (index)) {
                counter++;
                i.next();
            }
            //Sets link from "previous" element to the one following the index
            //Remove references from deleted object
            //Garbage collector takes it away
            i.previous.next = i.position.next;
            i.position = i.position.next;
            }
        //Decrement size of list
        size--;

    }
    public void replaceAtIndex(CellPhone cp, int index) {
        int counter = 0;
        if (index < 0 || index > (this.size() - 1)) {
            throw new NoSuchElementException("No such element.");
        }
        Iterator2 i = new Iterator2();
        if (index == 0) {
            head = new CellNode(cp, i.position.next);
        }
        else {
            while (counter < index) {
                counter++;
                i.next();
            }
            i.previous.cellPhone = cp;
            i.previous.next = i.position.next;
        }
    }
    public boolean deleteFromStart() {
        if (head != null) {
            head = head.next;
            size--;
            return true;
        }
        else {
            return false;
        }

    }
    public int size() {
        int counter = 0;
        CellNode temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }
    public boolean contains(CellPhone cellPhone) {
        if (find(cellPhone) != null) {
            return true;
        }
        else {
            return false;
        }
    }
    public void showContents () {
        CellNode temp = head;
        if (temp == null) {
            System.out.println("This list is empty. Nothing to display.");
        }
        else {
            System.out.println("Here are the contents of the list: ");
            while (temp != null) {
                System.out.println("[" + temp.cellPhone + "] ---> ");
                temp = temp.next;
            }
            System.out.println("X");
        }
    }
    private CellNode find(CellPhone cellPhone) {
        CellNode temp = head;
        while (temp != null) {
            if (temp.cellPhone.equals(cellPhone)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    private CellNode copyList(CellNode cn) {
        CellNode temp = cn;
        CellNode newHead = null;
        CellNode end = null;
        newHead = new CellNode(temp.cellPhone.clone(), null);

        end = newHead;
        temp = temp.next;

        while (temp != null) {
            end.next = new CellNode(temp.cellPhone.clone(), null);
            end = end.next;
            temp = temp.next;
        }
        return newHead;
    }
    @Override public CellList clone() {
        try {
            CellList newCL = (CellList)super.clone();
            if (head == null) {
                newCL.head = null;
            }
            else {
                newCL.head = copyList(head);
            }
            return newCL;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
    @Override public boolean equals(Object cl) {
        if (cl == null) {
            return false;
        }
        else if (getClass() != cl.getClass()) {
            return false;
        }
        else {
            CellList otherList = (CellList)cl;
            if (size() != otherList.size()) {
                return false;
            }
            CellNode position = head;
            CellNode otherPosition = otherList.head;
            while (position != null) {
                if ((!(position.cellPhone.equals(otherPosition.cellPhone)))) {
                    return false;
                }
                position = position.next;
                otherPosition = otherPosition.next;
            }
            return true;
        }
    }
}
