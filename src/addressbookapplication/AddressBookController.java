/**
 * 
 * 
 */

package addressbookapplication;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *An object of this class performs operations on the address 
 * book in response to user gestures on the GUI 
 * @author tonyw_000
 */
public class AddressBookController{

    FileSystem fileSystem;
    AddressBookGUI gui;
    AddressBook addressBook;
    String[] personInfo={"firstName","lastName","address","city","state",
        "zip","phone"};
    String[] personInfoInput=new String[7];
    String[] otherPersonInfoInput=new String[5];
    
    /**
 * Constructor
 * 
 * @param fileSystem - the object to use for 
 * interacting with the file system
 */
    public AddressBookController(FileSystem fileSystem) {
        this.fileSystem=fileSystem;
    
    }
    
    public void doAdd(AddressBookGUI gui){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        personInfoInput=MultiInputPane.showMultiInputDialog(gui,personInfo,addressBook.getTitle());
        addressBook.addPerson(personInfoInput);
    }
    
    public void doEdit(AddressBookGUI gui, int index){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        String fullName=addressBook.getFullNameOfPerson(index);
        String[] otherPersonInfo=addressBook.getOtherPersonInformation(index);
        otherPersonInfoInput=MultiInputPane.showMultiInputDialog(gui,personInfo,otherPersonInfo,fullName);
        addressBook.updatePerson(index,otherPersonInfoInput);
        
    }
    
    public void doDelete(AddressBookGUI gui,int index){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        String fullName=addressBook.getFullNameOfPerson(index);
        int result=JOptionPane.showConfirmDialog(gui, new String("Do you "
                + "want to delete "+fullName+" from your address book?"), ""
                        + "delete?",JOptionPane.YES_NO_OPTION);
        if (result==JOptionPane.YES_OPTION)
        addressBook.removePerson(index);
        
        
    }
    
    public void doSortByName(AddressBookGUI gui){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        addressBook.sortByName();
    }
    
    public void doSortByZip(AddressBookGUI gui){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        addressBook.sortByZip();
        
    }
    
    public void doSaveAs(AddressBookGUI gui){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        JFileChooser fileChooser=new JFileChooser();
        int val=fileChooser.showSaveDialog(gui);
        if(val==JFileChooser.APPROVE_OPTION){
            File file=fileChooser.getSelectedFile();
           try{
            fileSystem.saveFile(addressBook, file);
           }catch (IOException ex){
               //catch(IOException ex) {
               JOptionPane.showMessageDialog(gui,
               new String("Can not open the file"), "Waring", JOptionPane.ERROR_MESSAGE
               );
           }
        }
        if (val==JFileChooser.CANCEL_OPTION){
                        
        }
    }
    
    public void doSave(AddressBookGUI gui){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        File file=addressBook.getFile();
        if (file==null){
            doSaveAs(gui);
        }else if (file!=null){
            try{
                fileSystem.saveFile(addressBook, file);
            }catch (IOException ex){
               
               JOptionPane.showMessageDialog(gui,
               new String("Can not open the file"), "Waring", JOptionPane.ERROR_MESSAGE
               );
            }
        }
    }
    
    public void doOfferSaveChanges(AddressBookGUI gui){
        this.gui=gui;
        addressBook=gui.getAddressBook();
        int result=JOptionPane.showConfirmDialog(gui, new String("Do you "
                + "want to save the changes? "),"Save",JOptionPane.YES_NO_OPTION);
        if (result==JOptionPane.YES_OPTION)
        doSave(gui);
        
    }
    
    public void doNew(AddressBookGUI gui){
        this.gui=gui;
        
        AddressBook newAddressBook=new AddressBook();
        gui.setAddressBook(newAddressBook);
        
        
    }
    
    public void doOpen(AddressBookGUI gui){
        this.gui=gui;
        JFileChooser fileChooser=new JFileChooser();
        int val=fileChooser.showOpenDialog(gui);
        if(val==JFileChooser.ALLBITS){
            File file=fileChooser.getSelectedFile();
            addressBook=fileSystem.readFile(file);
            gui.setAddressBook(addressBook);
            
        }
    }
    
    
    
}
