package de.nicolas.utils.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import de.nicolas.utils.screens.BaseScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

/**
 * wird erstellt beim Start des Programms.
 * Steuert den Wechsel zwischen den Screens
 */
public abstract class BaseGame extends Game {

    /**
     * speichert die Referenz des aktuellen Game
     */
    private static BaseGame game;

    /**
     * statische Variable für die Darstellung von Text auf Labels
     */
    public static LabelStyle labelStyle;

    public BaseGame(){
        game = this;
    }

    @Override
    public void create() {
        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);

        FreeTypeFontGenerator fontGenerator = new
            FreeTypeFontGenerator(Gdx.files.internal("assets/OpenSans.ttf"));

        FreeTypeFontParameter fontParameters =new FreeTypeFontParameter();
        fontParameters.size = 48;
        fontParameters.color = Color.WHITE;
        fontParameters.borderWidth = 2;
        fontParameters.borderColor = Color.BLACK;
        fontParameters.borderStraight = true;
        fontParameters.minFilter = TextureFilter.Linear;
        fontParameters.magFilter = TextureFilter.Linear;

        BitmapFont customFont = fontGenerator.generateFont(fontParameters);

        labelStyle = new LabelStyle();
        labelStyle.font = customFont;
    }

    /**
     * wird benutzt um zwischen den Screens zu wechseln
     * @param screen
     */
    public static void setActiveScreen(BaseScreen screen){
        game.setScreen(screen);
    }
}
