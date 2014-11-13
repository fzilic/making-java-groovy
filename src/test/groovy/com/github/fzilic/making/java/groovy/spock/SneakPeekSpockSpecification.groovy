package com.github.fzilic.making.java.groovy.spock

import com.github.fzilic.making.java.groovy.model.UglyJavaModel
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNested
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNested
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNestedNested
import com.github.fzilic.making.java.groovy.service.SimpleSpringService
import com.github.fzilic.making.java.groovy.service.SpockDemoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

@ContextConfiguration(['classpath:spring/test-config.xml'])
class SneakPeekSpockSpecification extends Specification {
  @Autowired
  SimpleSpringService service

  @Unroll
  void "just a simple sneak peak for spock"() {
    given:
    def testService = new SpockDemoService(service)

    expect: "dependencies are met"
    service

    when: "calculate average for #booleanValue #givenValues.inspect()"
    def average = testService.averageValueFor(booleanValue, givenValues.collect {
      return new UglyJavaModel(nested:
          new UglyJavaModelNested(someMonetaryValue: it.d, nested:
              new UglyJavaModelNestedNested(nested:
                  new UglyJavaModelNestedNestedNested(theAllImportantBoolean: it.b))))
    })

    then: "average value should be #expectedValue"
    average == expectedValue

    where:
    booleanValue | givenValues                                                    || expectedValue
    true         | [[b: true, d: 42.98], [b: false, d: 4.3], [b: true, d: 27.31]] || 35.14
    false        | [[b: true, d: 42.98], [b: false, d: 4.3], [b: true, d: 27.31]] || 4.3
    true         | [[b: true, d: 42.98], [b: true, d: 4.3], [b: true, d: 27.31]]  || 24.86
  }
}
