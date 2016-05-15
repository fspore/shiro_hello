package org.lx.patterns.behavior.interpreter.junk;

import java.util.ArrayList;

//Context 
public class InterpreterContext {
	// assume web service is setup
	private AmazonWebService webService;

	public InterpreterContext(String endpoint) {
		// create the web service.
	}

	public ArrayList<Movie> getAllMovies() {
		return webService.getAllMovies();
	}

	public ArrayList<Book> getAllBooks() {
		return webService.getAllBooks();
	}
}
