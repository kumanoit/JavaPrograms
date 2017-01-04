package com.kumanoit.others;

/**
 * MyInt class
 */
class MyInt {

  private int val;

  /**
   * constructor to initialize val
   * @param value
   */
  public MyInt(int value) {
    this.val = value;
  }

  /**
   * @return current value
   */
  public int getVal() {
    return val;
  }

  /**
   * decrements the value by 1
   */
  public void decrement() {
    this.val--;
  }
}

/**
 * Postfix class to compute value of postfix and infix notation
 */
public class Postfix {
  /**
   * Public recursive method.
   * @param exp
   * @param i which is length of input exp
   * @return postfix value
   */
  public static double recEval(String exp, MyInt i) {
    if (exp.charAt(i.getVal()) >= '0' && exp.charAt(i.getVal()) <= '9') {
      double value = Character.getNumericValue(exp.charAt(i.getVal()));
      i.decrement();
      return value;
    }
    char ch = exp.charAt(i.getVal());
    i.decrement();
    double b = recEval(exp, i);
    double a = recEval(exp, i);
    if (ch == '+') {
      return a + b;
    }
    else if (ch == '*') {
      return a * b;
    }
    else if (ch == '/') {
      return a / b;
    }
    return a - b;
  }

  /**
   * Public non-recursive
   * @param exp
   * @return evaluated exp value
   */
  public static double eval(String exp) {
    MyInt i = new MyInt(exp.length() - 1);
    return recEval(exp, i);
  }

  /** 
   * Public recursive method.
   * @param exp
   * @param i
   * @return infix notation
   */
  public static String recInfix(String exp, MyInt i) {
    if (exp.charAt(i.getVal()) >= '0' && exp.charAt(i.getVal()) <= '9') {
      String value = String.valueOf(exp.charAt(i.getVal()));
      i.decrement();
      return value;
    }
    char ch = exp.charAt(i.getVal());
    i.decrement();
    String b = recInfix(exp, i);
    String a = recInfix(exp, i);
    
    return "(" + a + ch + b + ")";
  }

  /**
   * Public non-recursive
   * @param exp
   * @return infix notation
   */
  public static String infix(String exp) {
    MyInt i = new MyInt(exp.length() - 1);
    return recInfix(exp, i);
  }

}
