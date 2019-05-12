package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.KeyStroke;

import model.Ray;
import model.Vector2D;
import view.View2D;

public class InputSystem extends KeyAdapter {
	View2D panel;
	ArrayList<Ray> rays;

	@Override
	public void keyPressed(KeyEvent e) {
		if (rays.size() < 1)
			return;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for (Ray ray : rays) {
				ray.setAngle(ray.getAngle() + Math.PI/40);
				ray.setDirection(new Vector2D().fromAngle(ray.getAngle(), 1));
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			for (Ray ray : rays) {
				ray.setAngle(ray.getAngle() - Math.PI/40);
				ray.setDirection(new Vector2D().fromAngle(ray.getAngle(), 1));
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			for (Ray ray : rays) {
				ray.setPosition(new Vector2D(
						Controller.getCenterRay(rays).getPosition().getX() + Controller.getCenterRay(rays).getDirection().getX() * 2,
						Controller.getCenterRay(rays).getPosition().getY() + Controller.getCenterRay(rays).getDirection().getY() * 2));
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			for (Ray ray : rays) {
				ray.setPosition(new Vector2D(
						Controller.getCenterRay(rays).getPosition().getX() - Controller.getCenterRay(rays).getDirection().getX() * 2,
						Controller.getCenterRay(rays).getPosition().getY() - Controller.getCenterRay(rays).getDirection().getY() * 2));
			}
		}
		panel.update(rays);
		panel.update3D();
	}

	public InputSystem(View2D panel, ArrayList<Ray> rays) {
		this.panel = panel;
		this.rays = rays;

		this.panel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Right");
		this.panel.getActionMap().put("Right", null);
	}

}
