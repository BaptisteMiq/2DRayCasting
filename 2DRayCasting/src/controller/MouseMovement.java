package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import model.Ray;
import model.Vector2D;
import view.View2D;

public class MouseMovement implements MouseMotionListener, MouseWheelListener {
	
	View2D panel;
	ArrayList<Ray> rays;
	Double a;
	
	public MouseMovement(View2D panel, ArrayList<Ray> rays) {
		this.panel = panel;
		this.rays = rays;
		this.a = 0.0;
	}
	
	@Override
    public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (Ray ray : rays) {
			ray.setPosition(new Vector2D(e.getPoint().getX(), e.getPoint().getY()));
//			ray.lookAt(new Vector2D(e.getPoint().getX(), e.getPoint().getY()));
		}
		panel.update(rays);
		panel.getView3D().update();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() == -1) {
			for (Ray ray : rays) {
				ray.setAngle(ray.getAngle() - Math.PI/20);
				ray.setDirection(new Vector2D().fromAngle(ray.getAngle(), 1));
			}
		}
		if(e.getWheelRotation() == 1) {
			for (Ray ray : rays) {
				ray.setAngle(ray.getAngle() + Math.PI/20);
				ray.setDirection(new Vector2D().fromAngle(ray.getAngle(), 1));
			}
		}
		panel.update(rays);
		panel.getView3D().update();
	}
}