package org.lx.patterns.behavior.interpreter.junk;

//client 
public class AmazonClient {
	private InterpreterContext context;

	public AmazonClient(InterpreterContext context) {
		this.context = context;
	}

	public AmazonClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * * Interprets a string input of the form * movies | books by title | year
	 * | name '<string>'
	 */
	public String interpret(String expression) {
		// we need to parse the string to determine which expression to use
		AbstractExpression exp = null;
		String[] stringParts = expression.split(" ");
		String main = stringParts[0];
		String sub = stringParts[2];
		// get the query part
		String query = expression.substring(expression.indexOf("'"),
				expression.lastIndexOf("'"));// firstindexof FIXME
		if (main.equals("books")) {
			if (sub.equals("title")) {
				exp = new BookTitleExpression(query);
			}
			if (sub.equals("year")) {
				exp = new BookYearExpression(query);
			} else if (main.equals("movie")) {
				// similar statements to create movie expressions
			}
			if (exp != null) {
				exp.interpret(context);
			}
		}
		return query;
	}

	public static void main(String[] args) {
		InterpreterContext context = new InterpreterContext(
				"http://aws.amazon.com/");
		AmazonClient client = new AmazonClient();
		// run a query
		String result = client.interpret("books by author 'John Connolly'");
		System.out.println(result);
	}
}
