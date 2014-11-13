package com.github.fzilic.making.java.groovy.service;

import com.github.fzilic.making.java.groovy.model.UglyJavaModel;
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNested;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class SpockDemoService {

  private final SimpleSpringService service; // we don't need this at all, but hey

  public SpockDemoService(final SimpleSpringService service) {
    this.service = service;
  }

  public BigDecimal averageValueFor(final Boolean booleanValue, final List<UglyJavaModel> list) {
    // We should test parameters

    BigDecimal sum = BigDecimal.ZERO;
    int count = 0;

    for (final UglyJavaModel model : list) {
      if (model.getNested().getNested().getNested().getTheAllImportantBoolean() == booleanValue) {
        sum = sum.add(model.getNested().getSomeMonetaryValue());
        count++;
      }
    }

    return sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_EVEN);
  }

}
