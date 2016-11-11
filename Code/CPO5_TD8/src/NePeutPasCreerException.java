public class NePeutPasCreerException extends Exception {

    /**
     * Creates a new instance of <code>NePeutPasCreerException</code> without
     * detail message.
     */
    public NePeutPasCreerException() {
    }

    /**
     * Constructs an instance of <code>NePeutPasCreerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NePeutPasCreerException(String msg) {
        super(msg);
    }
}
