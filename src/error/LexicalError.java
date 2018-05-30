package error;

public class LexicalError extends ZError {
    public LexicalError(String msg) {
	_msg = msg;
    }

    public String getError() {
	return _msg;
    }
}
