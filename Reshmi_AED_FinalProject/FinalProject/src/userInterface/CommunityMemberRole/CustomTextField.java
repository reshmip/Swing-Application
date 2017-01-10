package userInterface.CommunityMemberRole;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reshmi
 */
public class CustomTextField extends JTextField{
private Font originalFont;
    private Color originalForeground;
    /**
     * Grey by default*
     */
    private Color placeholderForeground = new Color(160, 160, 160);
    private boolean textWrittenIn;
 
    /**
     * You can insert all constructors.
     * I inserted only this one.*
     */
    public CustomTextField(int columns) {
        super(columns);
    }
 
    @Override
    public void setFont(Font f) {
        super.setFont(f);
        if (!isTextWrittenIn()) {
            originalFont = f;
        }
    }
 
    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (!isTextWrittenIn()) {
            originalForeground = fg;
        }
    }
 
    public Color getPlaceholderForeground() {
        return placeholderForeground;
    }
 
    public void setPlaceholderForeground(Color placeholderForeground) {
        this.placeholderForeground = placeholderForeground;
    }
 
    public boolean isTextWrittenIn() {
        return textWrittenIn;
    }
 
    public void setTextWrittenIn(boolean textWrittenIn) {
        this.textWrittenIn = textWrittenIn;
    }
 
    private void customizeText(String text) {
        setText(text);
        /**If you change font, family and size will follow
         * changes, while style will always be italic**/
        setFont(new Font(getFont().getFamily(), Font.ITALIC, getFont().getSize()));
        setForeground(getPlaceholderForeground());
        setTextWrittenIn(false);
    }
    public void setPlaceholder(final String text) {
 
        this.customizeText(text);
 
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
 
            public void warn() {
                if (getText().trim().length() != 0) {
                    setFont(originalFont);
                    setForeground(originalForeground);
                    setTextWrittenIn(true);
                }
 
            }
        });
 
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!isTextWrittenIn()) {
                    setText("");
                }
 
            }
 
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().trim().length() == 0) {
                    customizeText(text);
                }
            }
 
        });
 
    }
//    private String placeholder;
//    private Color colorHit = getForeground();
//    private boolean  showHit;
//    public CustomTextField(String placeholder){
//        super(placeholder);
//        this.placeholder = placeholder;
//        this.showHit = true;
//        this.addFocusListener(this);
//        this.setForeground(colorHit);
//        this.setColumns(15);
//        this.setColorHit(new Color(100,100,100));
//    }
//
//    public Color getColorHit() {
//        return colorHit;
//    }
//
//    public void setColorHit(Color colorHit) {
//        this.colorHit = colorHit;
//    }
//    
//    
//    @Override
//    public void focusGained(FocusEvent e) {
//        if(this.getText().isEmpty()){
//            super.setText("");
//            showHit = false;
//            
//        }
//    }
//
//    @Override
//    public void focusLost(FocusEvent e) {
//        if(this.getText().isEmpty()){
//            super.setText("");
//            showHit = true;          
//        }
//    }
//
//    @Override
//    public String getText() {
//        return showHit ? "" : super.getText();
//    }   
}
