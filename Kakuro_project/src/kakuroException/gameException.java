package kakuroException;

public class gameException extends Exception{
	
	private static final long serialVersionUID = 1L;
	protected String err = "Exception error: ";
	
	public gameException(String s){
		err=err.concat(s);
	}
	
	public String toString(){
		return err;
	}
}


