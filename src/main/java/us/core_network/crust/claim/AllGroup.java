package us.core_network.crust.claim;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

/**
 * Virtual group that consists of all players
 */
public class AllGroup implements Group {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return o != null;
    }

    @Override
    public Iterator<UUID> iterator() {
        throw new UnsupportedOperationException("can't iterate over infinite people");
    }

    @Override
    public Object[] toArray() {
        return new UUID[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(UUID uuid) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends UUID> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getDisplayName() {
        return "Everyone else";
    }
}
