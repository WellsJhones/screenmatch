import java.time.LocalDate;
import java.time.Month;



public class Niver {
    public static void main(String[] args) {

                LocalDate hoje = LocalDate.now();
                System.out.println(hoje);
                LocalDate aniversarioAlice = LocalDate.of(1992, Month.OCTOBER, 15);
                System.out.println(aniversarioAlice);

                int idade =  hoje.getYear() - aniversarioAlice.getYear();
                System.out.println(idade);
            }

        }



