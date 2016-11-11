public class OptionInexistanteException extends Exception {

    /**
     * Creates a new instance of <code>OptionInexistanteException</code> without
     * detail message.
     */
    public OptionInexistanteException() {
    }

    /**
     * Constructs an instance of <code>OptionInexistanteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public OptionInexistanteException(String msg) {
        super(msg);
    }
}
