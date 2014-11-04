package com.github.fzilic.making.java.groovy.service

import com.github.fzilic.making.java.groovy.model.UglyJavaModel
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNested
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNested
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNestedNested
import org.springframework.stereotype.Service

@Service
class GroovyThirdPartyDataSource implements ThirdPartyService {

  def random = new Random()

  /**
   * Let's pretend that this comes from stored procedure no-one-alive-on-the-earth wants to change
   * @return list of ugly nested elements which can be null
   */
  List<UglyJavaModel> onlyWayToGetData() {
    def list = []

    (random.nextInt(30 - 5 + 1) + 5).times {
      def nestedNestedNested = new UglyJavaModelNestedNestedNested(
          theAllImportantBoolean: it % 3 == 0,
          lessImportantDescription: "Description ${it * 19}")

      def nestedNested = new UglyJavaModelNestedNested(
          integerValueThatShouldBeString: 123199,
          stringThatSouldBeInteger: "312",
          nested: nestedNestedNested)

      def nested = new UglyJavaModelNested(
          createdOnDate: new Date().clearTime() - 10 + it,
          someMonetaryValue: (12311 + (random.nextInt(1000))) / 100,
          nested: nestedNested)

      list << new UglyJavaModel(
          integerValue: it,
          someName: "This is my name: $it",
          nested: nested)

    }

    random.nextInt((list.size() / 2) as Integer).times {
      list[random.nextInt(list.size())].nested.nested.nested = null
    }

      return list
  }
}
