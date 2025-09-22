package de.nicolas.screens;

import com.badlogic.gdx.Input;
import de.nicolas.utils.actions.Scene;
import de.nicolas.utils.actors.BaseActor;
import de.nicolas.utils.actors.DialogBox;
import de.nicolas.utils.screens.BaseScreen;

public class StoryScreen extends BaseScreen {

    private Scene scene;
    private BaseActor continueKey;

    @Override
    public void initialize() {
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("assets/oceanside.png");
        background.setSize(800, 600);
        BaseActor.setWorldBounds(background);

        BaseActor turtle = new BaseActor(0, 0, mainStage);
        turtle.loadTexture("assets/turtle-big.png");
        turtle.setPosition(-turtle.getWidth(), 0);

        DialogBox dialogBox = new DialogBox(0, 0, uiStage);
        dialogBox.setSize(600, 200);
        
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.C && continueKey.isVisible()){
            scene.loadNextSegment();
        }
        return false;
    }
}
