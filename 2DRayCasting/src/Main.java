import java.util.Random;

import controller.Controller;
import model.Ray;
import model.Vector2D;
import view.View;

public class Main {

	public static void main(String[] args) {
		View view = new View("Test");
		Controller controller = new Controller(view);
		
		controller.addRectangle(new Vector2D(10.0, 10.0), View.WIDTH-40, View.HEIGHT-60);
		controller.addRectangle(new Vector2D(200.0, 200.0), 150, 100);
		
		controller.addRectangle(new Vector2D(200.0, 200.0), 150, 100, 1);
		
		controller.addRectangle(new Vector2D(300.0, 100.0), 50, 50, 2);
		
		Random r = new Random();
//		for (int i = 0; i < 10; i++) {
//			Double rX = (double) r.nextInt(View.WIDTH);
//			Double rY = (double) r.nextInt(View.HEIGHT);
//			controller.addBoundary(new Vector2D(rX, rY), new Vector2D(rX + (double) r.nextInt(100), rY + (double) r.nextInt(100)));
//		}
//		for (int i = 0; i < 80; i++) {
//			Double rX = (double) r.nextInt(View.WIDTH - 200);
//			Double rY = (double) r.nextInt(View.HEIGHT - 200);
//			controller.addRectangle(new Vector2D(rX, rY), r.nextInt(20), r.nextInt(20));
//		}
		
//		controller.addRectangle(new Vector2D(400.0, 400.0), 250, 50);
//		controller.addRectangle(new Vector2D(500.0, 100.0), 50, 100);
		
		for (Double i = -20.0; i < 20.0; i += 0.1) {
			controller.addRay(new Vector2D(400.0, 400.0), Math.toRadians(i));
		}
		for (Ray ray : controller.getRays()) {
			ray.setDirection(new Vector2D().fromAngle(ray.getAngle(), 1));
		}
		
		view.getPanel().update(controller.getBoundaries(), controller.getRays());
	}

}
