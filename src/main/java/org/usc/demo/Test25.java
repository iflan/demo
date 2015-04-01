package org.usc.demo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.Optional;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class Test25 {
    private static final Ordering<Entry<String>> COUNT_ORDERING = new Ordering<Entry<String>>() {
        @Override
        public int compare(Entry<String> entry1, Entry<String> entry2) {
            return Ints.compare(entry1.getCount(), entry2.getCount());
        }
    };

    public static void main(String[] args) {
        // List<String> values = ImmutableList.of("1", "2", "2", "1", "3", "2");
        List<String> values = ImmutableList.of();

        Multiset<String> count = HashMultiset.create(values);

        System.out.println(Iterables.getFirst(Multisets.copyHighestCountFirst(count).entrySet(), Multisets.immutableEntry("", 0)).getCount());

        System.out.println(values.isEmpty() ? 0 : COUNT_ORDERING.max(count.entrySet()).getCount());

        // SortedMultiset<String> copyOf = ImmutableSortedMultiset.copyOf(values);
        // System.out.println(copyOf);
        // System.out.println(copyOf.firstEntry().getCount());

        //
        // ForwardingSortedMultiset.

        // System.out.println(count.);

        // Predicate predicate;
        // CollectionUtils.maxSize(coll).countMatches(values, predicate);
        // Map cardinalityMap = CollectionUtils.getCardinalityMap(values);
        // System.out.println(cardinalityMap);

        // FreqSortMultiSet<Object> create = FreqSortMultiSet.create(true);
        // create.addAll(values);
        //
        // System.out.println(create);
    }

}

enum EntryComp implements Comparator<Multiset.Entry<?>> {
    DESCENDING {
        @Override
        public int compare(final Entry<?> a, final Entry<?> b) {
            return Ints.compare(b.getCount(), a.getCount());
        }
    },
    ASCENDING {
        @Override
        public int compare(final Entry<?> a, final Entry<?> b) {
            return Ints.compare(a.getCount(), b.getCount());
        }
    },
}

class FreqSortMultiSet<E> extends ForwardingMultiset<E> {
    Multiset<E> delegate;
    EntryComp comp;

    public FreqSortMultiSet(Multiset<E> delegate, boolean ascending) {
        this.delegate = delegate;
        if (ascending)
            this.comp = EntryComp.ASCENDING;
        else
            this.comp = EntryComp.DESCENDING;
    }

    @Override
    protected Multiset<E> delegate() {
        return delegate;
    }

    @Override
    public Set<Entry<E>> entrySet() {
        TreeSet<Entry<E>> sortedEntrySet = new TreeSet<Entry<E>>(comp);
        sortedEntrySet.addAll(delegate.entrySet());
        return sortedEntrySet;
    }

    @Override
    public Set<E> elementSet() {
        Set<E> sortedEntrySet = new LinkedHashSet<E>();
        for (Entry<E> en : entrySet())
            sortedEntrySet.add(en.getElement());
        return sortedEntrySet;
    }

    public static <E> FreqSortMultiSet<E> create(boolean ascending) {
        return new FreqSortMultiSet<E>(HashMultiset.<E> create(), ascending);
    }

    /*
     * For Testing
     * public static void main(String[] args) {
     * Multiset<String> s = FreqSortMultiSet.create(false);
     * s.add("Hello");
     * s.add("Hello");
     * s.setCount("World", 3);
     * s.setCount("Bye", 5);
     * System.out.println(s.entrySet());
     * }
     */

}
