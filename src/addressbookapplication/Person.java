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

import java.util.Comparator;
import java.io.Serializable;

public class Person implements Serializable{
    private String firstName;
    private String lastName;
    private String Address;
    private String City;
    private String state;
    private String zip;
    private String Phone;
/**Constructor
 *  
 * 
 * @param firstName - the person's first name
 * @param lastName - the person's last name
 * @param Address - the person's address
 * @param City - the person's address
 * @param state - the person's state
 * @param zip - the person's zip
 * @param Phone - the person's phone
 */
    public Person(String firstName, String lastName, String Address, String City, String state, String zip, String Phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = Address;
        this.City = City;
        this.state = state;
        this.zip = zip;
        this.Phone = Phone;
    }
    
    

/**
 * Accessor for the person's address
 * 
 * @return  the person's first
 */

    public String getAddress() {
        return Address;
    }
/**
 * Getter for the person's address
 * 
 * @param Address 
 */
    public void setAddress(String Address) {
        this.Address = Address;
    }
    /**
     * Accessor for the person's city
     * @return  the person's city
     */

    public String getCity() {
        return City;
    }
/**
 * Setter of person's city
 * @param City the person's city
 */
    public void setCity(String City) {
        this.City = City;
    }
/**
 * Accessor for person's first name
 * 
 * @return the person's first name 
 */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    // The following comparators should go inside class Person:	


	/** Comparator for comparing two persons by alphabetical order of name
	 */
	static class CompareByName implements Comparator
	{
		/** Compare two objects (which must both be Persons) by last name,
		 *	with ties broken by first name
		 *
		 *	@param person1 the first object
		 *	@param person2 the second object
		 *	@return a negative number if person1 belongs before person2 in
		 *			alphabetical order of name; 0 if they are equal; a
		 *			positive number if person1 belongs after person2
		 *
		 *	@exception ClassCastException if either parameter is not a
		 *			   Person object
		 */
		public int compare(Object person1, Object person2)
		{
			int compareByLast = ((Person) person1).getLastName().compareTo(
				((Person) person2).getLastName());
			if (compareByLast != 0)
				return compareByLast;
			else
				return ((Person) person1).getFirstName().compareTo(
					((Person) person2).getFirstName());
		}
		
		/** Compare two objects (which must both be Persons) by name
		 *
		 *	@param person1 the first object
		 *	@param person2 the second object
		 *	@return true if they have the same name, false if they do not
		 *
		 *	@exception ClassCastException if either parameter is not a
		 *			   Person object
		 */
		public boolean equals(Object person1, Object person2)
		{
			return compare(person1, person2) == 0;
		}
	}
	
	/** Comparator for comparing two persons by order of zip code
	 */
	static class CompareByZip implements Comparator
	{
		/** Compare two objects (which must both be Persons) by zip
		 *
		 *	@param person1 the first object
		 *	@param person2 the second object
		 *	@return a negative number if person1 belongs before person2 in
		 *			order of zip; 0 if they are equal; a positive number if
		 *		    person1 belongs after person2
		 *
		 *	@exception ClassCastException if either parameter is not a
		 *			   Person object
		 */
		public int compare(Object person1, Object person2)
		{
			int compareByZip = ((Person) person1).getZip().compareTo(
				((Person) person2).getZip());
			if (compareByZip != 0)
				return compareByZip;
			else
				return new CompareByName().compare(person1, person2); 
		}
		
		/** Compare two objects (which must both be Persons) by zip
		 *
		 *	@param person1 the first object
		 *	@param person2 the second object
		 *	@return true if they have the same zip, false if they do not
		 *
		 *	@exception ClassCastException if either parameter is not a
		 *			   Person object
		 */
		public boolean equals(Object person1, Object person2)
		{
			return compare(person1, person2) == 0;
		}
	}

	
	
	  


    
    
}
