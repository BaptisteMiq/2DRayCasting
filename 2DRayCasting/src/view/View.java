package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Boundary;
import model.Ray;

public class View {
	
	static public int WIDTH = 800;
	static public int HEIGHT = 600;
	
	private JFrame frame;
	private JFrame frame3D;
	 
	private ArrayList<Boundary> boundaries = new ArrayList<Boundary>();
	private ArrayList<Ray> rays = new ArrayList<Ray>();
	private View2D panel = new View2D(boundaries, rays);
	private View3D panel3D = new View3D(rays);

	public View(String title) {
		
		panel.add3DView(panel3D);
		
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(View.WIDTH, View.HEIGHT);
		// Fullscreen
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		// frame.setUndecorated(true);	
		frame.add(panel);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);
		
		
		// 3D FRAME
		frame3D = new JFrame(title);
		frame3D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3D.setSize(View.WIDTH - 75, View.HEIGHT);
		frame3D.add(panel3D);

		frame3D.setVisible(true);
		frame3D.setBackground(Color.BLACK);
	}
	
	public View2D getPanel() {
		return this.panel;
	}
	
}
