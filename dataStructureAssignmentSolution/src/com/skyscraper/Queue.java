package com.dataStructureAssignmentSolution.skyscraper;

import java.util.ArrayList;


public class Queue<T> {

    private int FRONT;
    private int REAR;
    private int MAX_SIZE;
    private ArrayList<T> queue;

    public Queue(int size) {
        this.FRONT = -1;
        this.REAR = -1;
        this.MAX_SIZE = size;
        this.queue = new ArrayList<>();
    }

    public boolean isFull() {
        return REAR == MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return FRONT == -1;
    }

    public boolean enqueue(T data) {
        if (!isFull()) {
            REAR++;
            queue.add(REAR, data);
            if (FRONT == -1) {
                FRONT = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean dequeue() {
        if (FRONT == REAR) {
            FRONT = -1;
            REAR = -1;
        } else {
            FRONT++;
        }
        return !isEmpty();
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue - []");
            return;
        }
        System.out.print("Queue - FRONT = " + FRONT + " [");
        for (int i = FRONT; i <= REAR; i++) {
            System.out.print(queue.get(i) + " ");
        }
    }

    public T peek(){
        return queue.get(FRONT);
    }

    public int getFRONT() {
        return FRONT;
    }

    public int getREAR() {
        return REAR;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public ArrayList<T> getQueue() {
        return queue;
    }

    public boolean contains(T floorToBeChecked) {
        return queue.contains(floorToBeChecked);
    }
}