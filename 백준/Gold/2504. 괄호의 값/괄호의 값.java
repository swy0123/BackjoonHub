import java.util.*;
import java.io.*;

//괄호의 값
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Stack<String> stack = new Stack<>();
		
		int idx = 0;
		while(idx<input.length()) {
			char c = input.charAt(idx);
			if(!(c=='(' || c==')' || c=='[' || c==']')) {
				System.out.println(0);
				return;
			}
			if(c == '(') {
				stack.add("(");
			}
			else if(c == ')') {
				if(stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				if(stack.peek().charAt(0)=='(') {
					stack.pop();
					stack.add("2");
				}
				else {
					int next = 0;
					while(true) {
						if(stack.isEmpty()) {
							System.out.println(0);
							return;
						}
						if(stack.peek().charAt(0)=='(') {
							stack.pop();
							next*=2;
							stack.add(Integer.toString(next));
							break;
						}
						else if(stack.peek().charAt(0)=='[') {
							System.out.println(0);
							return;
						}
						else if(stack.peek().charAt(0)==']') {
							System.out.println(0);
							return;
						}
						next += Integer.parseInt(stack.pop());
					}
				}
			}
			else if(c == '[') {
				stack.add("[");
			}
			else if(c == ']') {
				if(stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				if(stack.peek().charAt(0)=='[') {
					stack.pop();
					stack.add("3");
				}
				else {
					int next = 0;
					while(true) {
						if(stack.isEmpty()) {
							System.out.println(0);
							return;
						}
						if(stack.peek().charAt(0)=='[') {
							stack.pop();
							next*=3;
							stack.add(Integer.toString(next));
							break;
						}
						else if(stack.peek().charAt(0)=='(') {
							System.out.println(0);
							return;
						}
						else if(stack.peek().charAt(0)==')') {
							System.out.println(0);
							return;
						}
						next += Integer.parseInt(stack.pop());
					}
				}
			}
			idx++;
		}
		int answer = 0;
		while(!stack.isEmpty()) {
			if(!(stack.peek().charAt(0)<='9' && stack.peek().charAt(0)>='0')) {
				System.out.println(0);
				return;
			}
			answer += Integer.parseInt(stack.pop());
		}
		System.out.println(answer);
	}
}