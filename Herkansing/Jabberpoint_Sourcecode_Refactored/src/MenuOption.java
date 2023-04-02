import java.awt.*;

public abstract class MenuOption {
    Presentation presentation;
    Frame parent;
    Menu menu;

    public MenuOption(Presentation presentation, Frame parent, Menu menu){
        this.presentation = presentation;
        this.parent = parent;
        this.menu = menu;
    }
}
