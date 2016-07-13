import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.UIManager;

public class TranscluentWindow {

	private JWindow frame;
	
    public TranscluentWindow() {
        EventQueue.invokeLater(new Runnable() {
            
			@Override
            public void run() {
										
                try {
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
					ex.getStackTrace();
				}
                
                try {
					if(!App.SAVES.getSave().equals(null)) {
						
						for(Iterator<String> iter = App.SAVES.getSave().iterator(); iter.hasNext(); ) {
							App.SAVES.addSave(iter.next());
						}
						
					}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}

				frame = new JWindow();
				frame.setAlwaysOnTop(true);
				frame.setBackground(new Color(0,0,0,0));
				TranslucentPane pane = new TranslucentPane();
				frame.setContentPane(pane);
				frame.setSize(new Dimension(200, 400));
				pane.setLayout(new FlowLayout());
	
						
						
//						folder open
//						Desktop.getDesktop().open(new File("C:\\"));
					
//						exe open 
//						Runtime.getRuntime().exec("D:\\Transcend\\MortalKombatTrilogy\\MKTRILW.EXE", null, new File("D:\\Transcend\\MortalKombatTrilogy"));
					
//						txt open in notepad
//						Process p = Runtime.getRuntime().exec("notepad " + ("c:\\1.txt"));
						

				
//				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

            }
        });
    }
    
    public void addButton(JButton btn) {
    	frame.add(btn);
    	frame.repaint();
    	frame.revalidate();
    }
}