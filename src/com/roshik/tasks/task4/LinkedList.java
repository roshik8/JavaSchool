package com.roshik.tasks.task4;

import com.roshik.tasks.task3.BaseCar;

public class LinkedList
{
    private class Node
    {
        public int elem;
        public Node next;
        public Node prev;

        public Node(int elem)
        {
            this.elem = elem;
        }
    }

    private Node head;

    private Node getLastElem()
    {
        Node node = head;

        while (node.next != null)
            node = node.next;

        return node;
    }

    private Node getElemByIndex(int index)
    {
        if (index < 0)
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");

        Node elem = head;
        for (int i = 0; i < index; i++)
        {
            if (elem.next == null)
                throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
            elem = elem.next;
        }

        return elem;
    }

    public void add(int elem)
    {
        Node newNode = new Node(elem);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node lastNode = getLastElem();
            lastNode.next = newNode;
            newNode.prev = lastNode;
        }
    }

    public void add(int elem, int index)
    {
        Node newNode = new Node(elem);

        if (index == 0)
        {
            if (head != null)
            {
                newNode.next = head;
                head.prev = newNode;
            }

            head = newNode;
        }
        else
        {
            var prevNode = getElemByIndex(index - 1);

            newNode.next = prevNode.next;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            if (newNode.next != null)
                newNode.next.prev = newNode;
        }
    }

    public int getLength()
    {
        int length = 0;
        Node node = head;
        while (node != null)
        {
            node = node.next;
            length++;
        }

        return length;
    }

    public void remove(int index)
    {
        if (head != null && index == 0)
        {
            head = head.next;
            head.prev = null;
        }
        else
        {
            Node toRemove = getElemByIndex(index);
            if (toRemove.next != null)
                toRemove.next.prev = toRemove.prev;
            if (toRemove.prev != null)
                toRemove.prev.next = toRemove.next;
        }
    }

    public void set(int elem, int index)
    {
        Node node = getElemByIndex(index);
        node.elem = elem;
    }

    public void print()
    {
        Node node = head;
        while (node != null)
        {
            System.out.println(node.elem);
            node = node.next;
        }
    }

    public void sort()
    {
        if (head == null)
            return;

        for (int i = getLength() - 1; i > 0; i--)
        {
            var node = head;
            for (int j = 0; j < i; j++)
            {
                if (node.elem > node.next.elem)
                {
                    int tmp = node.elem;
                    node.elem = node.next.elem;
                    node.next.elem = tmp;
                }

                node = node.next;
            }
        }
    }

    public int getMinElement()
    {
        if (head == null)
            return 0;

        int min = head.elem;
        Node node = head.next;
        while (node != null)
        {
            if (min > node.elem)
                min = node.elem;
            node = node.next;
        }
        return min;
    }

    public int getMaxElement()
    {
        if (head == null)
            return 0;

        int max = head.elem;
        Node node = head.next;
        while (node != null)
        {
            if (max < node.elem)
                max = node.elem;
            node = node.next;
        }
        return max;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        for(int i =0; i<10;i++){
            list.add(i);
        }
        list.remove(4);
        list.add(99,6);
        list.set(88,5);
        list.sort();
        list.print();
        System.out.println(list.getMaxElement());
        System.out.println(list.getMinElement());
        System.out.println(list.getLength());


    }
}
