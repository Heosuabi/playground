package eu.scilled.javafx.util;

import eu.scilled.logging.GuiComponentAppender;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Console extends StackPane {
    private Logger logger = LoggerFactory.getLogger(Console.class);

    public Console() {
        BorderPane consolePane = new BorderPane();
        TextArea output = new TextArea();
        consolePane.setCenter(output);
        TextField input = new TextField();
        input.setPromptText("Input command...");
        consolePane.setBottom(input);

        Tab consoleTab = new Tab();
        consoleTab.setText("Console");
        consoleTab.setClosable(false);
        consoleTab.setContent(consolePane);

        Tab logTab = new Tab();
        logTab.setText("Log");
        logTab.setClosable(false);
        LogViewer log = new LogViewer();
        GuiComponentAppender.addLogComponent("AREA", log);
        logTab.setContent(log);

        TabPane tabs = new TabPane();
        tabs.getTabs().addAll(consoleTab, logTab);

        getChildren().add(tabs);
        logger.debug("Console started.");
        logger.debug("Another log message.");
    }
}
