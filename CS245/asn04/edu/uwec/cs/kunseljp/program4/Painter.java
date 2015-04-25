
package edu.uwec.cs.kunseljp.program4;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Painter extends JFrame {

	public static JPanel content;
	protected Color c = Color.BLACK;
	protected String type;
	protected static String username;
	protected static JTextArea textField;
	public static PaintingPanel middle = null;

	// Connection
	public static Socket s;
	private static String address = "127.0.0.1";
	private static int port = 1337;

	public Painter() {

		// try to connect to the server
		try {
			s = new Socket(address, port);

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(Painter.content, "Unable to connect to server " + address
					+ " on port " + port + ".", "Connection Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(Painter.content, "Unable to connect to server " + address
					+ " on port " + port + ".", "Connection Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		// Painter GUI Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(400, 400));
		setResizable(true);
		setTitle("Painter");
		JPanel overlay = new JPanel();
		overlay.setLayout(new BorderLayout());
		setContentPane(overlay);

		// center panel
		content = new JPanel();
		content.setLayout(new BorderLayout());
		overlay.add(content, BorderLayout.CENTER);

		// top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3)); // 3 x 1

		// left panel
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1)); // 1 x 3

		// RED button
		JButton redPaint = new JButton("Red");
		redPaint.setForeground(Color.RED);
		leftPanel.add(redPaint);
		redPaint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				c = Color.red;
			}

		});

		// GREEN button
		JButton greenPaint = new JButton("Green");
		greenPaint.setForeground(Color.GREEN);
		leftPanel.add(greenPaint);
		greenPaint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				c = Color.green;
			}

		});

		// BLUE button
		JButton bluePaint = new JButton("Blue");
		bluePaint.setForeground(Color.BLUE);
		leftPanel.add(bluePaint);
		bluePaint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				c = Color.blue;
			}

		});

		// Rectangle button
		JButton rect = new JButton("Rectangle");
		topPanel.add(rect);
		rect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				type = "rect";
			}

		});

		// Circle button
		JButton circle = new JButton("Circle");
		topPanel.add(circle);
		circle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				type = "circle";
			}

		});

		// Line button
		JButton line = new JButton("Line");
		topPanel.add(line);
		line.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				type = "line";
			}

		});

		// Add each panel to the whole panel
		content.add(topPanel, BorderLayout.NORTH);
		content.add(leftPanel, BorderLayout.WEST);
		middle = new PaintingPanel();
		content.add(middle, BorderLayout.CENTER);

		middle.addMouseListener(new MouseListener() {

			private Point p1;
			private Point p2;

			public void mouseClicked(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}

			// creates a temporary shape on the painting panel
			public void mousePressed(MouseEvent e) {
				this.p1 = e.getPoint();
				middle.addMouseMotionListener(new MouseMotionListener() {

					private Point p2;

					public void mouseDragged(MouseEvent e) {
						try {
							this.p2 = e.getPoint();
							PaintingPrimitive l = null;
							if (type.equals("line")) {
								l = new Line(c, p1, p2);
							} else if (type.equals("circle")) {
								l = new Circle(c, p1, p2);
							} else if (type.equals("rect")) {
								l = new Rectangle(c, p1, p2);
							}
							middle.addTempPrimitive(l);
						} catch (Exception err) {
							System.out.println("error");
						}
					}

					public void mouseMoved(MouseEvent e) {

					}

				});
			}

			// Creates a new shape and then sends it to the server.
			public void mouseReleased(MouseEvent e) {
				try {
					this.p2 = e.getPoint();
					PaintingPrimitive l = null;
					if (type.equals("line")) {
						l = new Line(c, p1, p2);
					} else if (type.equals("circle")) {
						l = new Circle(c, p1, p2);
					} else if (type.equals("rect")) {
						l = new Rectangle(c, p1, p2);
					}
					middle.addPrimitive(l);

					try {
						OutputStream os = s.getOutputStream();
						ObjectOutputStream oos = new ObjectOutputStream(os);
						oos.writeObject(l);

					} catch (UnknownHostException eh) {
						JOptionPane
								.showMessageDialog(Painter.content, "Unable to connect to server "
										+ address + " on port " + port + ".", "Connection Error",
										JOptionPane.ERROR_MESSAGE);
						System.exit(1);
					} catch (IOException ee) {
						JOptionPane
								.showMessageDialog(Painter.content, "Unable to connect to server "
										+ address + " on port " + port + ".", "Connection Error",
										JOptionPane.ERROR_MESSAGE);
						System.exit(1);
					}
				} catch (Exception err) {
					System.out.println("error");
				}
			}

		});

		// panel for the chat window
		JPanel chatPanel = new JPanel();
		chatPanel.setLayout(new BorderLayout());

		// Chat Window
		JPanel chatBox = new JPanel();
		chatBox.setLayout(new BorderLayout(2, 1));
		content.add(chatBox, BorderLayout.SOUTH);

		JPanel chatContent = new JPanel();
		chatContent.setLayout(new GridLayout(1, 2));
		chatBox.add(chatContent, BorderLayout.SOUTH);

		final JTextField tb1 = new JTextField();
		chatContent.add(tb1);

		// scrolling chat box
		textField = new JTextArea();
		final JScrollPane scroller = new JScrollPane(textField);
		textField.setRows(6);
		textField.setEditable(false);
		chatBox.add(scroller, BorderLayout.CENTER);

		// send button.
		JButton chatSub = new JButton("Send");
		chatSub.setDefaultCapable(true);
		chatSub.addActionListener(new ActionListener() {

			// generate chat data when the send button is pressed
			public void actionPerformed(ActionEvent arg0) {
				if (!tb1.getText().equals("")) {
					ChatData cd = new ChatData(username, tb1.getText());

					// Send the data to the server
					try {
						OutputStream os = s.getOutputStream();
						ObjectOutputStream oos = new ObjectOutputStream(os);
						tb1.setText("");
						oos.writeObject(cd);

					} catch (UnknownHostException e) {
						JOptionPane
								.showMessageDialog(Painter.content, "Unable to connect to server "
										+ address + " on port " + port + ".", "Connection Error",
										JOptionPane.ERROR_MESSAGE);
						System.exit(1);
					} catch (IOException e) {
						JOptionPane
								.showMessageDialog(Painter.content, "Unable to connect to server "
										+ address + " on port " + port + ".", "Connection Error",
										JOptionPane.ERROR_MESSAGE);
						System.exit(1);
					}

				}
			}
		});
		chatContent.add(chatSub);

		// allows the send button to work when return is pressed
		getRootPane().setDefaultButton(chatSub);

		// Makes the window visible
		setVisible(true);

		// prompts for username
		fetchUsername();

		// have the painter communicate with the server
		try {
			// a thread that listens for the server
			getUsers gu = new getUsers(s);
			Thread inSt = new Thread(gu);
			inSt.start();

			// Sends username to the server.
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(username);

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(Painter.content, "Unable to connect to server " + address
					+ " on port " + port + ".", "Connection Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(Painter.content, "Unable to connect to server " + address
					+ " on port " + port + ".", "Connection Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	// gets username
	public void fetchUsername() {
		username = "";
		try {
			while (username.equals("") || username.equals(null)) {

				username = JOptionPane.showInputDialog(content, "Please enter a username.");

			}
		} catch (NullPointerException e) {
			System.exit(1);
		}
		setTitle("Painter - Connected as " + username);
	}

	public synchronized static void fillUsers(ArrayList<String> list) {

	}

	// fills chat area with chat history
	public synchronized static void fillChat(ArrayList<ChatData> list) {
		String text = "";
		for (int i = 0; i < list.size(); i++) {
			text += list.get(i).getUsername() + ": " + list.get(i).getMessage() + "\n";
		}
		textField.setText(text);
		textField.setCaretPosition(textField.getDocument().getLength());
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Painter window = new Painter();
	}

}
