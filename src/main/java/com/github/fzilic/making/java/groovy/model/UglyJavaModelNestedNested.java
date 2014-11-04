package com.github.fzilic.making.java.groovy.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UglyJavaModelNestedNested {

  private Integer integerValueThatShouldBeString;

  private String stringThatSouldBeInteger;

  private UglyJavaModelNestedNestedNested nested;

  public Integer getIntegerValueThatShouldBeString() {
    return integerValueThatShouldBeString;
  }

  public void setIntegerValueThatShouldBeString(Integer integerValueThatShouldBeString) {
    this.integerValueThatShouldBeString = integerValueThatShouldBeString;
  }

  public String getStringThatSouldBeInteger() {
    return stringThatSouldBeInteger;
  }

  public void setStringThatSouldBeInteger(String stringThatSouldBeInteger) {
    this.stringThatSouldBeInteger = stringThatSouldBeInteger;
  }

  public UglyJavaModelNestedNestedNested getNested() {
    return nested;
  }

  public void setNested(UglyJavaModelNestedNestedNested nested) {
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
    UglyJavaModelNestedNested rhs = (UglyJavaModelNestedNested) obj;
    return new EqualsBuilder() //
        .append(this.integerValueThatShouldBeString, rhs.integerValueThatShouldBeString) //
        .append(this.stringThatSouldBeInteger, rhs.stringThatSouldBeInteger) //
        .append(this.nested, rhs.nested) //
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder() //
        .append(integerValueThatShouldBeString) //
        .append(stringThatSouldBeInteger) //
        .append(nested) //
        .toHashCode();
  }
}
