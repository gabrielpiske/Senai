class MinhaThread extends Thread{
    private int tempo;
    private String nmThread;

    public MinhaThread(int tempo, String nmThread) {
        this.tempo = tempo;
        this.nmThread = nmThread;
    }

    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Executando: " + nmThread + " valor do contador: " + i);
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MinhaThread thread_1 = new MinhaThread(500, "Thread 1");
        thread_1.start();

        MinhaThread thread_2 = new MinhaThread(3000, "Thread 2");
        thread_2.start();

        System.out.println("Programa Finalizado");
    }
}
