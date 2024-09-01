package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c){
        super();
        comparator = c;
    }
    public T max(){
        if(this.isEmpty()) return null;
        T maxVal = this.get(0);
        for(int i = 0; i < this.size(); i++){
            T val = this.get(i);
            if(this.comparator.compare(val, maxVal) > 0)
                maxVal = val;
        }
        return maxVal;
    }
     public T max(Comparator<T> c){
         if(this.isEmpty()) return null;
         T maxVal = this.get(0);
         for(int i = 0; i < this.size(); i++){
             T val = this.get(i);
             if(c.compare(val, maxVal) > 0)
                 maxVal = val;
         }
         return maxVal;
     }

}
