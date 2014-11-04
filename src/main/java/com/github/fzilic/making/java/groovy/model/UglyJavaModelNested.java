package com.github.fzilic.making.java.groovy.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.Date;

public class UglyJavaModelNested {

  private Date createdOnDate;

  private BigDecimal someMonetaryValue;

  private UglyJavaModelNestedNested nested;

  public Date getCreatedOnDate() {
    return createdOnDate;
  }

  public void setCreatedOnDate(Date createdOnDate) {
    this.createdOnDate = createdOnDate;
  }

  public BigDecimal getSomeMonetaryValue() {
    return someMonetaryValue;
  }

  public void setSomeMonetaryValue(BigDecimal someMonetaryValue) {
    this.someMonetaryValue = someMonetaryValue;
  }

  public UglyJavaModelNestedNested getNested() {
    return nested;
  }

  public void setNested(UglyJavaModelNestedNested nested) {
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
    UglyJavaModelNested rhs = (UglyJavaModelNested) obj;
    return new EqualsBuilder() //
        .append(this.createdOnDate, rhs.createdOnDate) //
        .append(this.someMonetaryValue, rhs.someMonetaryValue) //
        .append(this.nested, rhs.nested) //
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder() //
        .append(createdOnDate) //
        .append(someMonetaryValue) //
        .append(nested) //
        .toHashCode();
  }
}
