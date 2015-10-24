package view;

import javax.swing.JTextField;
import javax.swing.text.Document;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class NumberTextField extends JTextField {
	private char[] acceptedList;

	public NumberTextField() {
		this.setAcceptedList();
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(String arg0) {
		super(arg0);
		this.setAcceptedList();
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(int arg0) {
		super(arg0);
		this.setAcceptedList();
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(String arg0, int arg1) {
		super(arg0, arg1);
		this.setAcceptedList();
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(Document arg0, String arg1, int arg2) {
		super(arg0, arg1, arg2);
		this.setAcceptedList();
		this.addKeyListener(new TxtFieldKeyListener());
	}
	
	private void setAcceptedList() {
		this.acceptedList = new char[12];

		for(int i = 0; i < 10; i++) {
			this.acceptedList[i] = (char) ('0' + i);
		}

		this.acceptedList[10] = ('-');
		this.acceptedList[11] = ('+');
	}

	private class TxtFieldKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			boolean isAccepted = false;
			for(char chk: acceptedList) {
				if(arg0.getKeyChar() == chk) {
					isAccepted = true;
				}
			}
				
			if(!isAccepted) {
				arg0.consume();
			}
		}
		
	}

}
