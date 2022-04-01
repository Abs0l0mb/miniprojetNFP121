import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;

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
      
      LayoutManager flowWest = new GridLayout(3,1);
      JPanel westPanel = new JPanel(flowWest);
      JLabel K = new JLabel("Valeur de l'indice (K)");
      JLabel A = new JLabel("Valeur de alpha (A)");
      JLabel E = new JLabel("Valeur de epsilon (E)");
      westPanel.add(K);
      westPanel.add(A);
      westPanel.add(E);
      
      LayoutManager flowCenter = new GridLayout(3,1);
      JPanel centerPanel = new JPanel(flowCenter);
      JTextField KText = new JTextField("150");
      JTextField AText = new JTextField("0.85");
      JTextField EText = new JTextField("-1");
      centerPanel.add(KText);
      centerPanel.add(AText);
      centerPanel.add(EText);
      
      LayoutManager flowEast = new GridLayout(3,1);
      JPanel eastPanel = new JPanel(flowEast);
      JButton addK = new JButton("+");
      JButton addA = new JButton("+");
      JButton addE = new JButton("+");
      eastPanel.add(addK);
      eastPanel.add(addA);
      eastPanel.add(addE);
      
      LayoutManager flowSouth = new FlowLayout();
      JPanel southPanel = new JPanel(flowSouth);
      JLabel result = new JLabel("utilisez les boutons pour ajouter des options");
      southPanel.add(result);
      
      this.getContentPane().add(northPanel, BorderLayout.NORTH);

      this.getContentPane().add(westPanel, BorderLayout.WEST);
      
      this.getContentPane().add(centerPanel, BorderLayout.CENTER);
      
      this.getContentPane().add(eastPanel, BorderLayout.EAST);
      
      this.getContentPane().add(result, BorderLayout.SOUTH);
      
      addWindowListener(listener);
      setSize(800,400);
      setVisible(true);
   }

   public static void main(String [] args){
      JFrame frame = new PageRankFenetre();
   }
}