package com.guardianvn.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.bladecoder.ink.runtime.Story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Scene extends Actor {
    private Story story;

    public Scene(String filename) {
        super();
        loadStory(filename);
    }

    public void start() {
        // Start the story
        if (story != null) {
            try {
                story.resetState(); // Reset story state
            } catch (Exception e) {
                System.out.println("File Not Found");
            }
            story.canContinue(); // Start the story from the beginning
        }
    }

    public void loadNextSegment() {
        // Load the next story segment
        if (story != null) {
            try {
                story.chooseChoiceIndex(0); // For simplicity, choose the first choice
            } catch (Exception e) {
                System.out.println("File Not Found");
            }
            // Handle any other logic needed for loading the next segment
        }
    }

    // Load the story from a JSON file
    public String loadStory(String filename) {
        String json = loadJSON(filename);
        if (json != null) {
            try {
                story = new Story(json);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to load JSON file: " + filename);
        }
        return json;
    }



    // Method to load JSON file and return its content as a string
    private String loadJSON(String filename) {
        InputStream stream = ClassLoader.getSystemResourceAsStream(filename);
        if (stream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder json = new StringBuilder();

            try {
                String line = reader.readLine();
                while (line != null) {
                    json.append(line).append('\n');
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return json.toString();
        } else {
            System.err.println("Could not load JSON file: " + filename);
            return null;
        }
    }
}
