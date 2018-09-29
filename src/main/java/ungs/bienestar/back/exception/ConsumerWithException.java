package ungs.bienestar.back.exception;

import java.util.function.Consumer;

@FunctionalInterface
public interface ConsumerWithException<T, E extends Exception> {

	void accept(T t) throws E;

	public static <T> Consumer<T> wrapper(ConsumerWithException<T, Exception> throwingConsumer) {

		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}
}
