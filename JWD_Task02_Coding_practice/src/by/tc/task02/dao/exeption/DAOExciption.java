package by.tc.task02.dao.exeption;

public class DAOExciption extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOExciption() {
		super();
	}

	public DAOExciption(String message, Throwable cause) {
		super(message, cause);

	}

	public DAOExciption(String message) {
		super(message);

	}

	public DAOExciption(Throwable cause) {
		super(cause);

	}

}
