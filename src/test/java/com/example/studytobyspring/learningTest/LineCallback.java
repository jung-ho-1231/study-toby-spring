package com.example.studytobyspring.learningTest;

public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
