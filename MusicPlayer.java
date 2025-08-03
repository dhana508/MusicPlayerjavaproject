package com;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Song> allSongs;
    private List<Playlist> playlists;

    public MusicPlayer() {
        allSongs = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    public void addSong(Song song) {
        allSongs.add(song);
        System.out.println("Song added to library.");
    }

    public void updateSong(String title, Song newSong) {
        for (int i = 0; i < allSongs.size(); i++) {
            if (allSongs.get(i).getTitle().equalsIgnoreCase(title)) {
                allSongs.set(i, newSong);
                System.out.println("Song updated.");
                return;
            }
        }
        System.out.println("Song not found.");
    }

    public void deleteSong(String title) {
        allSongs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
        System.out.println("Song deleted.");
    }

    public void displayAllSongs() {
        if (allSongs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            allSongs.forEach(System.out::println);
        }
    }

    public void createPlaylist(String name) {
        playlists.add(new Playlist(playlists.size() + 1, name));
        System.out.println("Playlist created.");
    }

    public void addSongToPlaylist(String playlistName, Song song) {
        Playlist pl = getPlaylist(playlistName);
        if (pl != null) {
            pl.addSong(song);
        } else {
            System.out.println("Playlist not found.");
        }
    }

    public void deletePlaylist(String name) {
        playlists.removeIf(p -> p.getPlaylistName().equalsIgnoreCase(name));
        System.out.println("Playlist deleted.");
    }

    public void playPlaylist(String name) {
        Playlist pl = getPlaylist(name);
        if (pl != null) {
            System.out.println("Songs in playlist:");
            pl.displaySongs();
        } else {
            System.out.println("Playlist not found.");
        }
    }

    public Playlist getPlaylist(String name) {
        for (Playlist p : playlists) {
            if (p.getPlaylistName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public void displayAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists created.");
        } else {
            for (Playlist p : playlists) {
                System.out.println("Playlist: " + p.getPlaylistName());
            }
        }
    }

    public List<Song> getAllSongs() {
        return allSongs;
    }
}

