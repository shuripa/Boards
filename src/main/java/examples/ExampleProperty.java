package examples;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExampleProperty {
    public static void main(String[] args) {
        testUser();
        // Result:
        // User: ReadOnlyStringProperty [bean: examples.User@5ce65a89, name: userName, value: Александр]
        // Pass: StringProperty [bean: examples.User@5ce65a89, name: password, value: 1234]
        // Result2:
        // User: Александр Pass: 1234
        // Result3:
        // User: Александр Pass: 1234
        // Result4:
        // User: Александр Pass: 1234
        // несмотря на то, что поле private final static String PASSWORD_PROP_NAME = "password";

        testEmployer();
        // Result:
        // John Smidt
        // John Smidt
        // John Johnson
    }

    private static void testUser() {
        User user = new User();
        user.setPassword("1234");
        System.out.println("User: " + user.userNameProperty() + " Pass: " + user.passwordPtoperty());
        System.out.println("User: " + user.userNameProperty().get() + " Pass: " + user.passwordPtoperty().get());
        System.out.println("User: " + user.getUserName() + " Pass: " + user.getPassword());
        user.setPassword("12345");
        System.out.println("User: " + user.userNameProperty().get() + " Pass: " + user.passwordPtoperty().get());
        User user1 = new User();
        System.out.println("User 1:" + user1.getPassword());
    }

    static void testEmployer(){
        Employer e = new Employer();
        e.firstName.set("John");
        System.out.println(e.firstName.get() + " " + e.readOnlyLastName.get());
        e.lastNeme = new ReadOnlyStringWrapper("Johnson");
        System.out.println(e.firstName.get() + " " + e.readOnlyLastName.get());
        e.readOnlyLastName = e.lastNeme.getReadOnlyProperty();
        System.out.println(e.firstName.get() + " " + e.readOnlyLastName.get());
    }
}

class User {
//    Создаем две констранты для названий свойств
    private final static String USERNAME_PROP_NAME = "userName";
    private final static String PASSWORD_PROP_NAME = "password";
//    Создаем два свойства
    private final ReadOnlyStringWrapper userName;
    private final StringProperty password;
//    Конструктор
    User() {
        this.userName = new ReadOnlyStringWrapper(this, USERNAME_PROP_NAME, System.getProperty("user.name"));
        password = new SimpleStringProperty(this, PASSWORD_PROP_NAME, "");
    }
//    Гетеры и сеттеры присутствуют для совместимости с JavaBean, что может пригодиться
//    при разработке компонет, которые будут использоваться стороними разработчиками.
//    Однако и геттеры и сеттеры обозначены как final, что предотвращает наследование
//    их для любых наследующих классов.
    public final String getUserName(){
        return userName.get();
    }

    public ReadOnlyStringProperty userNameProperty(){
        return userName.getReadOnlyProperty();
    }

    public final String getPassword(){
        return password.get();
    }

    public final void setPassword(String password){
        this.password.set(password);
    }

    public StringProperty passwordPtoperty(){
        return password;
    }

}

class Employer{
    //Read-Write property
    StringProperty firstName = new SimpleStringProperty("Name");
    //ReadOnly property
    //ReadOnlyStringWrapper создает два синхронизированных свойства.
    //Одно свойство read-only и должно быть передано для внешнего использования,
    //другое свойство read-write и предназначено только для внутреннего использования.
    ReadOnlyStringWrapper lastNeme = new ReadOnlyStringWrapper("Smidt");
    ReadOnlyStringProperty readOnlyLastName = lastNeme.getReadOnlyProperty();
}
