package Project3_Which_Data_Structure_is_Better;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bar211 {

	 final int W=950,H=800;//width and height of JFrame
	 private JFrame f; 
	 private JPanel p;
	 
	 private JLabel lab0,lab1, lab2, lab3;  // [Add] [Search] [Remove]
	 
	 private JLabel tests;  // no of test data
	 
	 private JButton barAddAL, barSearchAL, barRemoveAL;  
	 private JButton barAddLL, barSearchLL, barRemoveLL;  
	 
	 private JLabel arrayAddLabel, arraySearchLabel, arrayRemoveLabel;  // ArrayList 
	 private JLabel linkedAddLabel, linkedSearchLabel, linkedRemoveLabel; // LinkedList
	 
	 private JLabel lTadd, lTSearch, lTremove;
  
	 private String iam;  // my name
	 private int scale=30; // bar scale   1/n
	 
	 static int howManyTests;
	  
	 Color colorBackGround = new Color(244, 175, 27);
	 Color colorTitle = new Color(0,21,79); 
	 Color colorBarArrayList = new Color (255,117,0);
	 Color colorBarLinkedList = new Color (0,21,79);

	  String mainTitle ="ArrayList vs LinkedList"; 

	  private double timeAddAL;
	  private double timeAddLL;
	  private double timeSearchAL;
	  private double timeSearchLL;
	  private double timeRemoveAL;
	  private double timeRemoveLL;
	  	  
	 public Bar211(String yourName, int howManyTests) {  // constructor
	 
		 this.iam=yourName;
		 this.howManyTests = howManyTests;
		 
		 f=new JFrame(" ArrayList vs LinkedList. CS 211, Spring 2023"); 
		 f.setSize(W, H);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 p=new JPanel() {
			 
			 public void paintComponent(Graphics g){
			        super.paintComponent(g);
			        setBackground(colorBackGround);
			        
			        g.setFont( new Font( "Serif", Font.PLAIN, 20 ));
			        g.drawString(iam, 750,740);		        
			        g.fillRect(100, 630, 720, 2);
			        	        
			        updateBar(g); 
			     //    try{
				 //        Thread.sleep(10);  // 1000 = 1 second
				 //     } catch (Exception exc){}
			       
			        repaint();
			 }	 			 	 
		 };
		 		
		 p.setLayout(null);		
		 lab0 = new JLabel(mainTitle);	//title on page
		 lab0.setBounds(W*3/9,40,W-20,H/6);
		 lab0.setForeground(colorTitle);
		 lab0.setFont(new Font("Serif", Font.BOLD, 35));

		 tests = new JLabel("(Test data: "+howManyTests + ")");
		 tests.setBounds(W*3/7,70,W-20,H/6);
		 tests.setFont(new Font("Serif", Font.PLAIN, 20));
		 
		 f.add(p);
		 p.add(lab0);
		 p.add(tests);
		 f.setVisible(true);
		 
		String[] barTitle = new String[] {
				 "[Add]",
				 "[Search]",
				 "[Remove]",
		 };
		
		
		 //add	
		
		 //labeling each set of bars with their method - add
		 lab1 = new JLabel(barTitle[0]);
		 lab1.setBounds(170+(200*0),640, 300,100);
		 lab1.setFont(new Font("Serif", Font.PLAIN, 30));
		 lab1.setMinimumSize(new Dimension(100,100));

		 //label for arraylist - add
		 arrayAddLabel = new JLabel("ArrayList");
		 arrayAddLabel.setBounds(130+(200*0),600, 70,100);
		 arrayAddLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		 arrayAddLabel.setMinimumSize(new Dimension(100,100));	
		 
		 //bar for arraylist - add
		 barAddAL=new JButton(""); 
		 barAddAL.setBackground(colorBarArrayList);
		 barAddAL.setFont(new Font("Serif", Font.PLAIN, 30));
		 barAddAL.setOpaque(true);
		 barAddAL.setBorderPainted(false);
		 	 
		 //label for linked - add
		 linkedAddLabel = new JLabel("LinkedList");
	 	 linkedAddLabel.setBounds(230+(200*0),600, 70,100);
	 	 linkedAddLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		 linkedAddLabel.setMinimumSize(new Dimension(100,100));
		 
		 //bar for linked - add
		 barAddLL=new JButton(""); 
		 barAddLL.setBackground(colorBarLinkedList);
		 barAddLL.setFont(new Font("Serif", Font.PLAIN, 15));
		 barAddLL.setOpaque(true);
		 barAddLL.setBorderPainted(false);
		 	 
		 //search()				 
		 //labeling each set of bars with their method - search
		 lab2 = new JLabel(barTitle[1]);
		 lab2.setBounds(200+(200*1),640, 300,100);
		 lab2.setFont(new Font("Serif", Font.PLAIN, 30));
		 lab2.setMinimumSize(new Dimension(100,100));
		 
		 //label for arraylist - search
		 arraySearchLabel = new JLabel("ArrayList");
		 arraySearchLabel.setBounds(170+(200*1),600, 70,100);
		 arraySearchLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		 arraySearchLabel.setMinimumSize(new Dimension(100,100));		
		 
		 //bar for arraylist - search
		 barSearchAL=new JButton(""); 
		 barSearchAL.setBackground(colorBarArrayList);
		 barSearchAL.setFont(new Font("Serif", Font.PLAIN, 30));
		 barSearchAL.setOpaque(true);
		 barSearchAL.setBorderPainted(false);
		 
		 
		 //label for linked - search
		 linkedSearchLabel = new JLabel("LinkedList");
	 	 linkedSearchLabel.setBounds(270+(200*1),600, 70,100);
	 	 linkedSearchLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		 linkedSearchLabel.setMinimumSize(new Dimension(100,100));		
		 
		 //bar for linked - search
		 barSearchLL=new JButton(""); 
		 barSearchLL.setBackground(colorBarLinkedList);
		 barSearchLL.setFont(new Font("Serif", Font.PLAIN, 10));
		 barSearchLL.setOpaque(true);	
		 barSearchLL.setBorderPainted(false);
		 
		 //remove
		 
		 //labeling each set of bars with their method - remove
		 lab3 = new JLabel(barTitle[2]);
		 lab3.setBounds(220+(200*2),640, 300,100);
		 lab3.setFont(new Font("Serif", Font.PLAIN, 30));
		 lab3.setMinimumSize(new Dimension(100,100));
		 
		//label for arraylist - remove
		 arrayRemoveLabel = new JLabel("ArrayList");
		 arrayRemoveLabel.setBounds(210+(200*2),600, 70,100);
		 arrayRemoveLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		 arrayRemoveLabel.setMinimumSize(new Dimension(100,100));
		 
		 //bar for arraylist - remove
		 barRemoveAL=new JButton("");  
		 barRemoveAL.setBackground(colorBarArrayList);
		 barRemoveAL.setFont(new Font("Serif", Font.PLAIN, 30));
		 barRemoveAL.setOpaque(true);
		 barRemoveAL.setBorderPainted(false);
		  
		 //label for linked - remove
		 linkedRemoveLabel = new JLabel("LinkedList");
	 	 linkedRemoveLabel.setBounds(310+(200*2),600, 70,100);
	 	 linkedRemoveLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		 linkedRemoveLabel.setMinimumSize(new Dimension(100,100));
		 
		 //bar for linked - remove
		 barRemoveLL=new JButton(""); 
		 barRemoveLL.setBackground(colorBarLinkedList);
		 barRemoveLL.setFont(new Font("Serif", Font.PLAIN, 15));
		 barRemoveLL.setOpaque(true);
		 barRemoveLL.setBorderPainted(false);
		 
		 
		 p.add(lab1);
		 p.add(lab2);
		 p.add(lab3);
		 
		 
		 p.add(arrayAddLabel);
		 p.add(arraySearchLabel);
		 p.add(arrayRemoveLabel);
		 p.add(linkedAddLabel);
		 p.add(linkedSearchLabel);
		 p.add(linkedRemoveLabel);	 
		 
		 p.add(barAddAL);
		 p.add(barSearchAL);
		 p.add(barRemoveAL);
		 p.add(barAddLL);
		 p.add(barSearchLL);
		 p.add(barRemoveLL);
 }

	 public void setTimeAddAL(double t) {
		 this.timeAddAL=t;
	 }
	 
	 public void setTimeAddLL(double t) {
		 this.timeAddLL=t;
	 }
	 
	 public void setTimeSearchAL(double t) {
		 this.timeSearchAL=t;
	 }
	 
	 public void setTimeSearchLL(double t) {
		 this.timeSearchLL=t;
	 }
	 
	 public void setTimeRemoveAL(double t) {
		 this.timeRemoveAL=t;
	 }
	 
	 public void setTimeRemoveLL(double t) {
		 this.timeRemoveLL=t;
	 }
	 
	 
	 public void updateBar(Graphics g){ 
		 
		 int tAA=(int)(timeAddAL/scale);   // scale
//		 int sizeCoefficient = (int) (H/timeAddAL);
		 barAddAL.setBounds(130+(200*0), (630-tAA),70,tAA);
		
		 if (timeAddAL>0) {
		   g.setFont( new Font( "Serif", Font.PLAIN, 16 ));
		   g.drawString((timeAddAL/1000.0) + " sec", 130+(200*0)+10,630-tAA-10);
		 }
		 
		 int tLA=(int)timeAddLL/scale;	 
		 barAddLL.setBounds(230+(200*0), (630-tLA),70,tLA);
		
		 if (timeAddLL>0) {
		   g.setFont( new Font( "Serif", Font.PLAIN, 16 ));
		   g.drawString((timeAddLL/1000.0) + " sec", 230+(200*0)+10,630-tLA-10);
		 }
		 	 	 
		 int tAG=(int)(timeSearchAL/scale);   // scale	 
		 barSearchAL.setBounds(170+(200*1), 630-tAG,70,tAG); 
		 
		 if (timeSearchAL>0) {
		   g.drawString((timeSearchAL/1000.0) + " sec", 170+(200*1)+10,630-tAG-10);
		 }
		 
		 int tLG=(int)timeSearchLL/scale;	 
		 barSearchLL.setBounds(270+(200*1), 630-tLG,70,tLG); 
		 if (timeSearchLL>0) {
		   g.drawString((timeSearchLL/1000.0) + " sec", 270+(200*1)+10,630-tLG-10);
		 }
		 
		 int tAR=(int)(timeRemoveAL/scale);   // scale	 
		 barRemoveAL.setBounds(210+(200*2), 630-tAR,70,tAR); 
		 if (timeRemoveAL>0) {
		   g.drawString((timeRemoveAL/1000.0) + " sec", 210+(200*2)+10,630-tAR-10);
		 }
		 
		 int tLR=(int)timeRemoveLL/scale;	 
		 barRemoveLL.setBounds(310+(200*2), 630-tLR,70,tLR); 
		 if (timeRemoveLL>0) {
		   g.drawString((timeRemoveLL/1000.0) + " sec", 310+(200*2)+10,630-tLR-10);
		 }	 
	  }
}

