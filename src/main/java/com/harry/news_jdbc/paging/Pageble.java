package com.harry.news_jdbc.paging;

import com.harry.news_jdbc.sort.Sorter;

public interface Pageble {
    Integer getPage();
    Integer getOffset();
    Integer getLimit();
    Sorter getSorter();
}
