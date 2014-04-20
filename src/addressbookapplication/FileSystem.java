/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbookapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author tonyw_000
 */


public class FileSystem {
    
    AddressBook addressBook;
    
    
    public AddressBook readFile(File file){
        
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
            addressBook=(AddressBook)in.readObject();
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null,
                    new String("Can not open the file"), "Waring", JOptionPane.ERROR_MESSAGE
                );
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,
                    new String("Can not found the addressbook in file"), "Waring", JOptionPane.ERROR_MESSAGE
                );
        }
        addressBook.setChangedSinceLastSave(false);
        addressBook.setFile(file);
        return addressBook;
    }
    
    public void saveFile(AddressBook addressBook, File file) throws IOException {
        this.addressBook=addressBook;
        addressBook.setChangedSinceLastSave(false);
        addressBook.setFile(file);
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(addressBook);
            
        }//catch(IOException ex) {
           // JOptionPane.showMessageDialog(null,
                   // new String("Can not open the file"), "Waring", JOptionPane.ERROR_MESSAGE
               // );
         }
        
        
    }
    
    

