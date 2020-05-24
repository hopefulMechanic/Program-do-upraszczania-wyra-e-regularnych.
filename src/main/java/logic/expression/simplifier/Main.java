package logic.expression.simplifier;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length==0 || args[0].contains("pomoc") || args[0].contains("help")) {
            pomoc();
        } else {
            Tabela tabela = new Tabela(args[0]);
            List<String> uproszczone = tabela.uproszczone();
            System.out.println("\nWyrazenie logiczne do uproszczenia:\t" + args[0] +
                    "\nUproszczona forma:\n" + String.join("\nlub\n", uproszczone));
        }
    }

    private static void pomoc() {
        System.out.println("Dozwolone symbole  logiczne:\nAND\t\tOR\t\tNOT\t\tXOR\t\tXNOR\t\tFALSE\t\tTRUE\t\t(\t\t)"
                + "\nnp. \"((NOT A XOR B) XNOR C) AND (B AND A) NOR B OR FALSE\"");
    }
}
