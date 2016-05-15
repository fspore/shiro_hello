package org.lx.chunk.gui.stepbystep;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MyTryGui1 {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("this is titile");
		//没这一行的话,窗口关闭了,线程也不会关闭！要注意！
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame原点的位置。即左上角顶点的位置
		frame.setLocation(200, 100);
		//规定窗口大小PreferredSize
		frame.setPreferredSize(new Dimension(800, 600));
		//使JFrame这个Window来Fit 上面设好的PreferredSize,没有这个是不生效的。
		frame.pack();
		
		frame.setVisible(true);
		
	}
}
