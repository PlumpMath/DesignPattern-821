package designParttens.interpretePattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class InterpretePattern {
	public static void main(String[] args) throws IOException {
		String expStr=getExpStr();
		HashMap<String,Integer> var=getValue(expStr);
		Cal c=new Cal(expStr);
		System.out.println(expStr+"="+c.run(var));
	}
	public static String getExpStr() throws IOException{
		System.out.println("enter the expression");
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}
	public static HashMap<String,Integer> getValue(String expStr) throws IOException{
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(char c:expStr.toCharArray()){
			if(c!='+'&&c!='-'){
				if(!map.containsKey(String.valueOf(c))){
					String in=(new BufferedReader(new InputStreamReader(System.in))).readLine();
					map.put(String.valueOf(c),Integer.valueOf(in));
				}
			}
		}
		return map;
	}
}
abstract class Expression{
	public abstract int interprete(HashMap<String,Integer> var);
}
//interprete variables, key is parameter and value is the real value
class VarExpression extends Expression{
	private String key;
	public VarExpression(String _key){
		this.key=_key;
	}
	public int interprete(HashMap<String ,Integer> var){
		return var.get(this.key);
	}
}
//symbol interprete
abstract class SymbolExpression extends Expression{
	protected Expression right;
	protected Expression left;
	public SymbolExpression(Expression _right,Expression _left){
		this.right=_right;
		this.left=_left;
	}
}
class AddExpression extends SymbolExpression{
	public AddExpression(Expression right,Expression left){
		super(right,left);
	}
	public int interprete(HashMap<String,Integer> var){
		return super.right.interprete(var)+super.left.interprete(var);
	}
}
class SubExpression extends SymbolExpression{
	public SubExpression(Expression right,Expression left){
		super(right,left);
	}
	public int interprete(HashMap<String,Integer> var){
		return super.left.interprete(var)-super.right.interprete(var);
	}
}
class Cal{
	private Expression expression;
	public Cal(String expStr){
		Stack<Expression> stack=new Stack<Expression>();
		//expression is broken up into character array
		char[] charArray=expStr.toCharArray();
		Expression right=null;
		Expression left=null;
		for(int i=0;i<charArray.length;i++){
			switch(charArray[i]){
				case '+':
					left=stack.pop();
					right=new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new AddExpression(right,left));
					break;
				case '-':
					left=stack.pop();
					right=new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new SubExpression(right,left));
					break;
				default:
					stack.push(new VarExpression(String.valueOf(charArray[i])));
			}
		}
		this.expression=stack.pop();
	}
	public int run(HashMap<String,Integer> var){
		return this.expression.interprete(var);
	}
}
