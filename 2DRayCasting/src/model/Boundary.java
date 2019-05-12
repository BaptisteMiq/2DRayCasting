package model;

public class Boundary {
	Vector2D v1;
	Vector2D v2;
	int type;
	
	public Boundary(Vector2D v1, Vector2D v2) {
		this.v1 = v1;
		this.v2 = v2;
		this.type = 0;
	}
	
	public Boundary(Vector2D v1, Vector2D v2, int type) {
		this.v1 = v1;
		this.v2 = v2;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Vector2D getV1() {
		return v1;
	}

	public void setV1(Vector2D v1) {
		this.v1 = v1;
	}

	public Vector2D getV2() {
		return v2;
	}

	public void setV2(Vector2D v2) {
		this.v2 = v2;
	}
}
