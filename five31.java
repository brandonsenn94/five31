package main;
import java.util.Scanner;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
/**
 * @author Brandon
 *
 */
public class Five31 {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double squat = 0, bench = 0, dl = 0, ohp = 0;
		double week1[] = {.65, .75, .85};
		double week2[] = {.70, .80, .90};
		double week3[] = {.75, .85, .95};
		double week4[] = {.40, .50, .60};
		welcome();
		Scanner input = new Scanner(System.in);
		exercisee a = new exercisee();
		//get user input and validate user responses...
		System.out.println("What's your name?");
		String b = input.next();
		a.setName(b);
		System.out.println("Nice to meet you, " + a.getName());
		//System.out.println("What month is it?");
		System.out.println("What's your max squat?");
		while(squat < 45){
			squat = input.nextDouble();
			if(squat < 45) {
				System.out.println("Please input a value greater than 45 lbs.");
			}
		}
		squat = roundTo5(squat);
		a.setMaxSquat(squat);
		System.out.println("Your max squat is " + a.getMaxSquat());
		System.out.println("What's your max bench?");
		while(bench < 45) {
			bench = input.nextDouble();
			if (bench < 1) {
				System.out.println("Please input a value greater than 45 lbs.");
			}
		}
		bench = roundTo5(bench);
		a.setMaxBench(bench);
		System.out.println("Your max bench is " + a.getMaxBench());
		System.out.println("What's your max deadlift?");
		while(dl < 45) {
			dl = input.nextDouble();
			if(dl < 45) {
				System.out.println("Please input a value greater than 45 lbs.");
			}
		}
		dl = roundTo5(dl);
		a.setMaxDL(dl);
		System.out.println("Your max deadlift is " + a.getMaxDL());
		System.out.println("What's your max overhead press?");
		while(ohp < 45) {
			ohp = input.nextDouble();
			if(ohp < 45) {
				System.out.println("Please input a value greater than 45 lbs.");
			}
		}
		ohp = roundTo5(ohp);
		a.setMaxOHP(ohp);
		System.out.println("Your max overhead press is " + a.getMaxOHP());
		System.out.println("");
		System.out.println("Calculating training maxes for the cycles...");
		System.out.println("");
		//declare training max variables and calculate training maxes.
		double tSquat=0, tBench = 0, tDL = 0, tOHP = 0;
		tSquat = (.9 * a.getMaxSquat());
		tBench = (.9 * a.getMaxBench());
		tDL = (.9 * a.getMaxDL());
		tOHP = (.9 * a.getMaxOHP());
		//round those calculations to the nearest 5 lbs and cast them into integers.
		tSquat = roundTo5(tSquat);
		tBench = roundTo5(tBench);
		tDL = roundTo5(tDL);
		tOHP = roundTo5(tOHP);
		//store values into array.
		double trainingMax[] = {tSquat, tBench, tDL, tOHP};
		String exerciseList[] = {"Squat", "Bench", "Deadlift", "Overhead Press"};
		//set training maxes for the object.
		a.setTrainingSquat(tSquat);
		a.setTrainingBench(tBench);
		a.setTrainingDL(tDL);
		a.setTrainingOHP(tOHP);
		//display training maxes for various exercises.
		System.out.println("Your training max for squat is " + a.getTSquat());
		System.out.println("Your training max for bench is " + a.getTBench());
		System.out.println("Your training max for deadlift is " + a.getTDL());
		System.out.println("Your training max for overhead press is " + a.getTOHP());
		System.out.println("");
		//Generate data for the month.
		System.out.println("Week 1 (3x5) at 65%, 75%, 85%");
		System.out.println("Week 2 (3x3) at 70%, 80%, 90%");
		System.out.println("Week 3 (1x5, 1x3, 1x1) at 75%, 85%, 95%");
		System.out.println("Week 4: Deload(Optional) 3x5 at 40%, 50%, 60%");
		System.out.println("");
		//Quintet<String, String, Double, Double, Double> a = 
		//Arrays make for excellent loop controls.
		//week
		for(int l = 0; l < 4; l++) {
			System.out.println("Week " + (l+1) + ":");
			System.out.println("");
			if(l == 3) {
				System.out.println("Easy week");
			}
			//exercise
			for(int j = 0; j < 4; j++) {
				System.out.println((j+1) + " day: ("+exerciseList[j]+")");	
				System.out.println("");
				System.out.println("Proposed sets: ");
				//day
				for(int k = 0; k < 3; k++) {
					if(l == 0) {
					System.out.println(roundTo5((week1[k] * trainingMax[j])));
					}
					else if(l == 1) {
					System.out.println(roundTo5((week2[k] * trainingMax[j])));
					}
					else if(l == 2) {
					System.out.println(roundTo5((week3[k] * trainingMax[j])));
					}
					else if(l == 3){
					System.out.println(roundTo5((week4[k] * trainingMax[j])));
					}
				}
			}
			System.out.println("");
		}
  		exit();
	}
  	public static int roundTo5(double t) {
		return (int) (5*(Math.round(t/5)));
	}
	
	public static void welcome() {
		System.out.println("*******************************************");
		System.out.println("*                                         *");
		System.out.println("*     Welcome to the 5/3/1 calculator     *");
		System.out.println("*                                         *");
		System.out.println("*******************************************");
	}
	
	public static void exit() {
		System.out.println("2020, Brandon S.");
	}
}
