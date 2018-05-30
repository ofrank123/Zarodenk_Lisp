package error;

public class SyntacticalError extends ZError {
    public SyntacticalError(String msg) {
	_msg = msg;
    }

    public String getError() {
	return _msg;
    }
}
