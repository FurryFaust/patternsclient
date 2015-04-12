package com.furryfaust.patterns;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.furryfaust.patterns.screens.*;

public class Core extends Game {

    public Assets assets;
    public Manager manager;
    public Files files;
    public StartScreen startScreen;
    public PlayScreen playScreen;
    public LevelScreen levelScreen;
    public LogScreen logScreen;
    public CreditScreen creditScreen;
    public HelpScreen helpScreen;

    @Override
    public void create() {
        assets = new Assets();
        manager = new Manager();
        files = new Files();
        startScreen = new StartScreen(this);
        playScreen = new PlayScreen(this);
        levelScreen = new LevelScreen(this);
        logScreen = new LogScreen(this);
        creditScreen = new CreditScreen(this);
        helpScreen = new HelpScreen(this);
        if (Gdx.files.local("seenhelp").exists()) {
            setScreen(startScreen);
        } else {
            setScreen(helpScreen);
            Gdx.files.local("seenhelp").write(false);
        }
    }

}