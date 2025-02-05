class MinhaRunnable implements Runnable {
    private int tempo;
    private String nmThread;

    public MinhaRunnable(int tempo, String nmThread) {
        this.tempo = tempo;
        this.nmThread = nmThread;
    }

    public void run(){
        for(int i =0; i< 5; i++){
            System.out.println("Executando " + nmThread + " valor do contador: " + i);
            try{
                Thread.sleep(tempo);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}

public class App {
    public static void main(String[] args) throws Exception {
        MinhaRunnable minhaRunnable1 = new MinhaRunnable(1500, "Thread 1");
        MinhaRunnable minhaRunnable2 = new MinhaRunnable(4500, "Thread 2");
        
        Thread thread_1 = new Thread(minhaRunnable1);
        Thread thread_2 = new Thread(minhaRunnable2);
        
        thread_1.start();
        thread_2.start();

        System.out.println("Programa Finalizado");
    }
}
