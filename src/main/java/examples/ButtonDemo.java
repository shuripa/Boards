package examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {
    JLabel jlab;
    public ButtonDemo (){
        //Создание нового контейнера JFrame.
        JFrame jfrm = new JFrame("A Button Example");
        //Установка диспетчера компоновки FlowLayout.
        jfrm.getContentPane().setLayout(new FlowLayout());
        //Установка исходного размера фрейма.
        jfrm.setSize(220,90);
        //Завершение программы при закрытии пользователем окна.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Создание двух кнопок.
        JButton jbtnFirst = new JButton("First");
        JButton jbtnSecond = new JButton("Second");
        //Связывание с кнопками обработчиков событий действия.
        jbtnFirst.addActionListener(this);
        jbtnSecond.addActionListener(this);
        //Добавление кнопок к панели содержимого.
        jfrm.getContentPane().add(jbtnFirst);
        jfrm.getContentPane().add(jbtnSecond);
        //Создание текстовой метки.
        jlab = new JLabel("Press a button.");
        //Включение метки в состав фрейма.
        jfrm.getContentPane().add(jlab);
        //Отображение фрейма.
        jfrm.setVisible(true);
    }

    //Обработка событий ActionEvent, связанных с кнопками.
    public void actionPerformed(ActionEvent e) {
        //Use comad action to the button identifier.
        if (e.getActionCommand().equals("First"))
            jlab.setText("FirstButton was pressed.");
        else
            jlab.setText("SecondButton was pressed.");
    }

    public static void main(String[] args) {
        //Создание фрейма в потоке обработки событий.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
