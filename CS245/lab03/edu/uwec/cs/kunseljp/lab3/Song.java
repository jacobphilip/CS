package edu.uwec.cs.kunseljp.lab3;

public class Song implements Comparable<Song>{
	
	private String title;
	private Artist artist;
	private int runningTime;
	
	public Song(String song, Artist musician, int length) {
		this.title = song;
		this.artist = musician;
		this.runningTime = length;
	}
	
	public int runningTime() {
		return this.runningTime;
	}
	
	public int compareTo(Song s) {
		int result = this.title.compareTo(s.title);
		if(this.title.compareTo(s.title) == 0) {
			result = this.artist.compareTo(s.artist);
			if(this.artist.compareTo(s.artist) == 0) {
				if(this.runningTime == s.runningTime) {
					result = 0;
				} else if(this.runningTime > s.runningTime) {
					result = 1;
				} else {
					result = -1;
				}
			}
		}
		return result;
	}
	
	public boolean equals(Object o) {
		Song s = (Song) o;
		boolean result = false;
		if ((s.title.equals(this.title)) && (s.artist.equals(this.artist)) && (s.runningTime == this.runningTime)) {
			result = true;
		}
		return result;
	}
	
	public String toString() {
		return title + " (" + runningTime + ") by " + artist.toString();
	}

}
