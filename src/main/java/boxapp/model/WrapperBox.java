package boxapp.model;

public class WrapperBox {

	private static final String SECURE="Secure(%s)";
	private static final String NON_SECURE="%s";
	public static String getSecureLog(String logs) {
		return String.format(SECURE, logs);
	}
public static String getNonSecureLog(String logs) {
	return String.format(NON_SECURE, logs);
	}
}
