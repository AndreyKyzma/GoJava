package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.DataStorage;
import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.Quote;

import java.util.List;
import java.util.Random;

public class MainPageModel {

	private DataStorage storage;
	private List<Category> categories;

	public MainPageModel(DataStorage storage) {
		this.storage = storage;
		update();
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public Category getCategory(int index) {
		return categories.get(index);
	}

	public String getRandomQuote() {
		Random generator = new Random();
		List<Quote> quotes = storage.getQuotes();
		Quote randomQuote = quotes.get(generator.nextInt(quotes.size()));
		String result = String.format("%s\n%s", randomQuote.getText(),
				randomQuote.getAuthor());
		return result;
	}

	public int size() {
		return categories.size();
	}

	private void update() {
		categories = storage.getCategories();
	}
}
