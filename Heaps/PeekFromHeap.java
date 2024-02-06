package Heaps;

import java.util.ArrayList;

public class PeekFromHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }
    }
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(5);

        System.out.println(heap.peek());
    }
}
