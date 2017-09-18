/*  Name of the Student: Tiffany Do
 
Class: CS 3345

Section: 001

Semester: Fall 2017

Project 02: Magazine object that implements IDed Object. Has a numeric ID, name, and publisher. */

package linkedlistproject2;


public class Magazine implements IDedObject{
    //data in the class
    private int magazineID;
    private String magazineName;
    private String publisherName;
    
    //default constructor, throws an error if required fields are not provided
    Magazine()
    {
        throw new java.lang.Error("ERROR: Invalid magazine properties");
    }
    
    //constructor given ID, name, and publisher
    Magazine(int ID, String name, String publisher)
    {
        magazineID = ID;
        magazineName = name;
        publisherName = publisher;
    }
    
    //accesspr methods
    public int getID()
    {
        return magazineID;
    }
    
    //prints information of the Magazine, formatting with spaces is according to the sample output from Dr.Chida
    public void printID()
    {
        System.out.println("    " + magazineID + "\n    " + magazineName + "\n    " + publisherName);
    }
}
