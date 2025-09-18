package de.nicolas.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import de.nicolas.utils.actors.BaseActor;
import de.nicolas.StarfishGame;
import de.nicolas.utils.screens.BaseScreen;

public class MenuScreen extends BaseScreen {
    @Override
    public void initialize() {
        BaseActor ocean = new BaseActor(0, 0, mainStage);
        ocean.loadTexture("assets/water.jpg");
        ocean.setSize(800, 600);

        BaseActor title = new BaseActor(0, 0, mainStage);
        title.loadTexture("assets/starfish-collector.png");
        title.centerAtPosition(400,300);
        title.moveBy(0, 100);

        BaseActor start = new BaseActor(0, 0, mainStage);
        start.loadTexture("assets/message-start.png");
        start.centerAtPosition(400, 300);
        start.moveBy(0, -100);
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            StarfishGame.setActiveScreen(new LevelScreen());
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
