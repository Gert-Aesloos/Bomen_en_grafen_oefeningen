package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        return this.values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int index=values.size()-1;
        while (index>=1 && values.get((index-1)/2).compareTo(values.get(index)) > 0){
            E i=this.values.get(index);
            this.values.set(index,values.get((index-1)/2));
            this.values.set((index-1)/2,i);
            index=(index-1)/2;
        }
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        int index=0;
        while (true){
            int indexLeftChild=(2*index)+1;
            int indexRightChild=(2*index)+2;
            int indexSmallest;
            E valuesSmallest;

            if (indexLeftChild<this.values.size() && indexRightChild<this.values.size()){
                if (this.values.get(indexLeftChild).compareTo(this.values.get(indexRightChild))<0){
                    indexSmallest=indexLeftChild;
                    valuesSmallest=this.values.get(indexLeftChild);
                }
                else {
                    indexSmallest=indexRightChild;
                    valuesSmallest=this.values.get(indexRightChild);
                }
            }

            else if (indexLeftChild<this.values.size()){
                indexSmallest=indexLeftChild;
                valuesSmallest=this.values.get(indexLeftChild);
            }

            else {
                break;
            }
            if (this.values.get(index).compareTo(this.values.get(indexSmallest))>0){
                E i = this.values.get(index);
                this.values.set(index, this.values.get(indexSmallest));
                this.values.set(indexSmallest, i);
                index=indexSmallest;
            }
            else {
                break;
            }
        }
    }

    public ArrayList<E> getPath(E value) {
        int index= values.indexOf(value);
        if (!values.contains(value)){
            return null;
        }
        else {
            ArrayList<E> i=new ArrayList<>();
            i.add(value);
            while (index >0){
                index=(index-1)/2;
                i.add(0, this.values.get(index));
            }
            return i;
        }
    }
}
