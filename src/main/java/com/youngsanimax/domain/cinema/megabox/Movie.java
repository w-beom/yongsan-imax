package com.youngsanimax.domain.cinema.megabox;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Movie {
    private int statCd;
    private String msg;
    private Map<String, Object> megaMap;
}
