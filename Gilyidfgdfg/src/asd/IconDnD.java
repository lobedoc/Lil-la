package asd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;


public class IconDnD extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IconDnD() {

        setTitle("Icon Drag & Drop");

        //JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 15));
        JFrame Window = new JFrame("Panda power");
        JPanel Panel2 = new JPanel();
        JPanel pann = new JPanel();
		pann.setLayout(new GridLayout(3, 3, 3, 3));
        Window.setLayout(new BorderLayout());
	    Window.add(pann, BorderLayout.CENTER);
	    Window.add(Panel2, BorderLayout.WEST);
        ImageIcon icon1 = new ImageIcon("tile-0.png");
        ImageIcon icon2 = new ImageIcon("tile-1.png");
        ImageIcon icon3 = new ImageIcon("tile-2.png");
        ImageIcon icon4 = new ImageIcon("");

        JButton button = new JButton(icon2);
        JButton button2 = new JButton(icon2);
        button.setFocusable(false);
        button2.setFocusable(false);

        JLabel label1  = new JLabel(icon1, JLabel.CENTER);
        JLabel label2  = new JLabel(icon3, JLabel.CENTER);
        JLabel label4  = new JLabel(icon4, JLabel.CENTER);

        MouseListener listener = new DragMouseAdapter();
        label1.addMouseListener(listener);
        label4.addMouseListener(listener);

        label1.setTransferHandler(new TransferHandler("icon"));
        button.setTransferHandler(new TransferHandler("icon"));
        button2.setTransferHandler(new TransferHandler("icon"));
        label4.setTransferHandler(new TransferHandler("icon"));

        pann.add(label1);
        pann.add(button);
        pann.add(button2);
        pann.add(label4);
        add(Panel2);
        add(pann);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class DragMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
    }

    public static void main(String[] args) {
        new IconDnD();
    }
}