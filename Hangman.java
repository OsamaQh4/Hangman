package src;

import java.util.Scanner;
import java.util.Random;
public class Hangman {
	public Scanner in = new Scanner(System.in);
	public Random r = new Random();
	public static String [] words = {"acres",
			"adult",
			"advice",
			"arrangement",
			"attempt",
			"August",
			"Autumn",
			"border",
			"breeze",
			"brick",
			"calm",
			"canal",
			"Casey",
			"cast",
			"chose",
			"claws",
			"coach",
			"constantly",
			"contrast",
			"cookies",
			"customs",
			"damage",
			"Danny",
			"deeply",
			"depth",
			"discussion",
			"doll",
			"donkey",
			"Egypt",
			"Ellen",
			"essential",
			"exchange",
			"exist",
			"explanation",
			"facing",
			"film",
			"finest",
			"fireplace",
			"floating",
			"folks",
			"fort",
			"garage",
			"grabbed",
			"grandmother",
			"habit",
			"happily",
			"Harry",
			"heading",
			"hunter",
			"Illinois",
			"image",
			"independent",
			"instant",
			"January",
			"kids",
			"label",
			"Lee",
			"lungs",
			"manufacturing",
			"Martin",
			"mathematics",
			"melted",
			"memory",
			"mill",
			"mission",
			"monkey",
			"Mount",
			"mysterious",
			"neighborhood",
			"Norway",
			"nuts",
			"occasionally",
			"official",
			"ourselves",
			"palace",
			"Pennsylvania",
			"Philadelphia",
			"plates",
			"poetry",
			"policeman",
			"positive",
			"possibly",
			"practical",
			"pride",
			"promised",
			"recall",
			"relationship",
			"remarkable",
			"require",
			"rhyme",
			"rocky",
			"rubbed",
			"rush",
			"sale",
			"satellites",
			"satisfied",
			"scared",
			"selection",
			"shake",
			"shaking",
			"shallow",
			"shout",
			"silly",
			"simplest",
			"slight",
			"slip",
			"slope",
			"soap",
			"solar",
			"species",
			"spin",
			"stiff",
			"swung",
			"tales",
			"thumb",
			"tobacco",
			"toy",
			"trap",
			"treated",
			"tune",
			"University",
			"vapor",
			"vessels",
			"wealth",
			"wolf",
			"zoo"};
	char [] hiddenWord;
	char [] guessedWord;
	Hangman(){
		hiddenWord = new char [0];
		guessedWord = new char [0];
	}
	private int indexOf(char c) {
		for (int i = 0 ; i< hiddenWord.length ; i++) {
			if (c == hiddenWord [i])
			return i;
		}
		return -1;
	}
	private void setCharAt(int i, char c, char []arr) {
		arr[i] = c;
	}
	private String pickWord() {
		int b = r.nextInt(words.length);
		String g = words[b];
		return g;
	}
	private char[] copyStringToArray(String s) {
		return s.toCharArray();
	}
	private void printWord() {
		for (int i = 0; i < guessedWord.length; i++) {
			System.out.print(guessedWord[i]);
		}
	}
	private boolean isComplete() {
		for (int i =0 ; i < guessedWord.length; i++) {
			char d = guessedWord[i];
			if ('*' == d) {
			return false;
			}
		}
		return true;
	}
	private void playOneRound() {
		String g = pickWord();
		hiddenWord = copyStringToArray(g);
		guessedWord = new char [g.length()];
		for (int i = 0; i< guessedWord.length; i++) {
			guessedWord [i] = '*';
		}
			int count = 0;
				do {boolean detctor = false;
					System.out.print("(Guess) Enter a letter in word ");
					printWord();
					System.out.print(" >");
					char d = in.next().charAt(0);
					for (int i = 0 ; i<guessedWord.length; i++) {
						if (guessedWord[i] == d) {detctor = true;break;}	
					}
					if (detctor) {
						System.out.println("\t" + d + " is already in the word");
					}
					else if (-1 == indexOf(d)) {
						count++;System.out.println("\t" + d + " is not in the word");
					}
					else {
						do {
						setCharAt(indexOf(d), d , guessedWord);
						setCharAt(indexOf(d), '$' , hiddenWord);
						}while(indexOf(d) != -1);
					}
					if (isComplete()) {
						System.out.print("The word is ");printWord();
						System.out.println(". You missed "+count+ " time.");
					}
				}while(!isComplete());
			}
	public void play() {
		System.out.println("Welcome to Hangman game. Are you ready? OK, let us start: ");
		playOneRound();
		char g;
		do {
		System.out.print("do you want to guess another word? Enter y or n>");
		g = in.next().charAt(0);
		if ('y' == g) {
			playOneRound();
		}
		}while('n' != g);
			System.out.println("Goodbye!");
	}
	public String [] getWords() {
		return words;
	}
	public char [] getHiddenWord() {
		return hiddenWord;
	}

}
