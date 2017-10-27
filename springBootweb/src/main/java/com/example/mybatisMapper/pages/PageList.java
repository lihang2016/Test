package com.example.mybatisMapper.pages;

import java.util.ArrayList;

public class PageList<E> extends ArrayList<E> {
    private ExPageImpl<E> es;

    public ExPageImpl<E> getEs() {
        return es;
    }

    public void setEs(ExPageImpl<E> es) {
        this.es = es;
    }
}
