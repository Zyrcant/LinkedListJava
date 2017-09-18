/*  Name of the Student: Tiffany Do
 
Class: CS 3345

Section: 001

Semester: Fall 2017

Project 02: Runs operations on a singly linked list holding IDedObjects. */

package linkedlistproject2;

import java.util.Scanner;

public class LinkedListRun {
    public static void main(String[] args)
    {
        //input validation
        int input = 0;
        LinkedListIDedObjects list = new LinkedListIDedObjects();
        
        do{
            boolean validInput = false;
            //user is prompted until they give a valid prompt
            while(!validInput)
            {
                //prompt the user to select an option
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Operations on List\n  1. Make Empty\n  2. Find ID\n  3. Insert At Front\n  4. Delete From Front\n  5. Delete ID\n  6. Print All Records\n  7. Done");
                    System.out.print("    Your choice: ");
                    input = sc.nextInt();
                    //validates that the input is within bounds of operations
                    if(input < 1 || input > 7)
                        System.out.println("ERROR: Invalid operation. Please select an integer from 1-7.\n");
                    else
                        validInput = true;
                }
                catch(Exception e){
                    System.out.println("ERROR: You did not select an integer. Please select an integer.\n");
                }
            }
            //input is now validated
            Scanner sc = new Scanner(System.in);

            //operations on list
            switch(input){
                //empties list
                case 1: 
                    list.makeEmpty();
                    System.out.println("    List emptied.\n");
                    break;
                //asks user for ID input, and then searches for ID in list
                case 2: 
                    System.out.print("    ID No: ");
                    int ID;
                    try{
                        ID = sc.nextInt();
                        if(list.findID(ID) == null)
                            System.out.println("    ID not found.\n");
                        else
                        {
                            list.findID(ID).printID();
                            System.out.println(); //adds a new line for cleaner formatting
                        }
                    }
                    catch(Exception e) {
                        System.out.println("    This is not a valid ID number.\n");
                    }
                    break;
                //add new entry at front, asks user for inputs
                case 3:
                    int newID; 
                    String newName; 
                    String newPublisher;
                    try{
                        //asks for fields to create the magazine entry
                        System.out.print("    Enter Magazine ID: ");
                        newID = sc.nextInt();
                        sc.nextLine();
                        System.out.print("    Enter Magazine Name: ");
                        newName = sc.nextLine();
                        System.out.print("    Enter Publisher Name: ");
                        newPublisher = sc.nextLine();
                        Magazine m = new Magazine(newID, newName, newPublisher);
 
                        //tells user if they've added a duplicate ID, if not adds the ID
                        System.out.println(list.insertAtFront(m) == false ? "    ...\n    ID already exists.\n" :    "    ...\n    Magazine added.\n");
                    }
                    catch(Exception e){
                        System.out.println("    Please enter a valid numerical ID for the object.\n");
                    }
                    break;
                //deletes first item, displays error if the list is empty
                case 4:
                    if(list.isEmpty())
                        System.out.println("    ERROR: Cannot delete from an empty list.\n");
                    else
                    {
                        list.deleteFromFront().printID();
                        System.out.println("    First item deleted.\n");
                    }
                    break;
                //asks user for input and deletes the item with matching ID
                case 5:
                    System.out.print("    Enter ID to be deleted: ");
                    int deleteID;
                    try{
                        deleteID = sc.nextInt();
                        if(list.findID(deleteID) == null)
                            System.out.println("    Item does not exist in the list.\n");
                        else
                        {
                            list.delete(deleteID).printID();
                            System.out.println("    Item has been deleted.\n");
                        }
                    }
                    catch (Exception e){
                        System.out.println("    Please enter a valid numerical ID for the obejct.\n");
                    }
                    break;
                //prints the entire list of records. Added lines for cleaner formatting
                case 6:
                    System.out.println();
                    System.out.println("-------------------------------");
                    list.printAllRecords();
                    System.out.println("-------------------------------");
                    System.out.println("Printed all records.\n");
                    break;
                case 7:
                    System.out.println("    Done.");
                    break;
            }
        } while(input != 7); //continues until the user selects 7, which is done
        
    }
}
