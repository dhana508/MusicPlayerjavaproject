package com;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private int playlistId;
	private String playlistName;
	private List<Song> songs;
	
	public Playlist(int playlistId, String playlistName) {
		this.playlistId = playlistId;
		this.playlistName = playlistName;
		this.songs = new ArrayList<>();
	}
	public String getPlaylistName() {
		return playlistName;
	}
	 
	public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added to playlist.");
    }

    public void removeSong(String title) {
        songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
        System.out.println("Song removed from playlist.");
    }

    public void removeSong(int songId) {
        songs.removeIf(song -> song.getSongId() == songId);
        System.out.println("Song removed from playlist.");
    }

    public void displaySongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in playlist.");
        } else {
            songs.forEach(System.out::println);
        }
    }

    private Song findSong(String title) {
        return songs.stream().filter(song -> song.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    private Song findSong(int id) {
        return songs.stream().filter(song -> song.getSongId() == id).findFirst().orElse(null);
    }

    public void play(String title) {
        Song song = findSong(title);
        if (song != null)
            System.out.println("Playing: " + song.getTitle());
        else
            System.out.println("Song not found.");
    }

   
    public void play(int songId) {
        Song song = findSong(songId);
        if (song != null)
            System.out.println("Playing: " + song.getTitle());
        else
            System.out.println("Song not found.");
    }

    
    public void pause(String title) {
        System.out.println("Paused: " + title);
    }

    
    public void pause(int songId) {
        System.out.println("Paused song with ID: " + songId);
    }

    
    public void stop(String title) {
        System.out.println("Stopped: " + title);
    }

    
    public void stop(int songId) {
        System.out.println("Stopped song with ID: " + songId);
    }
}	
		
	


