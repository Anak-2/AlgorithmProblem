package com.example.algorithm.data_structure;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StackExample {

    public static void main(String[] args) {
        List<String> stringStack = new ArrayList<>();

        // push
        stringStack.add("item1");
        stringStack.add("item2");
        // pop
        String top = stringStack.remove(stringStack.size() - 1);
        assertThat(top.equals("item2")).isTrue();
        // peek
        String peek = stringStack.get(stringStack.size() - 1);
        assertThat(peek.equals("item1")).isTrue();
    }
}
