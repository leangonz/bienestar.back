package ungs.bienestar.back.exception;

@FunctionalInterface
public interface FunctionWithException<T, R, E extends Exception> {

	R apply(T t) throws E;
}
