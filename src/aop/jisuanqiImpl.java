package aop;

import org.springframework.stereotype.Component;

@Component(value = "jisuanji")
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
