package com.youngsanimax.converter;

import com.youngsanimax.domain.browser.Browser;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;

public class StringToBrowserConverter implements Converter<String, Browser> {
    private final ApplicationContext applicationContext;

    public StringToBrowserConverter(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Browser convert(String source) {
        return applicationContext.getBean(source, Browser.class);
    }
}
