public class Main
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		Bilheteria b = new Bilheteria();
		
		for(int i = 1; i <= 25;i++){
		    Thread cliente = new Thread(new Cliente(b),"Cliente "+ i);
		    cliente.start();
		    
		    //new Thread(new Cliente(b),"Cliente "+ i).start();
		}
		
	}
}


