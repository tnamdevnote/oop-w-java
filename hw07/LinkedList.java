package hw07;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size = 0;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public Node<T> getHead() {
    return head;
  }
  public Node<T> getTail() {
    return tail;
  }

  public void addAtIndex(T data, int index) {
    if (index < 0 || index > this.size) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }
    if (data == null) {
      throw new IllegalArgumentException("You cannot add null data to the list");
    }
    
    int counter = 0;
    Node<T> newNode = new Node(data);
    Node<T> currentNode = head;

    if (index == 0) {
      newNode.setNext(currentNode);
      head = newNode;
    } else if (index == size - 1) {
      tail.setNext(newNode);
      tail = newNode;
    } else {
      while (counter != index - 1) {
        currentNode = currentNode.getNext();
        counter++;
      }
      newNode.setNext(currentNode.getNext());
      currentNode.setNext(newNode);
    }
    size++;
  }

  public T getAtIndex(int index) {
    if (index < 0 || index > (this.size - 1)) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    int counter = 0;
    Node<T> currentNode = head;

    while (counter != index) {
      currentNode = currentNode.getNext();
      counter++;
    }

    return currentNode.getData();
  }

  public T removeAtIndex(int index) {
    if (index < 0 || index > (this.size - 1)) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    int counter = 0;
    T removedData;
    Node<T> currentNode = head;


    if (index == 0) {
      removedData = currentNode.getData();
      head = currentNode.getNext();
    } else {
      // currentNode is 1 newNode behind the target index
      while (counter != index - 1) {
        currentNode = currentNode.getNext();
        counter++;
      }

      Node<T> targetNode = currentNode.getNext();

      if (targetNode.getNext() == null) {
        tail = currentNode;
      }
      currentNode.setNext(targetNode.getNext());
      removedData =  targetNode.getData();
    }

    size--;
    return removedData;
  }

  public T remove(T data) {
      if (data == null) {
          throw new IllegalArgumentException("You cannot remove null data from the list");
      }

      if (isEmpty()) {
          throw new NoSuchElementException("The data is not present in the list.");
      }

      if (head.getData().equals(data)) {
          T removedData = head.getData();
          head = head.getNext();
          size--;
          if (head == null) {
              tail = null;
          }
          return removedData;
      }

      Node<T> current = head;
      while (current.getNext() != null && !current.getNext().getData().equals(data)) {
          current = current.getNext();
      }

      if (current.getNext() == null) {
          throw new NoSuchElementException("The data is not present in the list.");
      }

      T removedData = current.getNext().getData();
      current.setNext(current.getNext().getNext());
      size--;
      if (current.getNext() == null) {
          tail = current;
      }
      return removedData;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return (this.head == null);
  }

  public void clear() {
    this.head = null;
  }
}


