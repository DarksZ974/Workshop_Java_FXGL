package com.WorkshopJava.app;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Node;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getUIFactoryService;


public class App extends GameApplication {

    Entity player;
    Entity enemy;
    public static void main(java.lang.String[] args) {
        launch(args);
    }

    @java.lang.Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setTitle("WorkshopJava");
        gameSettings.setWidth(1920);
        gameSettings.setHeight(1080);
    }

    @java.lang.Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new Factory());
        player = FXGL.entityBuilder().at(100, 100).view(new Rectangle(25, 25, Color.BLUE)).buildAndAttach();
        enemy = FXGL.spawn("enemy", 350, 300);
    }

    @java.lang.Override
    protected void initInput() {
        FXGL.onKeyDown(KeyCode.DOWN, () -> {
            player.translateY(10);
        });
        FXGL.onKeyDown(KeyCode.UP, () -> {
            player.translateY(-10);
        });
        FXGL.onKeyDown(KeyCode.RIGHT, () -> {
            player.translateX(10);
        });
        FXGL.onKeyDown(KeyCode.LEFT, () -> {
            player.translateX(-10);
        });
    }

    @java.lang.Override
    protected void initUI() {
        Text text = getUIFactoryService().newText("some text", Color.BLACK, 22);
        FXGL.getGameScene().addUINode(text);
        text.setTranslateY(20);
        text.setTranslateX(10);
    }
}
