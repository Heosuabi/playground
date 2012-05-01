package eu.scilled.javafx.util;

import eu.scilled.logging.LogAppendableComponent;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class LogViewer extends TextArea implements LogAppendableComponent {
    @Override
    public void append(final String log) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setText(getText() + log);
            }
        });
    }
}
