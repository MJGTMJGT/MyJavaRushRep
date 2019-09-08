package com.javarush.task.task09.task0915;

import java.io.CharConversionException;
import java.io.IOException;
import java.nio.file.FileSystemException;

/* 
Перехват выборочных исключений
*/

public class Solution {
    public static StatelessBean BEAN = new StatelessBean();

    public static void main(String[] args) {
        try {
            handleExceptions();
        } catch (FileSystemException fse) {
            BEAN.log(fse);
        }
    }

    public static void handleExceptions() throws FileSystemException {
        try {
            BEAN.methodThrowExceptions();
        } catch (CharConversionException cce) {
            BEAN.log(cce);
        } catch (FileSystemException fse) {
            BEAN.log(fse);
            throw fse;
        } catch (IOException ioe) {
            BEAN.log(ioe);
        }
    }

    public static class StatelessBean {
        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws CharConversionException, FileSystemException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0)
                throw new CharConversionException();
            if (i == 1)
                throw new FileSystemException("");
            if (i == 2)
                throw new IOException();
        }
    }
}
