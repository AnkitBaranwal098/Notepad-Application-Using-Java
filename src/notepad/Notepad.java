package notepad;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.undo.*;

class myFrame extends JFrame implements ActionListener
{
    String str = "";
    JDesktopPane dp;
    String s;
    JTextArea ta;
    JScrollPane sp;
    file_function ff;
    format f;
    UndoManager um ;

    myFrame(){
        super("Untitled - Notepad");
        um = new UndoManager();
        ff = new file_function(this);
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu font = new JMenu("Format");
        JMenu help = new JMenu("Help");
        ta = new JTextArea();
        ta.getDocument().addUndoableEditListener(new UndoableEditListener(){
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
        

        
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(new Font("Consolas",Font.PLAIN,18));
        sp = new JScrollPane(ta);
        
        JMenuItem newdoc = new JMenuItem("New");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);
        
        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        
        JMenuItem saveAs = new JMenuItem("SaveAs");
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        saveAs.addActionListener(this);
        
        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        exit.addActionListener(this);
        
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        
        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        
        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        
        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        selectAll.addActionListener(this);
        
        JMenuItem undo = new JMenuItem("Undo");
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
        undo.addActionListener(this);
        
        JMenuItem redo = new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
        redo.addActionListener(this);
        
        JMenuItem mfont = new JMenuItem("Font");
        mfont.addActionListener(this);
        
        JMenuItem about = new JMenuItem("About Us");
        about.addActionListener(this);
        
        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(print);
        file.add(exit);
        
        edit.add(undo);
        edit.add(redo);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        
        font.add(mfont);
        
        help.add(about);
        
        mb.add(file);
        mb.add(edit);
        mb.add(font);
        mb.add(help);
        setJMenuBar(mb);
        add(sp,BorderLayout.CENTER);
        sp.setBorder(BorderFactory.createEmptyBorder());
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       s = e.getActionCommand();
       switch(s)
       {
           case "Exit" : 
               System.exit(0);
               break;
           case "Print" :
               try{
                
                ta.print();
                }catch(Exception i){
                    System.out.println(i);
            }break;
           case "New" : 
               ff.newdoc();
               break;
           case "Copy" :
               str = ta.getSelectedText();
               break;
           case "Undo" :
               um.undo();
               break;
           case "Redo" :
               um.redo();
               break;
           case "Paste" :
               ta.append(str);
               break;
           case "Cut" :
               ta.cut();
               break;
           case "Open" :
               ff.open();
               break;
           case "SaveAs" :
               ff.saveAs();
               break;
           case "Save" :
               ff.save();
               break;
           case "Font" :
                f= new format(this);
                break;
           case "About Us" :
               aboutUsFrame auf = new aboutUsFrame(this);
               break;
           case "Select All" :
               ta.selectAll();
               break;
       }
       
    }

    
}

public class Notepad {

    public static void main(String[] args) 
    {
        myFrame f = new myFrame();
        f.setSize(610,660);
        f.setLocation(500,50);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
