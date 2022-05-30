package notepad;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class format  extends JFrame implements ActionListener
{
    JButton okay,cancel;
    JTextArea ta;
    JLabel font,fontSize,fonttype,theme,wrap;
    JComboBox ffont,ffontSize,ffonttype,ftheme,fwrap;
    String cfonttype[] = {"Default","Regular","Bold","Italic","Bold Italic"};
    String cfontSize[] = {"10","12","14","16","18","19","20","21","22"};
    String ctheme[] = {"Default","Light Mode","Dark Mode"};
    String cfont[] = {"Default","Times New Roman","Arial","SANS_SERIF","SERIF","ComicSansMs"};
    String cwrap[] = {"Default","Wrap-On","Wrap-off"};
    myFrame f;
    Font notepad_font;
    String getFontName,getFont,temp;
    Color notepad_background,notepad_foreground,notepad_caret;
    boolean notepad_Lwrap,notepad_Wwrap,format_Wrap=true;
    int typevalue=0,fontsize=0,getFontStyle,getFontSize;
    format(myFrame f){
        super("Font");
        this.f = f;
        
        notepad_font = f.ta.getFont();
        notepad_background = f.ta.getBackground();
        notepad_foreground = f.ta.getForeground();
        notepad_caret = f.ta.getCaretColor();
        notepad_Lwrap = f.ta.getLineWrap();
        notepad_Wwrap = f.ta.getWrapStyleWord();
        
        font = new JLabel("Font:");
        fontSize = new JLabel("FontSize:");
        fonttype = new JLabel("Font Type:");
        theme = new JLabel("Theme:");
        wrap = new JLabel("Wrap:");
        
        ffont = new JComboBox(cfont);
        ffont.setActionCommand("FontName");
        ffontSize = new JComboBox(cfontSize);
        ffontSize.setActionCommand("FontSize");
        ffontSize.setMaximumRowCount(5);
        ffonttype = new JComboBox(cfonttype); 
        ffonttype.setActionCommand("FontType");
        ftheme = new JComboBox(ctheme);
        ftheme.setActionCommand("Theme");
        fwrap = new JComboBox(cwrap);
        fwrap.setActionCommand("Wrap");
   
        ta = new JTextArea(10,9);
        ta.setText("\n\n\tABC");
        ta.setBackground(f.ta.getBackground());
        ta.setForeground(f.ta.getForeground());
        ta.setCaretColor(f.ta.getCaretColor());
        ta.setFont(f.ta.getFont());
          
        getFont = ta.getFont().toString();
        getFontName = ta.getFont().getName();
        getFontStyle = ta.getFont().getStyle();
        getFontSize = ta.getFont().getSize();

        setLayout(null);
        font.setBounds(15,20,100,20);
        ffont.setBounds(15, 45, 150, 20);
        
        fonttype.setBounds(200,20,100,20);
        ffonttype.setBounds(200,45,150,20);
        
        fontSize.setBounds(400,20,100,20);
        ffontSize.setBounds(400,45,50,20);
        
        theme.setBounds(15,110,100,120);
        ftheme.setBounds(15, 185,150, 20);
        
        wrap.setBounds(15, 210, 100, 120);
        fwrap.setBounds(15, 280, 100, 20);
        
        ta.setBounds(220, 185, 230, 120);
        ta.setEditable(false);
        ta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sample"));
        
        okay = new JButton("OK");
        okay.setBounds(150, 400, 55, 22);
        okay.setBorder(BorderFactory.createEtchedBorder());
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 400, 75, 22);
        
        //Add Action Listener to Components
        okay.addActionListener(this);
        cancel.addActionListener(this);
        ftheme.addActionListener(this);
        fwrap.addActionListener(this);
        ffont.addActionListener(this);
        ffontSize.addActionListener(this);
        ffonttype.addActionListener(this);
        
        add(okay);
        add(cancel);
        add(font);
        add(ffont);
        add(ffonttype);
        add(fonttype);
        add(fontSize);
        add(ffontSize);
        add(theme);
        add(ftheme);
        add(wrap);
        add(fwrap);
        add(ta);
        setSize(500,490);
        setLocation(550,150);
        setVisible(true);
        this.setResizable(false);
       // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String str = e.getActionCommand();
        switch(str)
        {
            case "Cancel" :
                
                f.ta.setFont(notepad_font);
                f.ta.setBackground(notepad_background);
                f.ta.setForeground(notepad_foreground);
                f.ta.setCaretColor(notepad_caret);
                f.ta.setLineWrap(notepad_Lwrap);
                f.ta.setWrapStyleWord(notepad_Wwrap);
                setVisible(false);
                break;
                
            case "OK" :
               
                f.ta.setLineWrap(format_Wrap);
                f.ta.setWrapStyleWord(format_Wrap);
                f.ta.setFont(ta.getFont());
                f.ta.setBackground(ta.getBackground());
                f.ta.setForeground(ta.getForeground());
                f.ta.setCaretColor(ta.getCaretColor());             
                setVisible(false);
                break;
                
            case "Theme" :
                if(ftheme.getSelectedItem()=="Dark Mode")
                {
                    ta.setBackground(Color.black);
                    ta.setForeground(Color.white);
                    ta.setCaretColor(Color.white);
                }   
                if(ftheme.getSelectedItem()=="Light Mode")
                {
                    ta.setBackground(Color.white);
                    ta.setForeground(Color.black);
                    ta.setCaretColor(Color.black);
                }   
                break;
                
            case "Wrap" :
                if(fwrap.getSelectedItem()=="Wrap-On")
                {
                    format_Wrap = true;
                    ta.setLineWrap(true);
                    ta.setWrapStyleWord(true);
                }
                else if(fwrap.getSelectedItem()=="Wrap-off")
                {
                    format_Wrap = false;
                    ta.setLineWrap(false);
                    ta.setWrapStyleWord(false);
                }
                break;
                
            case "FontName" :
                String fontname = (String)ffont.getSelectedItem();
                if("Times New Roman".equals(fontname))
                    temp = "Times New Roman";
                else if("Arial".equals(fontname))
                    temp = "Arial";
                else if("SANS_SERIF".equals(fontname))
                    temp = "SANS_SERIF";
                else if("SERIF".equals(fontname))
                    temp = "SERIF";
                else if("ComicSansMs".equals(fontname))
                    temp = "ComicSansMs";
                getFontName = temp;
                createFont();
                break;
                
            case "FontType" :
                String type = (String)ffonttype.getSelectedItem();
                if("Bold".equals(type))
                    typevalue = 1;
                else if("Plain".equals(type))
                    typevalue = 0;
                else if("Italic".equals(type))
                    typevalue = 2;
                else if("Bold Italic".equals(type))
                    typevalue = 3;
                getFontStyle = typevalue;
                createFont();
                break;
                
            case "FontSize" :
                String typeSize = (String)ffontSize.getSelectedItem();
                
                if(typeSize.equals("10"))
                    fontsize=10;
                else if(typeSize.equals("12"))
                    fontsize=12;
                else if(typeSize.equals("14"))
                    fontsize=14;
                else if(typeSize.equals("16"))
                    fontsize=16;
                else if(typeSize.equals("18"))
                    fontsize=18;
                else if(typeSize.equals("19"))
                    fontsize=19;
                else if(typeSize.equals("20"))
                    fontsize=20;
                else if(typeSize.equals("21"))
                    fontsize=21;
                else if(typeSize.equals("22"))
                    fontsize=22;

                getFontSize = fontsize;
                createFont();
                break;

        }
    }
    public void createFont()
    {
        ta.setFont(new Font(getFontName,getFontStyle,getFontSize));
    }
}
