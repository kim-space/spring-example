package com.kimtd.entity;

import com.kimtd.common.BaseArrtibuteConverter;
import com.kimtd.common.BaseEntity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_ATTRIBUTE")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "seq_attribute")
public class Attribute extends BaseEntity<Long> {

    private String name;
    private Integer propertryIndex;
    private List<String> options = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPropertryIndex() {
        return propertryIndex;
    }

    public void setPropertryIndex(Integer propertryIndex) {
        this.propertryIndex = propertryIndex;
    }
    @Convert(converter = OptionConverter.class)
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Convert
    public static class OptionConverter extends BaseArrtibuteConverter<List<String>> implements AttributeConverter<Object,String> {}

}
