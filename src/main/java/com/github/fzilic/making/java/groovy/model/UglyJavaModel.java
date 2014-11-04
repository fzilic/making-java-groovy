package com.github.fzilic.making.java.groovy.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UglyJavaModel {

  private Integer integerValue;

  private String someName;

  private UglyJavaModelNested nested;

  public Integer getIntegerValue() {
    return integerValue;
  }

  public void setIntegerValue(Integer integerValue) {
    this.integerValue = integerValue;
  }

  public String getSomeName() {
    return someName;
  }

  public void setSomeName(String someName) {
    this.someName = someName;
  }

  public UglyJavaModelNested getNested() {
    return nested;
  }

  public void setNested(UglyJavaModelNested nested) {
    this.nested = nested;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    UglyJavaModel rhs = (UglyJavaModel) obj;
    return new EqualsBuilder() //
        .append(this.integerValue, rhs.integerValue) //
        .append(this.someName, rhs.someName) //
        .append(this.nested, rhs.nested) //
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder() //
        .append(integerValue) //
        .append(someName) //
        .append(nested) //
        .toHashCode();
  }
}
