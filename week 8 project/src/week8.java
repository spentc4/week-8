import java.lang.reflect.Array;
import java.util.*;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
public class week8 {
//this is a bubble sort
public static void bubbleSort(int[] a) {
	int[] arr = new int[10000];
	boolean sort = false;
	int temp;
	while(!sort) {
		sort = true;
		for (int i = 0; i <arr.length - 1; i++ ) {
			if (a[i] > a[i+1]) {
				temp = a[i+1];
				a[i] = a[i+1];
				a[i+1] = temp;
				sort = false;
			}
		}
	}
}
// this is an insertion sort
public static void insertionSort(int[] arr) {
	for (int i = 1; i < arr.length; i++) {
	int current = arr[i];
	int j = i - 1;
	while(j >= 0 && current < arr[j]) {
		arr[j+1] = arr[j];
		j--;
	}
	arr[j+1]=current;
	}
}
// this is a selection sort
public static void selectionSort(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
		int min = arr[i];
		int minI = i;
		for(int j = i+1; j < arr.length; j++) {
			if (arr[j] < min) {
				min = arr[j];
				minI = j;
			}
		}
		int temp = arr[i];
		arr[i] = min;
		arr[minI] = temp;
	}
}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		int[] array = new int[10000];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*10000000);
		}
		Instant start = Instant.now();
		methodToTime();
		bubbleSort(array);
		System.out.print("Sorted by bubble \n");

		for (int element: array) {
			System.out.println(element);
		}
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		
		Instant start1 = Instant.now();
		methodToTime();
		insertionSort(array);
		System.out.print("Sorted by insertion \n");

		for (int element: array) {
			System.out.println(element);
		}
		Instant finish1 = Instant.now();
		long timeElapsed1 = Duration.between(start1, finish1).toMillis();
		
		Instant start2 = Instant.now();
		methodToTime();
		selectionSort(array);
		System.out.print("Sorted by selection \n");

		for (int element: array) {
			System.out.println(element);
		}
		Instant finish2 = Instant.now();
		long timeElapsed2 = Duration.between(start2, finish2).toMillis();

		System.out.println("the bubble sort took this amount of time: " + timeElapsed + "\n");
		System.out.println("the insertion sort took this amount of time: " + timeElapsed1 + "\n");
		System.out.println("the selection sort took this amount of time: " + timeElapsed2 + "\n");


		
	}
	private static void methodToTime() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
