
public class Cliente implements Runnable{
    
    private Bilheteria bilheteria;
    
    public Cliente(Bilheteria bilheteria){
        this.bilheteria = bilheteria;
    }
    
    public void run(){
        String nome = Thread.currentThread().getName();
        bilheteria.venderIngresso(nome);
    }
    
}

