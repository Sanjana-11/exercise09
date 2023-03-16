package exercise09;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Browser browser = new Browser();
		String[] urls = { "www.google.com", "www.facebook.com", "www.amazon.com", "www.netflix.com",
				"www.twitter.com" };

		Thread readerThread = new Thread(() -> {
			int index = 0;
			while (true) {
				String url = urls[index];
				index++;
				if (index == urls.length) {
					index = 0;
				}
				browser.addHistory(url);

				ArrayList<String> history = browser.getHistory();
				System.out.println("History: " + history);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread deleterThread = new Thread(() -> {
			while (true) {
				browser.clearHistory();
				System.out.println("History cleared");

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		readerThread.start();
		deleterThread.start();
	}

}
