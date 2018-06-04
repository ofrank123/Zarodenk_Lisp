package error;

public class RuntimeError extends ZError {
    public RuntimeError(String msg) {
	_msg = msg;
    }

    public String getError() {
	return _msg;
    }
}
