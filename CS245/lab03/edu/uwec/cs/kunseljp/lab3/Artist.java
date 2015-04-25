package edu.uwec.cs.kunseljp.lab3;

import java.util.*;

public class Artist implements Comparable<Artist> {

	private String lastName;
	private String firstName;
	private List<Song> songs;

	public Artist() {
		this("defaultLast", "defaultFirst");
	}

	public Artist(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
		songs = new ArrayList<Song>();
	}

	public void addSong(Song newSong) {
		songs.add(newSong);
	}

	public boolean equals(Object o) {
		Artist a = (Artist) o;
		boolean result = false;
		if ((a.lastName.equals(this.lastName))
				&& (a.firstName.equals(this.firstName))) {
			result = true;
		}
		return result;
	}

	public int compareTo(Artist a) {
		int result = this.lastName.compareTo(a.lastName);
		if (this.lastName.compareTo(a.lastName) == 0) {
			result = this.firstName.compareTo(a.firstName);
		}
		return result;
	}

	public String toString() {
		return firstName + " " + lastName;
	}
}
