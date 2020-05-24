package logic.expression.simplifier;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;

public class Tabela {

    private String wyrazenieLogiczne;

    private String[] zmienne;

    private LogicLexer lexer;

    private LogicParser parser;

    private boolean[][] tablica;

    private boolean[] wyniki;

    public Tabela(String wyrazenieLogiczne) {
        this.wyrazenieLogiczne = wyrazenieLogiczne;
        this.inicjalizacja();
        stworzTabelePrawdy();
    }

    private void inicjalizacja() {
        ArrayList<String> zmienne = new ArrayList<>();
        CodePointCharStream codePointCharStream = CharStreams.fromString(wyrazenieLogiczne);
        LogicLexer logicLexer = new LogicLexer(codePointCharStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(logicLexer);
        LogicParser logicParser =  new LogicParser(commonTokenStream);
        ParseTreeWalker.DEFAULT.walk(new LogicBaseListener() {
            @Override
            public void enterIdentifierExpression(LogicParser.IdentifierExpressionContext ctx) {
                zmienne.add(ctx.children.get(0).getText());
            }
        }, logicParser.parse());
        this.zmienne = (String[]) zmienne.stream().distinct().toArray(String[]::new);
    }

    public void stworzTabelePrawdy() {
        int liczbaZmiennych = zmienne.length;
        int liczbaKombinacji = (int) Math.pow(2, liczbaZmiennych);
        this.wyniki = new boolean[liczbaKombinacji];

        this.tablica = new boolean[liczbaKombinacji][liczbaZmiennych];
        byte b = 0b0;
        for(int i = 0; i < liczbaKombinacji; i++) {
            for(int j = 0; j < liczbaZmiennych; j++) {
                tablica[i][j] = (b & (1 << j)) != 0;
            }
            odwroc(tablica[i]);
            b++;
        }

        Map<String, Object> tymczasowe = new HashMap<>();
        for(int i = 0; i < liczbaKombinacji; i++) {
            for(int j = 0; j < liczbaZmiennych; j++) {
                tymczasowe.put(zmienne[j], tablica[i][j]);
            }
            lexer = new LogicLexer(CharStreams.fromString(wyrazenieLogiczne));
            parser = new LogicParser(new CommonTokenStream(lexer));
            Object wynik = new MojLogicBaseVisitor(tymczasowe).visit(parser.parse());
            wyniki[i] = (boolean) wynik;
            tymczasowe.clear();
        }
    }

    private boolean[] odwroc(boolean[] doOdwrocenia) {
        for(int i = 0; i < doOdwrocenia.length / 2; i++) {
            boolean temp = doOdwrocenia[i];
            doOdwrocenia[i] = doOdwrocenia[doOdwrocenia.length - i - 1];
            doOdwrocenia[doOdwrocenia.length - i - 1] = temp;
        }
        return doOdwrocenia;
    }

    public List<String> uproszczone() {
        ArrayList<String> uproszczone = new ArrayList<>();
        for(int i = 0; i < wyniki.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (wyniki[i]) {
                for(int j = 0; j < tablica[0].length; j++) {
                    if(tablica[i][j]) {
                        sb.append(" ").append(zmienne[j]);
                    } else {
                        sb.append(" ~").append(zmienne[j]);
                    }
                }
                uproszczone.add(sb.toString());
            }
        }
        return uproszczone;
    }
}
