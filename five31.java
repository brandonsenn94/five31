/**
 * 
 */
package main;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Brandon
 *
 */
public class Five31 {



	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
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
		System.out.println("What's your max squat?");
		while(squat < 45){
			squat = input.nextDouble();
			if(squat < 1) {
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
			if(dl < 1) {
				System.out.println("Please input a value greater than 45 lbs.");
			}
		}
		dl = roundTo5(dl);
		a.setMaxDL(dl);
		System.out.println("Your max deadlift is " + a.getMaxDL());
		System.out.println("What's your max overhead press?");
		while(ohp < 45) {
			ohp = input.nextDouble();
			if(ohp < 1) {
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
		//Arrays make for excellent loop controls.
		//		
		String csvFile = "/Users/Brandon/Desktop/results.csv";
		//BufferedWriter bw = new BufferedWriter(writer);
		BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));
		bw.write("January");
		bw.write(",");
		bw.write("Exercise");
		bw.write(",");
		bw.write("Set 1");
		bw.write(",");
		bw.write("Set 2");
		bw.write(",");
		bw.write("Set 3");
		bw.newLine();
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
				bw.write(",");
				bw.write(exerciseList[j]);
				bw.write(",");
				System.out.println("");
				System.out.println("Proposed sets: ");
				//day
				for(int k = 0; k < 3; k++) {
					if(l == 0) {
						switch(j) {
						case 0:
							//bw.write(",");
							//bw.write(exerciseList[0]);
							//bw.write(",");
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 1:
							//bw.write(",");
							//bw.write(exerciseList[1]);
							//bw.write(",");
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 2:
							//bw.write(",");
							//bw.write(exerciseList[2]);
							//bw.write(",");
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 3:
							//bw.write(",");
							//bw.write(exerciseList[3]);
							//bw.write(",");
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							bw.newLine();
							break;
						}
					System.out.println(roundTo5((week1[k] * trainingMax[j])));
					}
					else if(l == 1) {
						switch(j) {
						case 0:
							//bw.write(exerciseList[0]);
							bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 1:
							//bw.write(exerciseList[1]);
							bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 2:
							//bw.write(exerciseList[2]);
							bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 3:
							//bw.write(exerciseList[3]);
							bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
							bw.write(",");
							bw.newLine();
							break;
						}
					System.out.println(roundTo5((week2[k] * trainingMax[j])));
					}
					else if(l == 2) {
						switch(j) {
						case 0:
							//bw.write(exerciseList[0]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 1:
							//bw.write(exerciseList[1]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 2:
							//bw.write(exerciseList[2]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 3:
							//bw.write(exerciseList[3]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							bw.newLine();
							break;
						}
					System.out.println(roundTo5((week3[k] * trainingMax[j])));
					}
					else if(l == 3){
						switch(j) {
						case 0:
							//bw.write(exerciseList[0]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 1:
							//bw.write(exerciseList[1]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 2:
							//bw.write(exerciseList[2]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							bw.write(",");
							break;
						case 3:
							//bw.write(exerciseList[3]);
							bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
							//bw.newLine();
							bw.write(",");
							bw.newLine();
							break;
						}
					System.out.println(roundTo5((week4[k] * trainingMax[j])));
					}
					//bw.newLine();
				}
			}
			System.out.println("");
		}
		bw.close();
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
		System.out.println("Copyright 2020, Brandon S.");
	}
	
	
}
