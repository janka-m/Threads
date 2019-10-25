import javafx.scene.control.Label;

public class FibonacciRunnable implements Runnable {

	private long n;
	private Label label;

	public FibonacciRunnable(long n, Label label) {
		this.n = n;
		this.label = label;

	}

	@Override
	public void run() {
		long erg = fibonacci(n);
		label.setText("" + erg);
	}

	private long fibonacci(long n) {
		if (n < 2) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}

	}

}
