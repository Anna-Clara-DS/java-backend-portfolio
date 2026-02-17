
public class Bilheteria{
    
    private int ingressos = 20;
    
    public synchronized void venderIngresso(String cliente){
        
        if(this.ingressos > 0){
            System.out.println(cliente + " está tentando comprar...");
            try{
                Thread.sleep(1000);//tempo de esperado do cliente
            }catch(InterruptedException e){
                System.out.println("Erro com Thread");
            }
            this.ingressos--;
            System.out.println(cliente + " conseguiu comprar o ingresso, restam apenas "
                                    + this.ingressos);
            
        }else{
            System.out.println(cliente + " tentou comprar, mas infelizmente os esgotoram os ingressos");
        }
        
    }
    
}
