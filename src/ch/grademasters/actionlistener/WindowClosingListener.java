package ch.grademasters.actionlistener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowClosingListener implements WindowListener{

	private JFrame frame;
	
	public WindowClosingListener(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		frame.setEnabled(true);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

}
