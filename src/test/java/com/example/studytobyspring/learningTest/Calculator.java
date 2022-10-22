package com.example.studytobyspring.learningTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filepath));
            int ret = callback.doSomethingWithReader(br);
            return ret;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Integer calsSum(String file) throws IOException {
        BufferedReaderCallback sumCallback = (BufferedReader br) -> {
            Integer sum = 0;
            String line;
            while ((line = br.readLine()) != null) {
                sum += Integer.valueOf(line);
            }
            return sum;
        };
        return fileReadTemplate(file, sumCallback);
    }

    public Integer calcMultiply(String numFilepath) throws IOException {
        BufferedReaderCallback multiplyCallback = (BufferedReader br) -> {
            Integer multiply = 1;
            String line = null;
            while ((line = br.readLine()) != null) {
                multiply *= Integer.valueOf(line);
            }
            return multiply;
        };

        return fileReadTemplate(numFilepath, multiplyCallback);
    }

    public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVale) throws IOException {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filepath));
            T res = initVale;
            String line;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public String concatenate(String filepath) throws IOException {
        LineCallback<String> concatenateCallback =
                ((line, value) -> value + line);

        return lineReadTemplate(filepath, concatenateCallback, "");
    }
}
