/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbookapplication;

/**
 *
 * @author tonyw_000
 */
import addressbookapplication.Person.CompareByName;
import addressbookapplication.Person.CompareByZip;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
/**
 * An object of this class maintains the 
 * collection of Person objects that 
 * constitute an address book 
 * 
 */
public class AddressBook extends Observable implements Serializable{
    
    List<Person> persons=new ArrayList<Person>();
    File file;
    String title;
    Boolean changedSinceLastSave=false;
/**
 * Get the title of this address book - based on the most recently used file
 * 
 * @return the title of this address book - "Untitled" if none
 */
    public String getTitle() {
        return title;
    }
/**
 * Get the File this address book was most recently read from or saved to 
 * @return file - the file just used to read or save this object
 */
    public File getFile() {
        return file;
    }
/**file - the file just used to read or save this object
 * 
 * 
 * @param file - the file just used to read or save this object
 */
    public void setFile(File file) {
        this.file = file;
    }
   /**
    * 
    * Find out whether this address book has been changed since last open / save 
    * @return true if this address book has been changed since the last open / save; false if not
    */
    public Boolean getChangedSinceLastSave() {
        return changedSinceLastSave;
    }

    public void setChangedSinceLastSave(Boolean changedSinceLastSave) {
        this.changedSinceLastSave = changedSinceLastSave;
        notifyObservers();
    }
    
    /**Constructor - create a new, empty address book
     * 
     * 
     */
    public AddressBook() {
    }
    /**Add a new Person to the collection
     * 
     * 
     * @param firstName - the person's first name
     * @param lastName - the person's last name
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param phone 
     */
    public void addPerson(String firstName,String lastName,String address,
            String city, String state, String zip, String phone) {
        Person person=new Person(firstName,lastName,address,city,state,zip,phone);
        persons.add(person);
        setChangedSinceLastSave(true);
        
    }
    
    public void addPerson(String[] personInfo){
        if (personInfo.length==7)
        addPerson(personInfo[0],personInfo[1],personInfo[2],personInfo[3],personInfo[4],
                personInfo[5],personInfo[6]);
        
    }
    /**
     * Provide the full name of a person
     * @param index - the position of the desired person
     * @return the person's full name, in a form for displaying or printing
     */
    public String getFullNameOfPerson(int index){
        
        Person person=persons.get(index);
        String fullNam=person.getFirstName()+"  "+ person.getLastName();
        return fullNam;
    }
    
    /**rovide the rest of the current information about a person
     * 
     * @param index - the position of the desired person 
     * @return an array of Strings, each containing one piece of stored 
     * information about this person. The person's name is _not_ included, 
     * since this is not changeable.
     */
    public String[] getOtherPersonInformation(int index){
        Person person=persons.get(index);
        String[] otherPersonInfo=new String[5];
        otherPersonInfo[0]=person.getAddress();
        otherPersonInfo[1]=person.getCity();
        otherPersonInfo[2]=person.getState();
        otherPersonInfo[3]=person.getZip();
        otherPersonInfo[4]=person.getPhone();
        return otherPersonInfo;
        
    }
    
    public void updatePerson(int index,String[] otherPersonInfoInput){
        Person person=persons.get(index);
        if (otherPersonInfoInput.length==5){
            person.setAddress(otherPersonInfoInput[0]);
            person.setCity(otherPersonInfoInput[1]);
            person.setState(otherPersonInfoInput[2]);
            person.setZip(otherPersonInfoInput[3]);
            person.setPhone(otherPersonInfoInput[4]);
            setChangedSinceLastSave(true);
        }
    }
    
    public void removePerson(int index){
        persons.remove(index);
        setChangedSinceLastSave(true);
        
    }
    
    public void sortByName(){
        Collections.sort(persons, new CompareByName());
        setChangedSinceLastSave(true);
    }
    public void sortByZip(){
        Collections.sort(persons, new CompareByZip());
        setChangedSinceLastSave(true);
    }
    
    public void printAll(){
        
    }

    public int getNumberOfPersons() {
        return persons.size();
        
        
    }
    
    
}
