package aop.xml;

import org.springframework.stereotype.Component;

public class jisuanqiImpl implements jisuanqi {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int dvi(int i, int j) {
        return i/j;
    }
}
