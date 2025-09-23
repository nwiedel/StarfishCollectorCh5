package de.nicolas.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import de.nicolas.utils.actions.Scene;
import de.nicolas.utils.actions.SceneActions;
import de.nicolas.utils.actors.BaseActor;
import de.nicolas.utils.actors.DialogBox;
import de.nicolas.utils.game.BaseGame;
import de.nicolas.utils.game.SceneSegment;
import de.nicolas.utils.screens.BaseScreen;

public class StoryScreen extends BaseScreen {

    private Scene scene;
    private BaseActor continueKey;

    @Override
    public void initialize() {
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("assets/oceanside.png");
        background.setSize(800, 600);
        background.setOpacity(0);
        BaseActor.setWorldBounds(background);

        BaseActor turtle = new BaseActor(0, 0, mainStage);
        turtle.loadTexture("assets/turtle-big.png");
        turtle.setPosition(-turtle.getWidth(), 0);

        DialogBox dialogBox = new DialogBox(0, 0, uiStage);
        dialogBox.setSize(600, 200);
        dialogBox.setBackgroundColor(new Color(0.6f, 0.6f, 0.8f, 1f));
        dialogBox.setFontScale(0.75f);
        dialogBox.setVisible(false);

        uiTable.add(dialogBox). expandX().expandY().bottom();

        continueKey = new BaseActor(0, 0, uiStage);
        continueKey.loadTexture("assets/key-C.png");
        continueKey.setSize(32, 32);
        continueKey.setVisible(false);

        dialogBox.addActor(continueKey);
        continueKey.setPosition(dialogBox.getWidth() - continueKey.getWidth(), 0);

        scene = new Scene();
        mainStage.addActor(scene);

        scene.addSegment(new SceneSegment(background, Actions.fadeIn(1)));
        scene.addSegment(new SceneSegment(turtle, SceneActions.moveToScreenCenter(2)));
        scene.addSegment(new SceneSegment(dialogBox, Actions.show()));
        scene.addSegment(new SceneSegment(dialogBox,
            SceneActions.setText("Ich möchte gerne der beste Starfish-Sammler sein!!")));
        scene.addSegment(new SceneSegment(continueKey, Actions.show()));
        scene.addSegment(new SceneSegment(background, SceneActions.pause()));
        scene.addSegment(new SceneSegment(continueKey, Actions.hide()));
        scene.addSegment(new SceneSegment(dialogBox,
            SceneActions.setText("Ich kriege sie alle!!!!")));
        scene.addSegment(new SceneSegment(continueKey, Actions.show()));
        scene.addSegment(new SceneSegment(background, SceneActions.pause()));
        scene.addSegment(new SceneSegment(continueKey, Actions.hide()));
        scene.addSegment(new SceneSegment(dialogBox, Actions.hide()));
        scene.addSegment(new SceneSegment(turtle, SceneActions.moveToOutsideRight(1)));
        scene.addSegment(new SceneSegment(background, Actions.fadeOut(1)));

        scene.start();
    }

    @Override
    public void update(float delta) {
        if (scene.isSceneFinished()){
            BaseGame.setActiveScreen(new LevelScreen());
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.C && continueKey.isVisible()){
            scene.loadNextSegment();
        }
        return false;
    }
}
