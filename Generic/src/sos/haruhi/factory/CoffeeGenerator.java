package sos.haruhi.factory;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>{
    Class[] types = new Class[]{Mocaa.class, Kabuchino.class, Coffee.class, Mocaa.class, Kabuchino.class, Coffee.class,Mocaa.class, Kabuchino.class, Coffee.class};

    int size = 0;
    public CoffeeGenerator(){}

    public CoffeeGenerator(int sz){this.size = sz;}

    @Override
    public Coffee next() {
        Coffee result = null;
        try {
            result = (Coffee) types[new Random(7).nextInt(types.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
           count--;
           return CoffeeGenerator.this.next();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator(){
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
//        for(int i = 0; i < 5; i++){
//            System.out.print(gen.next() + " ,");
//        }
        for(Coffee it:new CoffeeGenerator(7)){
            System.out.println(it);
        }
    }

}
