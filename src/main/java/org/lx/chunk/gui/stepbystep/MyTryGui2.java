package org.lx.chunk.gui.stepbystep;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyTryGui2 {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("try2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//然后加Container,其中JFrame,JPanel都是Container,用来装其他Container或Component,比如下面装了一个menubar
		Container contentPane = new JPanel();
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("file");
		fileMenu.add(new JMenuItem("copy", new ImageIcon(MyTryGui2.class.getResource("Copy-32.png"))));
		fileMenu.add(new JMenuItem("paste", new ImageIcon(MyTryGui2.class.getResource("Paste-32.png"))));
		fileMenu.add(new JMenuItem("cut", new ImageIcon(MyTryGui2.class.getResource("Cut-32.png"))));
		JMenu helpMenu = new JMenu("help");
		helpMenu.add(new JMenuItem("about"));
		bar.add(fileMenu);
		bar.add(helpMenu);
		contentPane.add(bar);
		
		frame.setContentPane(contentPane);
		
		frame.setLocation(200, 100);
		frame.setAlwaysOnTop(true);
		frame.setPreferredSize(new Dimension(400, 300));
		frame.pack();
		
		frame.setVisible(true);
		
		
	}
}
