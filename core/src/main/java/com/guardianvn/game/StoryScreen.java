package com.guardianvn.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bladecoder.ink.runtime.Story;

public class StoryScreen extends BaseScreen{
    private Story story;
    private Scene scene;
    private Background background;
    private Background background2;
    private Background black;
    private DialogBox dialogBox;
    private BaseActor continueKey;
    private Table buttonTable;
    private String line = " ";
    private MC mc;
    private Character brother;
    private Character bandit1;
    private Character bandit2;
    private Character boss;
    private int counter = 1;
    private Effects fx;

    public void initialize() {
        background = new Background(0,0, mainStage); // Sets a new background first
        background2 = new Background(0,0, mainStage); // Sets a new background first

        background.setAnimation(background.groundTex);
        background2.setAnimation(background2.RamaTex);
        background.setSize(1280, 720);
        background2.setSize(1280, 720);
        background2.setOrigin(640, 360);
        background.setOrigin(640, 360);
        background.setVisible(true);
        background2.setVisible(false);

        BaseActor.setWorldBounds(background);
        fx = new Effects(0,0,mainStage);
        fx.setVisible(false);
        fx.setAnimation(fx.player1Animation);
        fx.setSize(1280, 720);
        fx.setOrigin(640, 360);

        boss = new Character(0, 0, mainStage);
        boss.setAnimation(boss.Boss);
        boss.scaleBy(-0.25f);
        boss.setPosition(-200,-1000);
        boss.setVisible(false);

        brother = new Character(0, 0, mainStage);
        brother.setAnimation(brother.brotherNormal);
        brother.scaleBy(-0.35f);
        brother.setPosition(300,-600);
        brother.setVisible(false);

        bandit1 = new Character(0, 0, mainStage);
        bandit1.setAnimation(bandit1.banditOne1);
        bandit1.scaleBy(-0.35f);
        bandit1.setPosition(50,-600);
        bandit1.setVisible(false);

        bandit2 = new Character(0, 0, mainStage);
        bandit2.setAnimation(bandit2.banditTwo1);
        bandit2.scaleBy(-0.35f);
        bandit2.setPosition(50,-600);
        bandit2.setVisible(false);

        mc = new MC(0, 0, mainStage);
        mc.setAnimation(mc.normal2);
        mc.scaleBy(-0.35f);
        mc.setPosition(200,-950);
        mc.setVisible(false);

        black = new Background(0,0,mainStage);
        black.setAnimation(black.black);
        black.setSize(1280,720);
        black.setOrigin(640,360);
        black.setVisible(false);

        scene = new Scene("guardian.json");
        String json = scene.loadStory("guardian.json");

        if (json != null) {
            // Create the Ink story
            try {
                story = new Story(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to load story.");
        }
        dialogBox = new DialogBox(0,0, uiStage); // Sets the dialog box on top of rose

        dialogBox.setDialogSize(1000, 200);
        //dialogBox.setBackgroundColor( new Color(0, 0, 0, 1) );

        dialogBox.setVisible(false);
        dialogBox.addAction(new TypewriterAction(" "));

        continueKey = new BaseActor(0,0,uiStage); // sets the continue button on top of the dialog box
        continueKey.loadTexture("button.png");
        continueKey.setSize(32,32);
        continueKey.setVisible(false);

        dialogBox.addActor(continueKey); // uses the dialog box add actor parameter inside of the constructor to declare the button image.
        continueKey.setPosition( dialogBox.getWidth() - continueKey.getWidth(), 0 ); // sets the position of the button image

        buttonTable = new Table(); // creates a button table for the options when it comes down to the time of selecting a option in the store.
        buttonTable.setVisible(false);

        // Ui table adjust the columns and rows used in the row
        uiTable.add().expandY();
        uiTable.row();
        uiTable.add(buttonTable);
        uiTable.row();
        uiTable.add(dialogBox);
        uiStage.addActor(uiTable);

        // sets the mainStage Actor as scene so that when a scene is declared its shown on the interface
        mainStage.addActor(scene);

        // calls the first method that holds the introduction of the first part of the story

        scene.start(); // Start the story
        scene1();

    }

    public void scene1() {

        scene = new Scene("guardian.json");
        String json = scene.loadStory("guardian.json");

        if (json != null) {
            // Create the Ink story
            try {
                story = new Story(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to load story.");
        }
        // Reset the story state
        if (story != null) {
            try {
                story.resetState();

            } catch (Exception e) {
                System.out.println("File Not Found");
            }
        }  else {
            System.out.println("Story is not initialized.");
            return;
        }
        background.addAction(Actions.sequence(
            Actions.alpha(0), // Start with transparency
            Actions.fadeIn(1f) // Fade in over 1 second
        ));
        // Hides the dialog box
        dialogBox.setVisible(false);
        dialogBox.setText(" ");
        dialogBox.addAction(Actions.sequence(
            Actions.alpha(0), // Start with transparency
            Actions.fadeIn(0.5f) // Fade in over 1 second
        ));
        // Show the dialog box
        dialogBox.setVisible(true);
        dialogBox.addAction(new TypewriterAction(" "));
        // Start the story from the beginning
        scene.start();


    }

    private void scene2() {
        scene = new Scene("guardian2.json");
        String json = scene.loadStory("guardian2.json");

        if (json != null) {
            // Create the Ink story
            try {
                story = new Story(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to load story.");
        }
        // Reset the story state
        if (story != null) {
            try {
                story.resetState();

            } catch (Exception e) {
                System.out.println("File Not Found");
            }
        }  else {
            System.out.println("Story is not initialized.");
            return;
        }

        background2.setVisible(false);
        fx.setVisible(false);
        black.addAction(Actions.fadeOut(1f));
        background.setAnimation(background.forestDay);
        background.addAction(Actions.sequence(
            Actions.alpha(0), // Start with transparency
            Actions.fadeIn(1f) // Fade in over 1 second
        ));
        // Hides the dialog box
        dialogBox.setVisible(false);

        dialogBox.setText(" ");
        dialogBox.addAction(Actions.sequence(
            Actions.alpha(0), // Start with transparency
            Actions.fadeIn(0.5f) // Fade in over 1 second
        ));
        // Show the dialog box
        dialogBox.setVisible(true);
        dialogBox.addAction(new TypewriterAction(" "));
        // Start the story from the beginning
        scene.start();

    }



    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // Advance the story when the user clicks the mouse
        if (story != null && dialogBox.isVisible() && story.canContinue()) {

            try {
                line = story.Continue();
                dialogBox.clearActions(); // Clear any ongoing actions (such as the TypewriterAction)
                dialogBox.setText(line);
                if (line.contains("Creatures of unknown origin...")){
                    background2.setVisible(true);
                    background2.setOpacity(0);

                    background2.addAction(Actions.fadeIn(1f));
                    background2.addAction(Actions.scaleTo(1.1f, 1.1f, 10f));

                }

                if (line.contains("they possessed supernatural abilities")){
                    fx.setVisible(true);
                    fx.addAction(Actions.fadeIn(1f));
                    black.setVisible(true);
                    black.addAction(Actions.fadeOut(0.3f));

                }
                if (line.contains("So if you don't want them to come over")){
                    brother.setVisible(true);
                    brother.setAnimation(brother.brotherAngry);
                    brother.setOpacity(0);
                    brother.addAction(Actions.fadeIn(0.5f));
                    black.setVisible(true);
                    black.addAction(Actions.fadeOut(0.3f));

                }
                if (line.contains("Enough with your nonsense kid...")){
                    brother.setVisible(false);
                    bandit1.setVisible(true);
                    bandit1.setOpacity(0);
                    bandit1.addAction(Actions.fadeIn(0.5f));


                }

                if (line.contains("Yeah, The Rama is only a legend")){
                    bandit1.setVisible(false);
                    bandit2.setVisible(true);
                    bandit2.setOpacity(0);
                    bandit2.addAction(Actions.fadeIn(0.5f));


                }
                if (line.contains("Well that doesn't matter!")){
                    brother.setVisible(true);
                    brother.moveBy(200,0);
                    bandit1.setVisible(true);
                    bandit2.setVisible(true);
                    bandit1.moveBy(-200,0);
                    bandit2.moveBy(-350,0);
                }
                if (line.contains("Don't worry!, We only came here to find the village")){
                    bandit1.setAnimation(bandit1.banditOne2);
                }
                if (line.contains("Yeah!, so point us to the right direction")){
                    bandit2.setAnimation(bandit2.banditTwo2);
                }
                if (line.contains("No!")){
                    brother.setAnimation(brother.brotherAngry2);
                }
                if (line.contains("It seems we've got a stubborn one")){
                    bandit2.setVisible(false);
                    brother.setVisible(false);
                    bandit1.addAction(Actions.moveTo(50,-600));
                }
                if (line.contains("Well little boy...")){
                    bandit1.setVisible(false);
                    boss.setVisible(true);
                    boss.setOpacity(0);
                    boss.addAction(Actions.fadeIn(0.5f));
                }
                if (line.contains("You have one chance to tell us where your village")){
                    boss.moveBy(-300,0);
                    brother.setVisible(true);
                }
                if (line.contains("Stop now!")){
                    boss.setVisible(false);
                    brother.setVisible(false);
                }
                if (line.contains("Huh?")){
                    boss.setVisible(true);
                    boss.moveBy(300,0);
                    boss.setAnimation(boss.Boss2);
                }
                if (line.contains("...")){
                    counter = counter + 1;
                    System.out.println("Counter is " + counter);
                    if (counter == 8) {
                        dialogBox.setVisible(false);

                        black.setVisible(true);
                        black.setOpacity(0);
                        black.addAction(Actions.sequence(
                                Actions.fadeIn(1f), Actions.run(() -> {scene2();}) // Fade out over 1 second
                            )
                        );
                    }
                    if (counter == 12) {
                        boss.setVisible(false);
                        mc.setVisible(true);
                        mc.setAnimation(mc.normal2F);
                        mc.setOpacity(0);
                        mc.addAction(Actions.fadeIn(2f));
                    }
                    if (counter == 13) {
                        mc.addAction(Actions.moveBy(75,0,1f));
                    }
                    if (counter == 16) {
                        black.setVisible(true);
                        black.setOpacity(0);
                        black.addAction(Actions.fadeIn(1f));
                    }

                }
                if (line.contains("Brother!")){
                    mc.setVisible(false);
                    brother.setVisible(true);
                    brother.setAnimation(brother.brotherNormal2);
                    brother.moveBy(-200,0);
                }
                if (line.contains("What?")){
                    mc.setVisible(true);
                    mc.moveBy(-250,0);
                    brother.setVisible(false);
                    boss.setVisible(true);
                    boss.moveBy(300,0);
                }
                if (line.contains("He is still smaller than me!")){
                    boss.setAnimation(boss.Boss);
                }
                if (line.contains("I don't go by a name...")){
                    boss.setVisible(false);
                    mc.setPosition(200,-950);
                }

            } catch (Exception e) {
                System.out.println("File Not Found");
            }
            dialogBox.addAction(new TypewriterAction(line));


        } else if (!story.canContinue()) {

            BaseGame.setActiveScreen(new StoryScreen2());
        }


        return super.touchDown(screenX, screenY, pointer, button);
    }



    public void update(float dt) {

    }

    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
