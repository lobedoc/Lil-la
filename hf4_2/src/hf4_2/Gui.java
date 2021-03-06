package hf4_2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JFrame dispFrame;
	private static JTextArea opArea;
	private static JTextField ipField;
	private static JLabel heading;
	public static boolean isInputReady = false;

	public Gui(String title) {
		dispFrame = new JFrame(title);
		opArea = new JTextArea("");
		ipField = new JTextField();
		heading = new JLabel(".: Console :.", JLabel.CENTER);
		opArea.setEditable(false);
		JScrollPane scrollingArea = new JScrollPane(opArea);
		dispFrame.add(heading, BorderLayout.NORTH);
		dispFrame.add(scrollingArea, BorderLayout.CENTER);
		dispFrame.add(ipField, BorderLayout.SOUTH);
		dispFrame.setSize(new Dimension(600, 400));
		dispFrame.setVisible(true);
		dispFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		redirectStreams();
	}

	public static void showFrame() {
		dispFrame.setVisible(true);
	}

	public static void hideFrame() {
		dispFrame.setVisible(false);
	}

	public static String readString(String prompt) {
		return (getInput(prompt));
	}

	public static String readString() {
		return (getInput(null));
	}

	public static int readInt(String prompt) {
		return (Integer.parseInt(getInput(prompt)));
	}

	public static int readInt() {
		return (Integer.parseInt(getInput(null)));
	}

	private static synchronized String getInput(String prompt) {
		String tmp = null;
		ipField.addKeyListener(listener);
		if (prompt != null) {
			out(prompt);
		}
		// wait
		while (!isInputReady) {
			tmp = ipField.getText();
		}
		ipField.setText("");
		isInputReady = false;
		return tmp;

	}

	private static KeyListener listener = new KeyListener() {
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == '\n' && !ipField.getText().trim().equals("")) {
				isInputReady = true;
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}
	};

	private void redirectStreams() {
		OutputStream outs = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				out(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				out(new String(b, off, len));
			}

			@Override
			public void write(byte[] b) throws IOException {
				out(new String(b, 0, b.length));
			}
		};
		System.setOut(new PrintStream(outs, true));
		System.setErr(new PrintStream(outs, true));
	}

	public static void out(final String str) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				opArea.setText(opArea.getText() + str);
			}
		});
	}

	public static void cls() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				opArea.setText("");
			}
		});
	}
}
