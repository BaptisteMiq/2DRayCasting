package model;

public class Ray {
	Vector2D position;
	Vector2D direction;
	Double angle;

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public Vector2D getDirection() {
		return direction;
	}

	public void setDirection(Vector2D direction) {
		this.direction = direction;
	}

	public Ray(Vector2D position, Vector2D direction) {
		this.position = position;
		this.direction = direction;
	}

	public Ray(Vector2D position, Vector2D direction, Double angle) {
		this.position = position;
		this.direction = direction;
		this.angle = angle;
	}

	public Ray(Vector2D position, Double angle) {
		this.position = position;
		this.angle = angle;
		this.direction = new Vector2D(0.0, 0.0);
	}

	public void lookAt(Vector2D pos) {
		this.setDirection(new Vector2D(pos.getX() - this.getPosition().getX(), pos.getY() - this.getPosition().getY()));
		this.setDirection(this.getDirection().getNormalize());
	}

	public Vector2D cast(Boundary boundary) {
		Double x1 = boundary.getV1().getX();
		Double y1 = boundary.getV1().getY();
		Double x2 = boundary.getV2().getX();
		Double y2 = boundary.getV2().getY();

		Double x3 = this.getPosition().getX();
		Double y3 = this.getPosition().getY();
		Double x4 = this.getPosition().getX() + this.getDirection().getX();
		Double y4 = this.getPosition().getY() + this.getDirection().getY();

		Double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
		if (denominator == 0) {
			return null;
		}

		Double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / denominator;
		Double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / denominator;

		if (t > 0 && t < 1 && u > 0) {
			return new Vector2D(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
		} else {
			return null;
		}
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(Double a) {
		this.angle = a;
		this.angle = this.angle % (2 * Math.PI);
	}

	public void updateAngle() {
		this.angle = Math.atan2(this.getDirection().getX(), this.getDirection().getY());
	}

	public void changeAngle(Double angle) {
		Double newAngle = Math.toRadians(this.getAngle()) + 0.1;
		this.setDirection(new Vector2D().fromAngle(newAngle, 1));
		this.angle = newAngle % 360;
	}

}
