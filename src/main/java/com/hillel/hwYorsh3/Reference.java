package com.hillel.hwYorsh3;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Reference {

    public static void main(String[] args) {
        //Strong reference
        Human human = new Human();

        // Soft reference
        SoftReference<Human> softReference = new SoftReference<>(human);
        //Weak reference
        WeakReference<Human> weakReference = new WeakReference<>(human);
        //Phantom reference
        ReferenceQueue<Human> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Human> phantomReference = new PhantomReference<>(human, referenceQueue);

        human = null;

        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());
        System.gc();
        System.out.println("-------------------------------");
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());
        // littering memory so that references are removed by the garbage collector
        // doesn't always work
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 354_836_040; i++) {
            integerList.add(i);
        }
        System.gc();
        System.out.println("-------------------------------");
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());

    }

}

class Human {

}
