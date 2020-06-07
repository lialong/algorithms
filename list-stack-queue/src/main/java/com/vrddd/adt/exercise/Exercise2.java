package com.vrddd.adt.exercise;

/**
 * 双链表元素交换
 * 单链表元素交换
 */
public class Exercise2 {

    private static class SingleLink<T> {
        T val;
        private SingleLink next;

        public SingleLink(T val, SingleLink<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    private static class DoubleLink<T> {
        T val;
        private DoubleLink pre;
        private DoubleLink next;

        public DoubleLink(T val, DoubleLink<T> pre, DoubleLink<T> next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    public static <T> void swapDoubleLink(DoubleLink<T> p1, DoubleLink<T> p2) {
        p1.pre.next = p2;
        p2.next.pre = p1;

        p1.next = p2.next;
        p2.pre = p1.pre;

        p1.pre = p2;
        p2.next = p1;
    }

    public static <T> void swapSingleLink(SingleLink<T> beforeLink) {
        SingleLink<T> b = beforeLink.next.next;
        beforeLink.next.next = b.next;
        b.next = beforeLink.next;
        beforeLink.next = b;
    }

    public static void main(String[] args) {
        DoubleLink<Integer> a = new DoubleLink(1, null, null);
        DoubleLink<Integer> p1 = new DoubleLink(2, a, null);
        a.next = p1;
        DoubleLink<Integer> p2 = new DoubleLink(3, p1, null);
        DoubleLink<Integer> b = new DoubleLink(4, p2, null);
        p2.next = b;
        System.out.println(String.join(",", "a:" + a.val, "p1:" + a.next.val, "p2:" + b.pre.val, "b:" + b.val));
        swapDoubleLink(p1, p2);
        System.out.println(String.join(",", "a:" + a.val, "p1:" + a.next.val, "p2:" + b.pre.val, "b:" + b.val));

        SingleLink<Integer> cs = new SingleLink<>(4, null);
        SingleLink<Integer> bs = new SingleLink<>(3, cs);
        SingleLink<Integer> as = new SingleLink<>(2, bs);
        SingleLink<Integer> before = new SingleLink<>(1, as);
        System.out.println(String.join(",", "before:" + before.val, "as:" + before.next.val, "bs:" + before.next.next.val, "cs:" + before.next.next.next.val));
        swapSingleLink(before);
        System.out.println(String.join(",", "before:" + before.val, "as:" + before.next.val, "bs:" + before.next.next.val, "cs:" + before.next.next.next.val));
    }
}
