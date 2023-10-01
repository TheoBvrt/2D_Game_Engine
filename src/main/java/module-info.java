module ch.bouverat.engine.game_engine {
    requires javafx.controls;
    requires javafx.fxml;

    exports ch.bouverat.engine.game_engine.utils;
    exports ch.bouverat.engine.game_engine.settings;
    exports  ch.bouverat.engine.game_engine.core.enums;

    opens ch.bouverat.engine.game_engine to javafx.fxml;
    exports ch.bouverat.engine.game_engine;
    exports ch.bouverat.engine.game_engine.controller;
    opens ch.bouverat.engine.game_engine.controller to javafx.fxml;
    exports ch.bouverat.engine.game_engine.core;
    opens ch.bouverat.engine.game_engine.core to javafx.fxml;
    exports ch.bouverat.engine.game_engine.component;
    opens ch.bouverat.engine.game_engine.component to javafx.fxml;
    exports ch.bouverat.engine.game_engine.game;
    opens ch.bouverat.engine.game_engine.game to javafx.fxml;
}