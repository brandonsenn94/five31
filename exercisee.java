package main;

import java.util.Scanner;

public class exercisee {
	private double maxSquat, maxDL, maxBench, maxOHP;
	private double tSquat, tDL, tBench, tOHP;
	private boolean BBB;
	private String exercise;
	private String name;
	private String month;
	
	
	public exercisee() {
		this.maxSquat=0;
		this.maxDL=0;
		this.maxBench=0;
		this.maxOHP=0;
		this.name="Brandon";
		this.tSquat=0;
		this.tBench=0;
		this.tDL=0;
		this.tOHP=0;
		this.BBB = false;
	}
	
	exercisee(double maxSquat, double maxDL, double maxBench, double maxOHP, String name) {
		super();
		this.maxSquat = maxSquat;
		this.maxDL = maxDL;
		this.maxBench = maxBench;
		this.maxOHP = maxOHP;
		this.name = name;
	}
	
	
	public double getMaxSquat() {
		return maxSquat;
	}
	
	public double getMaxDL() {
		return maxDL;
	}
	
	public double getMaxBench() {
		return maxBench;
	}
	
	public double getMaxOHP() {
		return maxOHP;
	}
	
	public String getName() {
		return name;
	}
	
	public double getTSquat() {
		return tSquat;
	}
	
	public double getTBench() {
		return tBench;
	}
	
	public double getTDL() {
		return tDL;
	}
	
	public double getTOHP() {
		return tOHP;
	}
	
	public boolean getBBB() {
		return BBB;
	}
	
	public void setBBB(boolean BBB) {
		this.BBB = BBB;
	}
	
	public void setMaxSquat(double maxSquat) {
		this.maxSquat = maxSquat;
	}
	
	public void setMaxDL(double maxDL) {
		this.maxDL = maxDL;
	}
	
	public void setMaxBench(double maxBench) {
		this.maxBench = maxBench;
	}
	
	public void setMaxOHP(double maxOHP) {
		this.maxOHP = maxOHP;
	}
	
	public void setTrainingSquat(double tSquat) {
		this.tSquat = tSquat;
	}
	
	public void setTrainingBench(double tBench) {
		this.tBench = tBench;
	}
	
	public void setTrainingDL(double tDL) {
		this.tDL = tDL;
	}
	
	public void setTrainingOHP(double tOHP) {
		this.tOHP = tOHP;
	}
	public void setName(String a) {
		this.name = a;
	}
	
}
