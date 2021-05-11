public class TesteComThread {
	public static void main(String[] args) {
		
		System.out.println(Thread.MAX_PRIORITY);
		
		Thread t = new Thread(() -> System.out.println("rodando..."));
		
		t.setPriority(Thread.MAX_PRIORITY);
		
		t.start();
	}
}
