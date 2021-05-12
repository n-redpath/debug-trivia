/*
 * This file contains the level interface. Each level class will implement this interface. 
 * 
 * Authors:  Mia Collymore Abbas, Nina Redpath, Sarah Willis
 * 
 * */


import java.util.Scanner;

public interface Level {
	public String randomize(Question q);
	public boolean playLevel(Player p, Scanner ap);
}