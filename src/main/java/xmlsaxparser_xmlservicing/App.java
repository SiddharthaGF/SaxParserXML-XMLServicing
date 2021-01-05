package main.java.xmlsaxparser_xmlservicing;

/*
    author: @pablo_guerra_6502, @andre_robalino_6481
*/

public class App {
    public static void main(String[] args) {
        SaxParser sp = new SaxParser("https://guarded-springs-28309.herokuapp.com/employees");
        try 
        {
            sp.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}