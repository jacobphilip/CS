package edu.uwec.cs.stevende.threads;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StopWatch {
	
	private Timer tim;

	public StopWatch() {
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(400, 400));
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		final JLabel display = new JLabel("0");
		p.add(display, BorderLayout.SOUTH);
		
		final JButton start = new JButton("Start");
		p.add(start, BorderLayout.WEST);
		start.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				tim = new Timer(display);
				tim.start();
			}
			
		});
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tim.stop();
			}
			
			
			
		});
		p.add(stop, BorderLayout.EAST);
		
		
	
		
		f.setContentPane(p);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new StopWatch();

	}

}
