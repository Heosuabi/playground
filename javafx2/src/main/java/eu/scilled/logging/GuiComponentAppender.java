package eu.scilled.logging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.HashMap;
import java.util.Map;

public class GuiComponentAppender extends AppenderBase<ILoggingEvent> {
    private static final Map<String, LogAppendableComponent> COMPONENT_MAP = new HashMap<String, LogAppendableComponent>(5);
    private PatternLayout layout;

    public static void addLogComponent(String appenderName, LogAppendableComponent component) {
        COMPONENT_MAP.put(appenderName, component);
    }

    public static void removeLogComponent(String appenderName) {
        COMPONENT_MAP.remove(appenderName);
    }

    public void setPattern(String pattern) {
        layout = new PatternLayout();
        layout.setPattern(pattern);
        layout.setContext(getContext());
        layout.start();
    }

    @Override
    protected void append(final ILoggingEvent event) {
        if (layout != null) {
            LogAppendableComponent component = COMPONENT_MAP.get(getName());
            if (component != null) {
                component.append(layout.doLayout(event));
            }
        }
    }
}
