package com;

public class Song {
	private int songId;
	private String title;
	private String artist;
	private double duration; //duration in minutes
	
	public Song(int songId, String title, String artist, double duration) {
		this.songId = songId;
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}
	
	//Getters and Setters
	public int getSongId() {
		return songId;
	}
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public double getDuration() {
		return duration;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override 
	public String toString() {
		return "Id: " + songId + ",Title: " + title + ", Artist: " + artist + ", Duration: " + duration + "mins";
	}

}
