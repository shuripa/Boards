package examples.movies;

public class RentalTest {
    public static void main(String[] args) {

        boolean test = true;
        Customer Ivanov = new Customer("Ivanov");
        Customer Petrov = new Customer("Petrov");
        Customer Sidorov = new Customer("Sidorov");

        Movie kingKong = new Movie("King Kong", 0);
        Movie kingLeon = new Movie("King Leon", 2);
        Movie terminator = new Movie("Terminator", 1);

        Rental rentIvanov = new Rental(kingKong, 1);
        Ivanov.addRental(new Rental(kingKong, 1));
        Petrov.addRental(new Rental(kingLeon, 4));
        Sidorov.addRental(new Rental(terminator, 4));

        //Самопроверка

//        System.out.println(Ivanov.htmlStatement());
//        System.out.println(Petrov.htmlStatement());
//        System.out.println(Sidorov.htmlStatement());

        if (Ivanov.statement().equals("Прокат Ivanov\n" +
                "\tKing Kong\t2.0\n" +
                "Сумма задолженности: 2.0\n" +
                "Вы заработали 1 бонусных очков")) {
//            System.out.println("Ivanov statement is OK");
        } else {
            test = false;
            System.out.println("\n Error in Ivanov statement");
        }

        if (Ivanov.htmlStatement().equals(
                "<H1>Прокат <EM>Ivanov</EM></H1><P>\n" +
                "King Kong: 2.0<BR>\n" +
                "<P> Сумма задолженности <EM>2.0</EM><P>\n" +
                "Вы заработали <EM>1</EM> бонусных очков <P>"
                ))
        {
//            System.out.println("Ivanov html statement is OK");
        }
        else{
            test = false;
            System.out.println("\n Error in Ivanov html statement");
        }

        if (Petrov.statement().equals(
                "Прокат Petrov\n" +
                "\tKing Leon\t3.0\n" +
                "Сумма задолженности: 3.0\n" +
                "Вы заработали 1 бонусных очков")
        ) {
//            System.out.println("OK");
        } else {
            test = false;
            System.out.println("\n Error in Petrov statement");
        }

        if (Petrov.htmlStatement().equals(
                "<H1>Прокат <EM>Petrov</EM></H1><P>\n" +
                        "King Leon: 3.0<BR>\n" +
                        "<P> Сумма задолженности <EM>3.0</EM><P>\n" +
                        "Вы заработали <EM>1</EM> бонусных очков <P>"
        ))
        {
//            System.out.println("Petrov html statement is OK");
        }
        else{
            test = false;
            System.out.println("\n Error in Petrov html statement");
        }

        if (Sidorov.statement().equals(
                "Прокат Sidorov\n" +
                        "\tTerminator\t3.0\n" +
                        "Сумма задолженности: 3.0\n" +
                        "Вы заработали 2 бонусных очков")
        ) {
//            System.out.println("OK");
        } else {
            test = false;
            System.out.println("\n Error in Sidorov statement");
        }

        if (Sidorov.htmlStatement().equals(
                "<H1>Прокат <EM>Sidorov</EM></H1><P>\n" +
                        "Terminator: 3.0<BR>\n" +
                        "<P> Сумма задолженности <EM>3.0</EM><P>\n" +
                        "Вы заработали <EM>2</EM> бонусных очков <P>"
        ))
        {
//            System.out.println("Sidorov html statement is OK");
        }
        else{
            test = false;
            System.out.println("\n Error in Sidorov html statement");
            System.out.println(Sidorov.htmlStatement());
        }


        if (test) System.out.println("\n OK");

    }
}
