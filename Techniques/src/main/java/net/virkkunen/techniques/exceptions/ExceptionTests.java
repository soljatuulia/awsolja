/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.techniques.exceptions;

/**
 *
 * @author jyrki
 */
public class ExceptionTests {
    
    
    /* 
      Toteuta tämä metodi siten, että käytät try-catchia tarkasti ja lähellä kohdetta,
      jossa poikkeus voi aiheutua
    */
    static int calculateWithExceptions(String calc){
//        String numbers[]=calc.split("[0-9]");
//        String plus[]=calc.split("[+-*/]");
//        int agregate = Integer.parseInt(operands[0]);
//        int o = 1;
//        for (int i = 0; i < operators.length; i++) {
//            if (operators[i].equals("+"))
//                agregate += Integer.parseInt(operands[o++]);
//            else if (operators[i].equals("-"))
//                agregate -= Integer.parseInt(operands[o++]);
//            else if (operators[i].equals("*"))
//                agregate *= Integer.parseInt(operands[o++]);
//            else if (operators[i].equals("/"))
//                agregate /= Integer.parseInt(operands[o++]);
//
        return 0;
    }

    /*
      Totauta tämä metodi siten, että metodin rungossa voi tapahtua mahdollisimman 
      vähän virheitä. Voit ensin palauttaa nollan, havaittuasi virheen.
      Sen jälkeen toteuta oma poikkeusluokka (CalculateException, 
      jolla viestit havaitsemastasi virheestä
    */
    static int calculateWithLessExceptions(String calc) throws MyException{
        if (calc == null) return 0;
        String parts[] = calc.split(" ");
        if (parts.length != 3) return 0;
        String operator = parts[1];
        int op1 = tryParse(parts[0]);
        if (op1 == Integer.MIN_VALUE) return 0;
        int op2 = tryParse(parts[2]);
        if (op2 == Integer.MIN_VALUE) return 0; 
        if (operator.equals("+")) return op1 + op2;
        if (operator.equals("*")) return op1 * op2;
        return 0;
    }
    
    static public int tryParse(String str) {
        try{
            int number = Integer.parseInt(str);
            System.out.println(number); 
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return Integer.MIN_VALUE;
    }
    
    static public void testExceptions(){
        try {
            System.out.println("Correct "+calculateWithExceptions("1 + 2"));
            System.out.println("Correct "+calculateWithExceptions("1 + a"));
            System.out.println("Correct "+calculateWithExceptions("1 +"));
            System.out.println("Correct "+calculateWithExceptions(null));
            System.out.println("Correct "+calculateWithLessExceptions("1 + 2"));
            System.out.println("Correct "+calculateWithLessExceptions("1 + a"));
            System.out.println("Correct "+calculateWithLessExceptions("1 +"));
            System.out.println("Correct "+calculateWithLessExceptions(null));
        }
        catch(Exception ex){
            System.out.println("Jotain meni pieleen, tänne ei pitäisi tulla");
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) throws MyException {
        testExceptions();
    }
}
