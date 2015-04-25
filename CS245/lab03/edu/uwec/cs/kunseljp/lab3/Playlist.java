package edu.uwec.cs.kunseljp.lab3;

import java.util.*;

public class Playlist {
	
	private String name;
	private List<Song> songs;
	
	public Playlist(){
		this("Default Playlist");
	}
	
	public Playlist(String title){
		this.name = title;
		songs = new ArrayList<Song>();
	}
	
	public void addSong(Song newSong){
		songs.add(newSong);
	}
	
	public int runningTime(){
		int sum = 0;
		for(int i=0; i<songs.size(); i++){
			sum += songs.get(i).runningTime();
		}
		return sum;
	}
	
	public boolean contains(Object o){
		return songs.contains(o);
	}
	
	public void sortBySong(){
		Collections.sort(songs);
	}
	
	public String toString() {
		String result = this.name + " [";
		String song;
		
		for(int i=0; i<songs.size(); i++) {
			if(i != 0) {
				result += ", ";
			}
			song = ((songs.get(i)).toString());
			result += song;
		}
		
		result += "]";
		return result;
	}
	
	public int compareTo(Playlist p) {
		int result = 0;
		if(this.songs.size() > p.songs.size()) {
			result = 1;
		} else if(this.songs.size() < p.songs.size()) {
			result = -1;
		} else {
			result = 0;
			boolean changeFound = false;
			int i=0;
			while((i<songs.size()) && (changeFound == false)) {
				result = p.songs.get(i).compareTo(this.songs.get(i));
				if(result == 0) {
					i++;
				} else {
					changeFound = true;
				}
			}
		}
		return result;
	}
}	
