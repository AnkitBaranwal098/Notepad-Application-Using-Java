package notepad;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class file_function
{
    String fileName,fileAddress,s="";
    myFrame f;
    file_function(myFrame f)
    {
        this.f = f;
    }
    public void newdoc(){
        f.ta.setText(s);
        f.setTitle("Untitled - Notepad");
        fileName=null;
        fileAddress=null;
    }
    public void open(){
        FileDialog fd = new FileDialog(f,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile()!=null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            f.setTitle(fileName);
            try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            
            f.ta.setText("");
            String line=null;
            while((line = br.readLine())!=null)
            {
                System.out.println(fileAddress+fileName);
                f.ta.append(line);
            }
            br.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
            
    }
    public void saveAs(){
        FileDialog fd = new FileDialog(f,"SaveAs Window",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            f.setTitle(fileName);
        }
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileAddress+fileName));
            String line;
            line = f.ta.getText();
            bw.write(line);
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public void save()
    {
        if(fileName==null)
        {
            saveAs();
        }
        else{
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileAddress+fileName));
                String line;
                line = f.ta.getText();
                f.setTitle("fileName");
                bw.write(line);
                bw.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
    
}
