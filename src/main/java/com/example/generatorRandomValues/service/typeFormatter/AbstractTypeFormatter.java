package com.example.generatorRandomValues.service.typeFormatter;

public abstract class AbstractTypeFormatter implements TypeFormatter{
    protected abstract String getStringFormattedData(Object obj, String format);

    @Override
    public String format(Object obj, String format) {
        String dataFormat = getFormat(format);
        return getStringFormattedData(obj, dataFormat);
    }

    private String getFormat(String format){
        if (format.isBlank()){
            return getDefaultFormat();
        }
        return format;
    }
}
