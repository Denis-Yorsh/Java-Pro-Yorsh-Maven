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
        MyHashCode myHashCode = new MyHashCode("Denis", "Yorsh", 39);

        // Soft reference
        SoftReference<MyHashCode> softReference = new SoftReference<>(myHashCode);
        //Weak reference
        WeakReference<MyHashCode> weakReference = new WeakReference<>(myHashCode);
        //Phantom reference
        ReferenceQueue<MyHashCode> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyHashCode> phantomReference = new PhantomReference<>(myHashCode, referenceQueue);

        myHashCode = null;

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
