package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import net.lingala.zip4j.*;
import net.lingala.zip4j.exception.ZipException;

public class ApplicationTest {
	
	private JFrame window;
    private JButton createZipButton, extractZipButton, removeFileButton;
    private JTextField jf;
    private ZipControl zc;
    
    private int[] createZipButtonBounds = {
    		310, 160, 210, 40
    };
    private int[] extractZipButtonBounds = {
    		310, 210, 210, 40
    };
    private int[] removeFileButtonBounds = {
    		310, 260, 210, 40		
    };
    private int[] TextFieldBounds = {
    		310, 110, 210, 40
    };
    private ApplicationTest() {
		window = new JFrame("Zip Management Test");
		window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setPreferredSize(new Dimension(854, 480));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.getContentPane().setBackground(Color.white);
	
        jf = createField(jf, "Choose Zip file Name", TextFieldBounds, Color.white, Color.black, 10, false);
        createZipButton = createButton(createZipButton, "Create Zip", createZipButtonBounds, false, Color.white, Color.black);
        extractZipButton = createButton(extractZipButton, "Extract Zip", extractZipButtonBounds, false, Color.white, Color.black);
        removeFileButton = createButton(removeFileButton, "Remove File Content", removeFileButtonBounds, false, Color.white, Color.black);
               
		jf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {	   
				if(e.getSource() == jf) {
					jf.setText("");
					jf.setEnabled(true);
				}
			}
		});
        window.add(jf);
        window.add(createZipButton);
        window.add(extractZipButton);
        window.add(removeFileButton);
	   
        zc = new ZipControl();
    
        createZipButton.addActionListener(e -> {
        	if(e.getSource() == createZipButton) {
               zc.initSystem(jf.getText());
               zc.addContent("content.txt");
        	}
        });
        extractZipButton.addActionListener(e -> {
        	if(e.getSource() == extractZipButton) {
               zc.extractZip("content.txt", "src");
        	}
        });
        removeFileButton.addActionListener(e -> {
        	if(e.getSource() == removeFileButton) {
               zc.removeFile("content.txt");
        	}
        });    
    }
	public static void main(String[] args) {
	//	SwingUtilities.invokeLater(Main :: new);
	}
	private JButton createButton(JButton b, String text, int[] bounds, boolean focusable, Color bc, Color fg) {
		b = new JButton(text);
		b.setFocusable(focusable);
		b.setBackground(bc);
		b.setForeground(fg);
		b.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return b;
	}
	private JTextField createField(JTextField f, String text, int[] bounds, Color bc, Color fg, final int col, boolean en) {
		f = new JTextField(text);
		f.setBackground(bc);
		f.setForeground(fg);
		f.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		f.setColumns(col);
		f.setEnabled(en);
		return f;
	}
	private class ZipControl {
		private ZipFile zf;
        private File f;
        public ZipControl() {
        }
        public void initSystem(String fileName) {
        	f = new File(fileName);
        	zf = new ZipFile(f);
        }
        public void addContent(String content) {
        	try {
        		zf.addFile(new File(content));
        		try {
        			zf.close();
        		}catch(IOException _) {
       		  }
        	}catch(ZipException e) {
        		e.printStackTrace();
        	}
        }
        public void extractZip(String contentName, String destination) {
        	try {
        		zf.extractFile(contentName, destination);
        	}catch(ZipException e) {
        		e.printStackTrace();
        	}
        }
        public void removeFile(String fileName) {
        	try {
        		zf.removeFile(fileName);
        	}catch(ZipException e) {
        		System.out.println("Failed to remove a file: " + e.getMessage());
        	}
        }
	}
}
