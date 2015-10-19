package par;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Gui implements Runnable, ActionListener, ItemListener {
	public static File fileName;
	public static File fileName2;
	public static File webfileName;
	public JFrame window = new JFrame(".:Kivonat:.");
	protected JPanel Panel = new JPanel();
	protected JPanel Up = new JPanel();
	protected JPanel Opens = new JPanel();
	protected JPanel Down = new JPanel();

	protected JMenuBar menuBar = new JMenuBar();
	protected JMenu fileMenu;
	protected JMenuItem exitMenuItem;

	protected JButton Open = new JButton("Megnyitas");
	protected JButton Parse = new JButton("Electra_Feldolgozas");
	protected JButton Parse2 = new JButton("Webes_Feldolgozas");
	protected JButton Parse3 = new JButton("Webesbol_CSV");
	
	Border thickBorder = new LineBorder(Color.GRAY, 5);

	ImageIcon img = new ImageIcon("icon.jpg");
	

	public static JTextArea textArea = new JTextArea(300, 60);
	
	Font fontTextArea = new Font("Verdana", Font.BOLD, 12);
	Font fontButtons = new Font("Verdana", Font.PLAIN, 12);

	public void run() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		fileMenu.add(exitMenuItem);
		menuBar.add(fileMenu);

		window.setLayout(new BorderLayout());
		window.add(Panel, BorderLayout.CENTER);
		window.add(menuBar, BorderLayout.NORTH);

		Panel.setLayout(new BorderLayout());
		Up.setLayout(new BorderLayout());
		Opens.setLayout(new BorderLayout());
		Down.setLayout(new BorderLayout());

		Panel.add(Up, BorderLayout.NORTH);
		Panel.add(Down);

		Up.add(Opens, BorderLayout.NORTH);
		Opens.add(Open, BorderLayout.NORTH);
		Opens.add(Parse3, BorderLayout.CENTER);
		Up.add(Parse, BorderLayout.CENTER);
		Up.add(Parse2, BorderLayout.SOUTH);
		Down.add(textArea, BorderLayout.NORTH);
		
		Open.setFont(fontButtons);
		Parse.setFont(fontButtons);
		Parse2.setFont(fontButtons);
		Parse3.setFont(fontButtons);
		
		textArea.setFont(fontTextArea);
		textArea.setForeground(Color.BLACK);

		window.getContentPane().add(Panel);
		window.setSize(350, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Bezárás
		window.setVisible(true);
		window.setLocationRelativeTo(null);// középre igazítja be
		window.setResizable(false);
		window.setIconImage(img.getImage());

		Parse.setBorder(thickBorder);
		Parse2.setBorder(thickBorder);
		
		Open.addActionListener(this);
		Parse.addActionListener(this);
		Parse.setEnabled(false);
		Parse2.addActionListener(this);
		Parse2.setEnabled(false);
		Parse3.addActionListener(this);
		Parse3.setEnabled(true);
		
		PrintStream out1 = new PrintStream(new TextAreaOutputStream(Gui.textArea));
		System.setOut(out1);
		System.setErr(out1);

	}

	@Override
	public void itemStateChanged(ItemEvent ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == Open) {
			
			textArea.setText("Open File" + "\n");
			Open.setEnabled(true);
			JFileChooser openFile = new JFileChooser();
			openFile.showOpenDialog(null);
			fileName = openFile.getSelectedFile();
			fileName2 = openFile.getSelectedFile();
			if (fileName == null && fileName2 == null)
			{
				System.out.println("Nincs megnyitva file!");
				return;
			}			
			//Open.setEnabled(false);
			Parse.setEnabled(true);
			Parse2.setEnabled(true);
			Parse3.setEnabled(true);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (ev.getSource() == Parse) {
			
			Parse.setEnabled(false);
			Parse2.setEnabled(false);
			Parse3.setEnabled(true);

			ReadCVS obj = new ReadCVS();
			ReadCSV2 obj2 = new ReadCSV2();
			DelimitedToXls xls = new DelimitedToXls();
			DelimetedToXls3 xls3 = new DelimetedToXls3();
			try {
				obj.run();
				xls.run();
				obj2.run();
				xls3.run();
				
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FindBad.Findbad();
				System.out.println("asd");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GetData.list.clear();
			GetData2.list.clear();
			GetData3.list.clear();
			ReadCVS.curr_filename.clear();
			ReadCVS.szovi.clear();
			ReadCSV2.curr_filename.clear();
			ReadCSV2.szovi.clear();
			DelimitedToXls.pirositani.clear();
			Open.setEnabled(true);

		}
		if (ev.getSource() == Parse2) {
			Parse.setEnabled(false);
			Parse2.setEnabled(false);

			GetDataFromXls obj = new GetDataFromXls();
			DelimetedToXls2 xls = new DelimetedToXls2();
			try {
				obj.run();
				xls.run();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GetData2e.list.clear();
			GetDataFromXls.curr_filename_web .clear();
			Open.setEnabled(true);

		}
		if (ev.getSource() == Parse3) {
			
			Parse3.setEnabled(true);
			textArea.setText("Open File" + "\n");
			JFileChooser openFile = new JFileChooser();
			openFile.showOpenDialog(null);
			webfileName = openFile.getSelectedFile();
			if (webfileName == null)
			{
				System.out.println("Nincs megnyitva file!");
				return;
			}
						
			XlsxtoCSV.convert();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			XlsxtoCSV.curr_webfilename.clear();
			Parse3.setEnabled(true);
			
		}
		if (ev.getSource() == exitMenuItem) {
			exitMenuItem.setEnabled(true);
			System.exit(0);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
