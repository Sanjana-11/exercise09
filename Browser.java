package exercise09;

import java.util.ArrayList;

public class Browser {
	private ArrayList<String> history;

	public Browser() {
		this.history = new ArrayList<>();
	}

	public synchronized void addHistory(String url) {
		history.add(url);
	}

	public synchronized ArrayList<String> getHistory() {
		return new ArrayList<>(history);
	}

	public synchronized void clearHistory() {
		history.clear();
	}
}
