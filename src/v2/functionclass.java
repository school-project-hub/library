/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class functionclass {
    
    
    public DefaultTableModel functionclassB(String desx ,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("InventoryNumber");
        dm.addColumn("Category ");
        dm.addColumn("Price");
        dm.addColumn("Description");
        dm.addColumn("Author");
        dm.addColumn("AcquiredDate");
        dm.addColumn("EstimatedUsefulLife");
        dm.addColumn("Quantity");
        
        String sql=null;  
        
        if(desx == "Description"){          
            sql = "SELECT * FROM books WHERE Description LIKE  '"+text+"%'  ";            
        } 
         
        try{
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
             rs = s.executeQuery();
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                String bc = rs.getString(8);
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp,bc});              
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
        }
    
    ///// updatebook
    
    public DefaultTableModel bookupdate(int choice ,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("InventoryNumber");
        dm.addColumn("Category ");
        dm.addColumn("Price");
        dm.addColumn("Description");
        dm.addColumn("Author");
        dm.addColumn("AcquiredDate");
        dm.addColumn("EstimatedUsefulLife");
        dm.addColumn("Quantity");
        
        String sql=null;        
        if(choice == 0){          
            sql="SELECT * FROM books WHERE InventoryNumber LIKE  '"+text+"%'  ";            
        }       
        try{
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
             rs = s.executeQuery();
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                String bc = rs.getString(8);
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp,bc});              
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
        }
///
    public DefaultTableModel bookupdatedesc(int choice ,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("InventoryNumber");
        dm.addColumn("Category ");
        dm.addColumn("Price");
        dm.addColumn("Description");
        dm.addColumn("Author");
        dm.addColumn("AcquiredDate");
        dm.addColumn("EstimatedUsefulLife");
        dm.addColumn("Quantity");
        
        
        String sql=null;        
        if(choice == 0){          
            sql="SELECT * FROM books WHERE Description LIKE  '"+text+"%'  ";            
        }       
        try{
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
             rs = s.executeQuery();
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                //String bc = rs.getString(8);
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp});              
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
        }
    
    /////return filter
    
    public DefaultTableModel returninv(int choice ,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("InventoryNumber");
        dm.addColumn("Category ");
        dm.addColumn("Price");
        
        dm.addColumn("Description");
        dm.addColumn("Author");
        dm.addColumn("IDnumber");
        dm.addColumn("LastName");
         dm.addColumn("FirstName");
          dm.addColumn("Mi");
           dm.addColumn("Contact_EmailAddress");
            dm.addColumn("Address");
             dm.addColumn("Date");
        
        String sql=null;        
        if(choice == 0){          
            sql="SELECT * FROM borrowd WHERE InventoryNumber LIKE  '"+text+"%'  ";            
        }       
        try{
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
             rs = s.executeQuery();
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                String a = rs.getString(8);
                String b = rs.getString(9);
                String c = rs.getString(10);
                String d = rs.getString(11);
                String e = rs.getString(12);
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp,a,b,c,d,e});              
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
        }
    ///
    public DefaultTableModel returnid(int choice ,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("InventoryNumber");
        dm.addColumn("Category ");
        dm.addColumn("Price");
        dm.addColumn("Description");
        dm.addColumn("Author");
        dm.addColumn("IDnumber");
        dm.addColumn("LastName");
         dm.addColumn("FirstName");
          dm.addColumn("Mi");
           dm.addColumn("Contact_EmailAddress");
            dm.addColumn("Address");
             dm.addColumn("Date");
        
        String sql=null;        
        if(choice == 0){          
            sql="SELECT * FROM borrowd WHERE IDnumber LIKE  '"+text+"%'  ";            
        }       
        try{
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
             rs = s.executeQuery();
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                String a = rs.getString(8);
                String b = rs.getString(9);
                String c = rs.getString(10);
                String d = rs.getString(11);
                String e = rs.getString(12);
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp,a,b,c,d,e});              
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
        }
    ////
    public DefaultTableModel returndesc(int choice ,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("InventoryNumber");
        dm.addColumn("Category ");
        dm.addColumn("Price");
        dm.addColumn("Description");
        dm.addColumn("Author");
        dm.addColumn("IDnumber");
        dm.addColumn("LastName");
         dm.addColumn("FirstName");
          dm.addColumn("Mi");
           dm.addColumn("Contact_EmailAddress");
            dm.addColumn("Address");
             dm.addColumn("Date");
        
        String sql=null;        
        if(choice == 0){          
            sql="SELECT * FROM borrowd WHERE Description LIKE  '"+text+"%'  ";            
        }       
        try{
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
             rs = s.executeQuery();
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                String a = rs.getString(8);
                String b = rs.getString(9);
                String c = rs.getString(10);
                String d = rs.getString(11);
                String e = rs.getString(12);
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp,a,b,c,d,e});              
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
        }
    ////
    public DefaultTableModel staffs(int choice ,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("IDnumber");
        dm.addColumn("CourseYear ");
        dm.addColumn("LastName");
        dm.addColumn("FirstName");
        dm.addColumn("Mi");
        dm.addColumn("Gender");
        dm.addColumn("BirthDate");
         dm.addColumn("Contact");
          dm.addColumn("DateRegistered");
        
        String sql=null;        
        if(choice == 0){          
            sql="SELECT * FROM staff WHERE _IDnumber LIKE  '"+text+"%'  ";            
        }       
        try{
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb","root","");
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
             rs = s.executeQuery();
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                String a = rs.getString(8);
                String b = rs.getString(9);
;
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp,a,b});              
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null ;
        }
}
