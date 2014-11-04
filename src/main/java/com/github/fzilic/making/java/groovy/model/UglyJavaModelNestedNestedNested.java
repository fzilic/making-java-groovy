package com.github.fzilic.making.java.groovy.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UglyJavaModelNestedNestedNested {

  private Boolean theAllImportantBoolean;

  private String lessImportantDescription;

  public Boolean getTheAllImportantBoolean() {
    return theAllImportantBoolean;
  }

  public void setTheAllImportantBoolean(Boolean theAllImportantBoolean) {
    this.theAllImportantBoolean = theAllImportantBoolean;
  }

  public String getLessImportantDescription() {
    return lessImportantDescription;
  }

  public void setLessImportantDescription(String lessImportantDescription) {
    this.lessImportantDescription = lessImportantDescription;
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
    UglyJavaModelNestedNestedNested rhs = (UglyJavaModelNestedNestedNested) obj;
    return new EqualsBuilder()
        .append(this.theAllImportantBoolean, rhs.theAllImportantBoolean) //
        .append(this.lessImportantDescription, rhs.lessImportantDescription) //
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(theAllImportantBoolean) //
        .append(lessImportantDescription) //
        .toHashCode();
  }
}
