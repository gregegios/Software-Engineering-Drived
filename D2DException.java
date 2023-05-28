public class D2DException extends Exception {

    public D2DException() {
        super();
    }

    public D2DException(String exc) {
        super(exc);
        System.out.println(exc);
    }
}
