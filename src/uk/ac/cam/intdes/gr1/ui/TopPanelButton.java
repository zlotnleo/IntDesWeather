package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.beans.NamedArg;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;


public class TopPanelButton extends Pane {
    public TopPanelButton(@NamedArg("click handler") @Nullable EventHandler<? super MouseEvent> onClick, @NamedArg("background") @Nullable Background bg){
        super();
        if(onClick != null)
            addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
        if(bg != null)
            setBackground(bg);
    }
}
