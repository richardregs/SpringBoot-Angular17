package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1947545396181899065L;
	
	public ServiceException() {
		
	}
	
	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writebleStackTrace) {
		super(message, cause, enableSuppression, writebleStackTrace);
	}
}
