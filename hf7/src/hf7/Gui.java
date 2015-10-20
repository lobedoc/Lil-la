package hf7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Gui implements Runnable, ActionListener, ItemListener {

	public JFrame window = new JFrame(".:Lyáték:.");
	protected JPanel panel = new JPanel();
	protected JPanel up = new JPanel();
	protected JPanel down = new JPanel();

	protected JButton start = new JButton("Start");
	protected JButton hozzaAd = new JButton("Új játékos hozzáadása");

	protected JLabel randomLetter = new JLabel("..i.(-_-).i..", SwingConstants.CENTER);
	protected JLabel teglalap = new JLabel("Press Start", SwingConstants.CENTER);
	protected Font fontLabel = new Font("Comic Sans MS", Font.BOLD, 50);
	protected Font fontTextarea = new Font("Comic Sans MS", Font.BOLD, 11);

	protected JTextArea textAreaResults = new JTextArea();
	protected JTextArea dialogText = new JTextArea();
	
	protected JScrollPane scroll = new JScrollPane (textAreaResults);

	protected Border border = BorderFactory.createLineBorder(Color.WHITE);

	public static String generateRandomChars(String candidateChars, int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}
		return sb.toString();
	}

	public void run() {

		window.setLayout(new BorderLayout());
		window.add(panel, BorderLayout.CENTER);

		randomLetter.setOpaque(true);
		randomLetter.setBackground(Color.BLACK);
		randomLetter.setForeground(Color.MAGENTA);
		randomLetter.setFont(fontLabel);
		
		teglalap.setOpaque(true);
		teglalap.setBackground(Color.BLACK);
		teglalap.setForeground(Color.MAGENTA);
		teglalap.setFont(fontTextarea);
		teglalap.setBorder(border);

		scroll.setPreferredSize(new Dimension(199, 100));
		
		textAreaResults.setBackground(Color.BLACK);
		textAreaResults.setForeground(Color.MAGENTA);
		textAreaResults.setWrapStyleWord(true);
		textAreaResults.setFont(fontTextarea);
		textAreaResults.setEditable(false);
		
		panel.setLayout(new BorderLayout());
		up.setLayout(new BorderLayout());
		down.setLayout(new BorderLayout());
		teglalap.setBackground(Color.BLACK);
		panel.add(up, BorderLayout.NORTH);
		panel.add(down, BorderLayout.CENTER);

		up.add(start, BorderLayout.WEST);
		up.add(teglalap, BorderLayout.CENTER);
		up.add(hozzaAd, BorderLayout.EAST);
		down.add(randomLetter, BorderLayout.CENTER);
		down.add(scroll, BorderLayout.EAST);

		window.getContentPane().add(panel);
		window.setSize(510, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLocationRelativeTo(null);// középre igazít
		window.setResizable(false);

		start.addActionListener(this);
		hozzaAd.addActionListener(this);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == start) {
			
			start.setEnabled(false);

			randomLetter.setText(generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1));

			Random random = new Random();
			int i = random.nextInt(5) + 2;
			Timer t = new Timer(i, new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					teglalap.setBackground(Color.BLUE);
				}
			});
			t.start();
			long tStart = System.currentTimeMillis() - i;
			
			

			randomLetter.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					long tEnd = System.currentTimeMillis();
					long tDelta = tEnd - tStart;
					double elapsedSeconds = tDelta / 1000.0;
					textAreaResults.append(String.valueOf(elapsedSeconds) + "másodperc." + "\n");
					t.stop();
					teglalap.setBackground(Color.BLACK);
					teglalap.setText("Kor vege");
					start.setEnabled(true);
				}
			});

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (ev.getSource() == hozzaAd) {

			String input = JOptionPane.showInputDialog("Uj jatekos neve:");
			textAreaResults.append(input + "\n");
			textAreaResults.repaint();
			textAreaResults.revalidate();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
