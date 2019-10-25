import javafx.concurrent.Task;

public class FibonacciTask extends Task<Long> {
	private Long n;

	public FibonacciTask(long n) {
		this.n = n;
	}

	@Override
	protected Long call() throws Exception {

		Long erg = fibonacci(n);
		return erg;
	}

	private long fibonacci(long n) {
		if (n < 2) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}

	}
}
