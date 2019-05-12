package controller;

import java.util.ArrayList;

import model.Boundary;
import model.Ray;
import model.Vector2D;
import view.View;

public class Controller {
	
	private ArrayList<Boundary> boundaries;
	private ArrayList<Ray> rays;
	private View view;
	private MouseMovement mouse;
	
	public Controller(View view) {
		this.boundaries = new ArrayList<Boundary>();
		this.rays = new ArrayList<Ray>();
		this.view = view;
	}
	
	public ArrayList<Boundary> getBoundaries() {
		return boundaries;
	}

	public void addBoundary(Vector2D v1, Vector2D v2) {
		boundaries.add(new Boundary(v1, v2));
	}
	
	public void addRay(Vector2D pos, Vector2D dir) {
		rays.add(new Ray(pos, dir));
	}
	
	public void addRay(Vector2D pos, Vector2D dir, Double angle) {
		rays.add(new Ray(pos, dir, angle));
	}
	
	public void addRay(Vector2D pos, Double angle) {
		rays.add(new Ray(pos, angle));
	}
	
	public ArrayList<Ray> getRays() {
		return rays;
	}
	
	public static Ray getCenterRay(ArrayList<Ray> rays) {
		if(rays.size() < 1) return null;
		return rays.get(Math.round(rays.size()/2));
	}
	
	public void addRectangle(Vector2D pos, int width, int height) {
		boundaries.add(new Boundary(new Vector2D(pos.getX(), pos.getY()), new Vector2D(pos.getX(), pos.getY() + height)));
		boundaries.add(new Boundary(new Vector2D(pos.getX(), pos.getY()), new Vector2D(pos.getX() + width, pos.getY())));
		boundaries.add(new Boundary(new Vector2D(pos.getX() + width, pos.getY() + height), new Vector2D(pos.getX(), pos.getY() + height)));
		boundaries.add(new Boundary(new Vector2D(pos.getX() + width, pos.getY() + height), new Vector2D(pos.getX() + width, pos.getY())));
	}
	
	public void addRectangle(Vector2D pos, int width, int height, int type) {
		boundaries.add(new Boundary(new Vector2D(pos.getX(), pos.getY()), new Vector2D(pos.getX(), pos.getY() + height), type));
		boundaries.add(new Boundary(new Vector2D(pos.getX(), pos.getY()), new Vector2D(pos.getX() + width, pos.getY()), type));
		boundaries.add(new Boundary(new Vector2D(pos.getX() + width, pos.getY() + height), new Vector2D(pos.getX(), pos.getY() + height), type));
		boundaries.add(new Boundary(new Vector2D(pos.getX() + width, pos.getY() + height), new Vector2D(pos.getX() + width, pos.getY()), type));
	}
		
}
