package com;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MusicPlayer player = new MusicPlayer();
		int choice;
		do {
			System.out.println("\n======== MUSIC PLAYES MENU =========");
			System.out.println("1. Add New Song");
			System.out.println("2. Update Existing Song");
			System.out.println("3. Delete Song");
			System.out.println("4. Display All Songs");
			System.out.println("5. Create New Playlist");
			System.out.println("6. Add song to Playlist");
			System.out.println("7. Display All Playlist");
			System.out.println("8. Display Songs in Playlist");
			System.out.println("9. Play Song in Playlist");
			System.out.println("10. Pause Song in Playlist");
			System.out.println("11. Stop Song in Playlist");
			System.out.println("12. Exit");
			System.out.println("Enter your Choice:"); 
			
			choice = sc.nextInt(); //consume new line
			sc.nextLine();  // consume newline

            String title, artist, playlistName;
            double duration;
            int id;

            switch (choice) {
                case 1:
                    System.out.print("Enter Song ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Artist: ");
                    artist = sc.nextLine();
                    System.out.print("Enter Duration (minutes): ");
                    duration = sc.nextDouble();
                    sc.nextLine();
                    player.addSong(new Song(id, title, artist, duration));
                    break;
                case 2:
                    System.out.print("Enter Song Title to Update: ");
                    title = sc.nextLine();
                    System.out.print("New ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New Artist: ");
                    String newArtist = sc.nextLine();
                    System.out.print("New Duration: ");
                    duration = sc.nextDouble();
                    sc.nextLine();
                    player.updateSong(title, new Song(id, newTitle, newArtist, duration));
                    break;
                case 3:
                    System.out.print("Enter Song Title to Delete: ");
                    title = sc.nextLine();
                    player.deleteSong(title);
                    break;
                case 4:
                    player.displayAllSongs();
                    break;
                case 5:
                    System.out.print("Enter Playlist Name: ");
                    playlistName = sc.nextLine();
                    player.createPlaylist(playlistName);
                    break;
                case 6:
                    System.out.print("Enter Playlist Name: ");
                    playlistName = sc.nextLine();
                    System.out.print("Enter Song Title to Add: ");
                    title = sc.nextLine();
                    Song songToAdd = player.getAllSongs().stream()
                        .filter(s -> s.getTitle().equalsIgnoreCase(title))
                        .findFirst()
                        .orElse(null);
                    if (songToAdd != null)
                        player.addSongToPlaylist(playlistName, songToAdd);
                    else
                        System.out.println("Song not found.");
                    break;
                case 7:
                    player.displayAllPlaylists();
                    break;
                case 8:
                    System.out.print("Enter Playlist Name: ");
                    playlistName = sc.nextLine();
                    Playlist pl = player.getPlaylist(playlistName);
                    if (pl != null) pl.displaySongs();
                    else System.out.println("Playlist not found.");
                    break;
                case 9:
                    System.out.print("Enter Playlist Name: ");
                    playlistName = sc.nextLine();
                    System.out.print("Enter Song Title to Play: ");
                    title = sc.nextLine();
                    player.getPlaylist(playlistName).play(title);
                    break;
                case 10:
                    System.out.print("Enter Playlist Name: ");
                    playlistName = sc.nextLine();
                    System.out.print("Enter Song Title to Pause: ");
                    title = sc.nextLine();
                    player.getPlaylist(playlistName).pause(title);
                    break;
                case 11:
                    System.out.print("Enter Playlist Name: ");
                    playlistName = sc.nextLine();
                    System.out.print("Enter Song Title to Stop: ");
                    title = sc.nextLine();
                    player.getPlaylist(playlistName).stop(title);
                    break;
                case 12:
                    System.out.println("Exiting Music Player...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 12);
        sc.close();
    }

		
	}


