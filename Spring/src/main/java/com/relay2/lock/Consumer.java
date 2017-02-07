package com.relay2.lock;

public class Consumer implements Runnable {

	private Producer d;

	public Consumer(Producer d) {
		this.d = d;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			d.deliver();
		}
	}

}
