/**
 * 
 */
package main;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Brandon
 *
 */
public class Five31 {



	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		//initialize 1RM variables. Also generate arrays that are constant every month.
		double squat = 0, bench = 0, dl = 0, ohp = 0;
		double week1[] = {.65, .75, .85};
		double week2[] = {.70, .80, .90};
		double week3[] = {.75, .85, .95};
		double week4[] = {.40, .50, .60};
		welcome();
		Scanner input = new Scanner(System.in);
		exercisee a = new exercisee();
		//get user input and validate user responses.
		//validation by ensuring that user can't enter less than 45 lbs.
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
		//need to have this for generating data for year. 
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December"
		};
		//create buffered writer obj with filewriter object. allows use of newLine that buffered writer has.
		String csvFile = "/Users/Brandon/Desktop/results.csv";
		BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile));
		/* This loop can be confusing
		 * the most confusing part is following it.
		 * var i is used for months
		 * if you follow i, at the bottom, this program automatically adjusts training maxes by 5 per week.
		 * conservative, but fair. this will stop people from jumping into heavier workloads for no reason and potentially injuring themselves.
		 * var l is used for weeks
		 * var j is used for tracking exercise
		 * var k is used for generating workout sets.
		 */
		//Generates data for an entire year. 4 for loops. days + weeks + months + sets.
		for(int i = 0; i < 12; i++) {
		bw.write(months[i]);
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
				bw.write("Week " + Integer.toString(l+1));
				System.out.println("Week " + (l+1) + ":");
				System.out.println("");
				if(l == 3) {
					System.out.println("Easy week");
				}
				//
				for(int j = 0; j < 4; j++) {
					System.out.println((j+1) + " day: ("+exerciseList[j]+")");
					//bw.write("Week " + Integer.toString(l+1));
					bw.write(",");
					bw.write(exerciseList[j]);
					bw.write(",");
					System.out.println("");
					System.out.println("Proposed sets: ");
					//Generates weights for the exercises
					for(int k = 0; k < 3; k++) {
						if(l == 0) {
							switch(j) {
							case 0:
								bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 1:
								bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 2:
								bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 3:
								bw.write(Integer.toString(roundTo5(week1[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							}
						System.out.println(roundTo5((week1[k] * trainingMax[j])));
						}
						else if(l == 1) {
							switch(j) {
							case 0:
								bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 1:
								bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 2:
								bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 3:
								bw.write(Integer.toString(roundTo5(week2[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							}
						System.out.println(roundTo5((week2[k] * trainingMax[j])));
						}
						else if(l == 2) {
							switch(j) {
							case 0:
								bw.write(Integer.toString(roundTo5(week3[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 1:
								bw.write(Integer.toString(roundTo5(week3[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 2:
								bw.write(Integer.toString(roundTo5(week3[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 3:
								bw.write(Integer.toString(roundTo5(week3[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							}
						System.out.println(roundTo5((week3[k] * trainingMax[j])));
						}
						else if(l == 3){
							switch(j) {
							case 0:
								bw.write(Integer.toString(roundTo5(week4[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 1:
								bw.write(Integer.toString(roundTo5(week4[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 2:
								bw.write(Integer.toString(roundTo5(week4[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							case 3:
								bw.write(Integer.toString(roundTo5(week4[k] * trainingMax[j])));
								bw.write(",");
								if(k == 2) {
									bw.newLine();
								}
								break;
							}
						System.out.println(roundTo5((week4[k] * trainingMax[j])));
						}
						//bw.newLine();
					}
				}
				System.out.println("");
				bw.newLine();
			}
			for(int c = 0; c < 4; c++) {
				trainingMax[c] = trainingMax[c] + 5;
			}
		}
		bw.close();
		exit();		
	}
	//this is necessary because there is no such thing as a 2.3 lb weight at the gym.
	//all weight numbers are integers, at least in my gym.
	
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
		System.out.println("Thanks for using my program! -Brandon");
	}
	
	
}
