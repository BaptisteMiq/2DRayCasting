package model;

public class Vector2D {
	private Double x;
	private Double y;

	public Vector2D() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public Vector2D(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D(Double x, Double y, double angle) {
		this.x = x;
		this.y = y;
	}

	public void setVector(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getMagnitude() {
		return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY());
	}

	public Vector2D getNormalize() {
		return new Vector2D(this.getX() / this.getMagnitude(), this.getY() / this.getMagnitude());
	}

	public Double getDist(Vector2D dest) {
		return Math.sqrt(Math.pow((dest.getX() - this.getX()), 2) + Math.pow((dest.getY() - this.getY()), 2));
	}

	public Vector2D fromAngle(double angle, int length) {
		this.setX(length * Math.cos(angle));
		this.setY(length * Math.sin(angle));
		return this;
	}
	
	public Double heading() {
		return Math.atan2(this.getX(), this.getY());
	}
}
