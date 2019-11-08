public class BinaryHeap {
	//Priority queue implementation: use array-based binary heap

	int[] data;
	int size;
	//lower # at top of tree --> for highest priority: min heap

	public BinaryHeap() {
		data = new int[10];
		size = 0;
	}

	public void add(int priority) {
		if(size == data.length)
			grow_array();

		data[size++] = priority;

		int child = size - 1;
		int parent = (child-1)/2;

		while(parent >= 0 && data[parent] > data[child]) {
			swap(data,parent,child);
			child = parent;
			parent = (child-1)/2;
		}
	}

	public void swap(int[] data, int child, int parent) {
		int temp = data[child];
		data[child] = data[parent];
		data[parent] = temp;
	}

	public void grow_array() {
		int[] new_data = (int[]) new int[data.length *2]; //double the array
		for(int i = 0; i < data.length; i++) {
			new_data[i] = data[i];
		}
		data = new_data;
	}

	//removes first item from heap -- top of heap -- lowest priority
	public int remove() {
		int temp = data[0];
		data[0] = data[--size]; //removing from arr, so size decrements
		siftdown(0);
		return temp;
	}

	public void siftdown(int parent) { //find children, compare with each other, compare with parent, and swap
		int child = parent*2 + 1; //left child
		
		if(child >= size)
			return;

		if(((child+1)<size) && (data[child+1] < data[child])) {
			child+= 1; //right child
		}
		if(data[parent]>data[child]) {
			swap(data,child,parent);
			siftdown(child);
		}
	}
	//log n times

}
	//log n running time for insert and remove

