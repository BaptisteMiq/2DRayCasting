package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import controller.InputSystem;
import controller.MouseMovement;
import model.Boundary;
import model.Ray;
import model.Vector2D;

public class View2D extends JPanel {

	ArrayList<Boundary> boundaries;
	ArrayList<Ray> rays;
	private View3D view3D;
	public Double angle;
	private static int VIEW_DISTANCE = 1000;
	int timeElapsed = 0;

	private static final long serialVersionUID = 1L;

	View2D(ArrayList<Boundary> boundaries, ArrayList<Ray> rays) {
		this.boundaries = boundaries;
		this.rays = rays;
		this.angle = 0.1;
		addMouseMotionListener(new MouseMovement(this, rays));
		addMouseWheelListener(new MouseMovement(this, rays));
		addKeyListener(new InputSystem(this, rays));
		this.timeElapsed = 0;
	}

	public void add3DView(View3D v3D) {
		this.view3D = v3D;
	}

	public void update(ArrayList<Boundary> boundaries, ArrayList<Ray> rays) {
		this.boundaries = boundaries;
		this.rays = rays;
		this.repaint();
	}

	public void update(ArrayList<Ray> rays) {
		this.rays = rays;
		this.repaint();
	}

	public View3D getView3D() {
		return view3D;
	}

	public void update() {
		this.repaint();
	}

	public void update3D() {
		this.view3D.update();
	}

	public void paint(Graphics g) {

		// Add elements only one time
		if (this.timeElapsed == 0) {
			addMouseMotionListener(new MouseMovement(this, rays));
			addMouseWheelListener(new MouseMovement(this, rays));
			addKeyListener(new InputSystem(this, rays));
		}
		this.timeElapsed++;

		setBackground(Color.BLACK);
		paintComponent(g);
		g.setColor(new Color(255, 255, 255, 255));

		for (Boundary boundary : boundaries) {
			g.drawLine((int) Math.floor(boundary.getV1().getX()), (int) Math.floor(boundary.getV1().getY()),
					(int) Math.floor(boundary.getV2().getX()), (int) Math.floor(boundary.getV2().getY()));
		}
		view3D.getScene().clear();
		view3D.getSceneColor().clear();
		int indRay = 0;
		for (Ray ray : rays) {

			Vector2D closest = null;
			Double record = 1e9;
			for (Boundary boundary : boundaries) {
				Vector2D castPoint = ray.cast(boundary);
				if (castPoint != null) {

					g.setColor(new Color(255, 255, 255, 255));
					if (boundary.getType() == 1) {
						g.setColor(new Color(255, 100, 100, 255));
					}
					if (boundary.getType() == 2) {
						g.setColor(new Color(100, 100, 255, 255));
					}

					Double dist = ray.getPosition().getDist(castPoint);
					if (dist <= VIEW_DISTANCE) {
						if (dist < record) {
							record = dist;
							closest = castPoint;
						}
					} else {
//						closest = new Vector2D(ray.getPosition().getX() + ray.getDirection().getX() * VIEW_DISTANCE,
//								ray.getPosition().getY() + ray.getDirection().getY() * VIEW_DISTANCE);
					}
				}
			}

			if (closest != null) {
				g.drawLine((int) Math.floor(ray.getPosition().getX()), (int) Math.floor(ray.getPosition().getY()),
						(int) Math.floor(closest.getX()), (int) Math.floor(closest.getY()));
			}

			Double a = ray.getDirection().heading() - Controller.getCenterRay(rays).getDirection().heading();
			view3D.getScene().add((int) Math.floor(record * Math.cos(a)));
			view3D.getSceneColor().add(g.getColor());

			indRay++;
		}

	}

}