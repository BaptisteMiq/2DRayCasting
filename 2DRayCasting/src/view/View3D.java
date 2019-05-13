package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Controller;
import model.Map;
import model.Ray;

public class View3D extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> scene;
	private ArrayList<Color> sceneColor;

	public ArrayList<Color> getSceneAngle() {
		return sceneColor;
	}

	public void setSceneAngle(ArrayList<Color> sceneColor) {
		this.sceneColor = sceneColor;
	}

	ArrayList<Ray> rays;

	public ArrayList<Integer> getScene() {
		return scene;
	}

	public void setScene(ArrayList<Integer> scene) {
		this.scene = scene;
	}

	View3D(ArrayList<Ray> rays) {
		this.scene = new ArrayList<Integer>();
		this.sceneColor = new ArrayList<Color>();
		this.rays = rays;
	}

	public void update() {
		this.repaint();
	}

	public void paint(Graphics g) {

		setBackground(Color.BLACK);
		paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, View.HEIGHT, new Color(0, 200, 0), 0, View.HEIGHT - 150,
				new Color(0, 100, 0));
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, View.WIDTH, View.HEIGHT);

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, View.WIDTH, View.HEIGHT - 200);

		if (scene.size() == 0)
			return;

		Integer w = Math.round(View.WIDTH / scene.size());

		for (int i = 0; i < scene.size(); i++) {

			int colorFromDepth = (int) Math
					.round(new Map().mapDouble((double) scene.get(i), 0.0, (double) View.WIDTH, 255.0, 0.0));
			if (colorFromDepth < 0)
				colorFromDepth = 0;
			if (colorFromDepth > 255)
				colorFromDepth = 255;

			Double d = (double) scene.get(i) / View.WIDTH;
			Integer h = (int) Math.round(60 / d); // No mapping

//			g.setColor(this.getSceneColor().get(i));
			g.setColor(new Color(colorFromDepth, colorFromDepth, colorFromDepth));
			g.fillRect(i * w + w / 2, View.WIDTH / 2 - h / 2, w, h);

		}
	}

	public ArrayList<Color> getSceneColor() {
		return sceneColor;
	}

	public void setSceneColor(ArrayList<Color> sceneColor) {
		this.sceneColor = sceneColor;
	}

}