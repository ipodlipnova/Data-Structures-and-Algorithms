/**
 * Created by Asus on 31.01.2017.
 */
public class NaiveBitset {
    private int size = 1;
    private Long[] bitset = new Long [size];

    NaiveBitset(){
        bitset[0] = Long.valueOf(0);
    }

    public void add(int x){
        while (x > size * 64)
            increase();
        bitset[x/64] = (bitset[x/64] | Long.valueOf(1 << (x % 64)));
    }
    public boolean has(int x) {
        Long result = (bitset[x/64] & Long.valueOf(1 << (x%64)));
        if (result == Long.valueOf(1<<(x%64)))
            return true;
        else
            return false;
    }

    public void increase() {
        Long[] oldbitset = new Long[size];
        for (int i=0; i<size; i++){
            oldbitset[i] = bitset[i];
        }
        bitset = new Long[size * 2];
        for (int i=0; i<size; i++){
            bitset[i] = oldbitset[i];
        }
        for (int i=size; i<size *2; i++){
            bitset[i] = Long.valueOf(0);
        }
        size *= 2;
    }
}
