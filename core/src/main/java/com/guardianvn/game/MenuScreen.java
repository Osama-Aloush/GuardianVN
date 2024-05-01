package com.guardianvn.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/***
 * This is the Menu screen when you run the program, this is to have a nice introduction to the program.
 *
 *
 */

public class MenuScreen extends BaseScreen{

    //
    public void initialize()
    {
        // Creating a background
        BaseActor background = new BaseActor(0,0, mainStage); // Initializing the background image actor;
        background.loadTexture( "Background/cave.jpg" ); // setting the image
        background.setSize(1280,800);  // Adjusted the size of background
        BaseActor title = new BaseActor(0,0, mainStage);// Initializing the title image actor.
        title.loadTexture( "libgdx.png" ); // setting the image

        // This generates a button from the LibGDX library.
        TextButton startButton = new TextButton( "Start", BaseGame.textButtonStyle );

        // An event listener for the generated button to start the game.
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BaseGame.setActiveScreen(new BattleScreen()); // Opens the StoryScreen class
            }
        });

        // Creates a quit button from the LibGdx text button library
        TextButton quitButton = new TextButton( "Quit", BaseGame.textButtonStyle );

        // An event listener for the generated button to close the application.
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit(); // closes the app
            }
        });


        // Organizes the buttons with the UiTable grid.
        uiTable.add(title).colspan(2);
        uiTable.row();
        uiTable.add(startButton);
        uiTable.add(quitButton);
    }
    public void update(float dt) // Changes the game world and entities
    { }
    public boolean keyDown(int keyCode) // Method to check if the button was clicked.
    {
        if (Gdx.input.isKeyPressed(Keys.ENTER))
            BaseGame.setActiveScreen( new StoryScreen() );
        if (Gdx.input.isKeyPressed(Keys.ESCAPE))
            Gdx.app.exit();
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}
