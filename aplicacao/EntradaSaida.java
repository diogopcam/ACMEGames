package aplicacao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class EntradaSaida {
    private Scanner entrada = null; 
    //DEFINE A ENTRADA DE DADOS                // Atributo para entrada de dados (entrada)
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela(console) (saida)
    //SAIDA 

    // Construtor
    public EntradaSaida() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
            entrada = new Scanner(streamEntrada);  
            PrintStream streamSaida = new PrintStream(new File("dadosout.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);

        // Implemente aqui o seu codigo adicional do construtor
    }

    // Restaura E/S padrao de tela(console)/teclado
    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }
}
