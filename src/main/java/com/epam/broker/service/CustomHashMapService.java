package com.epam.broker.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

@Service
public class CustomHashMapService<K, V> {
    private static final int initialCapacity = 100;
    private Vector<CustomEntry<K, V>> bucket;
    private Vector<Integer> hashCodes;
    private HashMap hashMap = new HashMap();

    public CustomHashMapService() {
        bucket = new Vector<>(initialCapacity);
        hashCodes = new Vector<>(initialCapacity);
    }

    public V put(K key, V value){
        CustomEntry<K, V> customEntry = new CustomEntry<>(key, value);

        V result = null;
        if(hashCodes.contains(key.hashCode())){
            int indexOfElement = hashCodes.indexOf(key.hashCode());
            result = bucket.get(indexOfElement).getValue();
            bucket.setElementAt(customEntry, indexOfElement);
        }else{
            boolean inserted = false;
            for(int i = 0;i < hashCodes.size();i++){
                if(hashCodes.get(i) == null){
                    hashCodes.set(i, key.hashCode());
                    bucket.set(i, customEntry);
                    inserted = true;
                    break;
                }
            }

            if(!inserted){
                hashCodes.add(key.hashCode());
                bucket.add(customEntry);
            }
        }

        return result;
    }

    public V get(K key){
        return hashCodes.contains(key.hashCode()) ? bucket.get(hashCodes.indexOf(key.hashCode())).getValue() : null;
    }

    public void clear(){
        bucket.clear();
        hashCodes.clear();
    }

    public int size(){
        return bucket.size();
    }

    public boolean isEmpty(){
        return bucket.size() == 0;
    }

    public boolean containsKey(K key){
        return hashCodes.contains(key.hashCode());
    }

    public boolean containsValue(V value){
        for(CustomEntry<K, V> customEntry : entrySet()){
            if(value != null){
                return value.equals(customEntry.getValue());
            }else if(customEntry.getValue() == null){
                return true;
            }
        }
        return false;
    }

    public Set keySet(){
        Set<K> result = new HashSet<>();

        bucket.stream().forEach(kvCustomEntry -> result.add(kvCustomEntry.getKey()));

        return result;
    }

    public Set<CustomEntry<K, V>> entrySet(){
        Set<CustomEntry<K, V>> result = new HashSet<>();

        bucket.stream().forEach(kvCustomEntry -> result.add(kvCustomEntry));

        return result;
    }

    public V remove(K key){
        V result = null;
        if(hashCodes.contains(key.hashCode())){
            int indexOfElement = hashCodes.indexOf(key.hashCode());
            CustomEntry<K, V> removedEntry = bucket.remove(indexOfElement);
            if(removedEntry != null){
                result = removedEntry.getValue();
                hashCodes.remove(hashCodes);
            }
        }

        return result;
    }

    private class CustomEntry<K, V>{
        private K key;

        private V value;

        public CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
