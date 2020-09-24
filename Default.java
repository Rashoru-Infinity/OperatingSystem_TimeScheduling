import java.util.Random;

class Default{
	public static void main(String[] args) {
		Random rand = new Random();
		int process = 10000;
		System.out.println(process);
		int quantum = 5;
		System.out.println(quantum);
		for(int n = 0;n < process;n++) {
			int arrival = rand.nextInt(process * 10);
			int deadline = rand.nextInt(process * 25) + 1;
			int priority = rand.nextInt(10000);
			int remaining = rand.nextInt(10) + 1;
			System.out.println(arrival);
			System.out.println(deadline);
			System.out.println(priority);
			System.out.println(remaining);
		}
	}
}
