package com.github.fzilic.making.java.groovy

import com.github.fzilic.making.java.groovy.controller.UglyJavaController
import com.github.fzilic.making.java.groovy.model.UglyJavaModel
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNested
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNested
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNestedNested
import com.github.fzilic.making.java.groovy.service.ThirdPartyService
import org.junit.Test
import org.springframework.ui.Model

class GroovyJunitTest {

  def data = [
      new UglyJavaModel(someName: 'first', nested:
          new UglyJavaModelNested(someMonetaryValue: 100.50, nested:
              new UglyJavaModelNestedNested(nested:
                  new UglyJavaModelNestedNestedNested(theAllImportantBoolean: false)))),
      new UglyJavaModel(someName: 'second', nested:
          new UglyJavaModelNested(someMonetaryValue: 2.50, nested:
              new UglyJavaModelNestedNested(nested:
                  new UglyJavaModelNestedNestedNested(theAllImportantBoolean: false)))),
      new UglyJavaModel(someName: 'third', nested:
          new UglyJavaModelNested(someMonetaryValue: 90.50, nested:
              new UglyJavaModelNestedNested(nested:
                  new UglyJavaModelNestedNestedNested(theAllImportantBoolean: true))))
  ]

  @Test
  void testUglyJavaControllerReturingCorrectCount() {
    def controller = new UglyJavaController([onlyWayToGetData: { return data }] as ThirdPartyService)
    assert controller.showSomething([addAttribute: { String attr, value ->
      if (attr == 'countWithBooleanTrue') {
        assert value == 1
      } else if (attr == 'topThree') {
        assert value == ['first', 'third', 'second']
      } else {
        assert false
      }
    }] as Model) == 'ugly'
  }

  @Test
  void justTestingSomething() {

    [[boolVal: true, decVal: 42.98], [boolVal: false, decVal: 0.0], [boolVal: true, decVal: 27.31]].collect {
      return new UglyJavaModel(nested:
          new UglyJavaModelNested(someMonetaryValue: it.decVal, nested:
              new UglyJavaModelNestedNested(nested:
                  new UglyJavaModelNestedNestedNested(theAllImportantBoolean: it.boolVal))))
    }
  }
}
