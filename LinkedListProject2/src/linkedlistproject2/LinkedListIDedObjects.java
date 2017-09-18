/*  Name of the Student: Tiffany Do
 
Class: CS 3345

Section: 001

Semester: Fall 2017

Project 02: Linked List to hold IDed Objects. Has basic functions to add and delete. Does not implement iterable. */

package linkedlistproject2;

/**
 *
 * @param <AnyType>
 */
public class LinkedListIDedObjects<AnyType extends IDedObject> {
    //class data
    private int listSize = 0;
    //beginning and end nodes are stored
    private Node<AnyType> head;
    private Node<AnyType> tail;
    
    //nested class Node
    private static class Node<AnyType>
    {
        public AnyType data;
        public Node<AnyType> next;
        public Node(AnyType d, Node<AnyType> n)
        {
            data = d;
            next = n;
        }
    }
    //required methods
    
    //default constructor, creates an empty list
    public LinkedListIDedObjects()
    {
        makeEmpty();
    }
    
    //creates an empty list
    public void makeEmpty()
    {
        //makes head and tail null
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        
        //head next is null
        head.next = tail;
        listSize = 0;
    }
    
    //finds the object that matches the ID
    public AnyType findID(int ID)
    {
        //return null if list is empty
        if(isEmpty())
            return null;
        else //loops through list and checks the data of each node
        {
            //start at first element, which is after head
            Node<AnyType> current;
            current = head.next;
            //stops looping if tail is reached
            while(current != tail)
            {
                //checks the data ID
                if(current.data.getID() == ID)
                    return current.data;
                current = current.next;
            }
        }
        return null;
    }
    
    //inserts object at front of list
    public boolean insertAtFront(AnyType x)
    {
        //if the ID already exists, do not add it again and return false
        if(findID(x.getID()) != null)
            return false;
        else
        {
            //creates a new node to add to the list
            Node<AnyType> newNode = new Node<>(x, null);
            //links the previous first item to the new node
            newNode.next = head.next;
            //links head to the new node
            head.next = newNode;
            listSize++;
            return true;
        }
    }
    
    //deletes the first object
    public AnyType deleteFromFront()
    {
        //checks to see if the list is empty
        if(isEmpty())
            return null;
        else
        {
            //creates a variable to hold the data that is being deleted
            AnyType deleted;
            deleted = head.next.data;
            //links head to node after deleted node
            head.next = head.next.next;
            listSize--;
            return deleted;
        }
    }
    
    //deletes object corresponding to ID
    public AnyType delete(int ID)
    {
        //checks to see if it is empty
         if(isEmpty())
            return null;
         else
         {
            //creates a new AnyType for the deleted data and a node to traverse the list
            AnyType deleted;
            Node<AnyType> current;
            current = head;
            while(current != tail)
            {
                //checks to see if the next node matches the ID
                if(current.next.data.getID() == ID)
                {
                    //stores the next node's data and links the current to 2 ahead
                    deleted = current.next.data;
                    current.next = current.next.next;
                    listSize--;
                    return deleted;
                }
                current = current.next;
            }
         }
         return null;
    }
    
    //prints all records in the list
    public void printAllRecords()
    {
        //start at head
        Node<AnyType> current;
        current = head.next;
        while(current != tail)
        {
            current.data.printID();
            System.out.println(); //newline for cleaner formatting
            current = current.next;
        }
        
    }
    
    //extra methods
    
    //checks to see if the list is empty
    public boolean isEmpty()
    {
        return listSize == 0;
    }
}
