package graphics.editor.components;

import graphics.Layout;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public abstract class EditorButton extends LeyoutComponent {
    private String fileName;
    private String url;

    public EditorButton(String fileName){
        url = new StringBuilder().append("EditorButtons/").
                append(fileName).
                append(".png").toString();

    }

//    TODO: Аналіз.
//    Основне завдання для кнопки редактора - створити компонент. Але це не є завданням для всіх кнопок,
//    Хоча суперклас моделі, котроллер і вигляд можна булоб спроектувати більш загально.
//    Втім при потребі розшириня змінювати прийдеться лише суперклас. EditorButton на якийсь інший Button.
//    Контроллер і вигляд змінювати не прийдеться.

//    Чи можна повернути LeyoutComponent? Компонент не переймається тим що існують якісь ті чи інші контроллери.
//    Але в даному випадку компонент (кнопка) створює інший компонент (копозит лейауту). І це її завдання.
//    Про свій власний контроллер вона звичайно може і нічого не знати.

    public abstract LeyoutComponentController createComponent() throws IOException;

    public LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException{
        Layout layout = Layout.getInstace();
        LeyoutComponentController controller = createComponent();
        controller.setXY((int) x, (int) y);
        return controller;
    }


    public String getImageUrl(){
        return url;
    }

    @Override
    public String toString() {
        return fileName;
    }

}
