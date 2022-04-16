import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;

@SuppressWarnings("serial")
public class PageRankFenetre extends JFrame {

   public PageRankFenetre() {
      
      super("IHM pour CLI");

      WindowListener listener = new WindowAdapter() {
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      };

      LayoutManager flowNorth = new FlowLayout();
      JPanel northPanel = new JPanel(flowNorth);

      JButton creuse = new JButton("CREUSE");
      JButton pleine = new JButton("PLEINE");

      northPanel.add(creuse);
      northPanel.add(pleine);
      
      LayoutManager gridCenter = new GridLayout(3,3);
      JPanel centerPanel = new JPanel(gridCenter);

      JLabel K = new JLabel("Valeur de l'indice (K)");
      JLabel A = new JLabel("Valeur de alpha (A)");
      JLabel E = new JLabel("Valeur de epsilon (E)");
      
      JTextField KText = new JTextField("150");
      JTextField AText = new JTextField("0.85");
      JTextField EText = new JTextField("-1");
      
      JButton addK = new JButton("+");
      JButton addA = new JButton("+");
      JButton addE = new JButton("+");
      
      centerPanel.add(K);
      centerPanel.add(KText);
      centerPanel.add(addK);

      centerPanel.add(A);
      centerPanel.add(AText);
      centerPanel.add(addA);

      centerPanel.add(E);
      centerPanel.add(EText);
      centerPanel.add(addE);
      
      LayoutManager flowSouth = new FlowLayout();
      JPanel southPanel = new JPanel(flowSouth);

      JTextField result = new JTextField();

      southPanel.add(result);
      
      this.getContentPane().add(northPanel, BorderLayout.NORTH);
      this.getContentPane().add(centerPanel, BorderLayout.CENTER); 
      this.getContentPane().add(result, BorderLayout.SOUTH);
      
      creuse.addActionListener(new ActionListener () { 
		@Override
		public void actionPerformed(ActionEvent e) {
			addCPress(result);
		}
      });
      
      pleine.addActionListener(new ActionListener () { 
		@Override
		public void actionPerformed(ActionEvent e) {
			addPPress(result);
		}
      });
      
      addK.addActionListener(new ActionListener () { 
		@Override
		public void actionPerformed(ActionEvent e) {
			addKPress(KText, result);
		}
      });
      
      addA.addActionListener(new ActionListener () { 
		@Override
		public void actionPerformed(ActionEvent e) {
			addAPress(AText, result);
		}
      });
      
      addE.addActionListener(new ActionListener () { 
		@Override
		public void actionPerformed(ActionEvent e) {
			addEPress(EText, result);
		}
      });
      
      addWindowListener(listener);
      setSize(800,400);
      setVisible(true);
      
   }
   
   public void addPPress(JTextField result) {
	   result.setText(result.getText() + " -P ");
   }
   
   public void addCPress(JTextField result) {
	   result.setText(result.getText() + " -C ");
   }
   
   public void addKPress(JTextField KText, JTextField result) {
	   result.setText(result.getText() + " -K " + KText.getText());
   }
   
   public void addAPress(JTextField AText, JTextField result) {
	   result.setText(result.getText() + " -A " + AText.getText());
   }
   
   public void addEPress(JTextField EText, JTextField result) {
	   result.setText(result.getText() + " -E " + EText.getText());
   }

   public static void main(String [] args){
      JFrame frame = new PageRankFenetre();
   }
}