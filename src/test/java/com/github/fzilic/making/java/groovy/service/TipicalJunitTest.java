package com.github.fzilic.making.java.groovy.service;

import com.github.fzilic.making.java.groovy.controller.UglyJavaController;
import com.github.fzilic.making.java.groovy.model.UglyJavaModel;
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNested;
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNested;
import com.github.fzilic.making.java.groovy.model.UglyJavaModelNestedNestedNested;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TipicalJunitTest {
  @Mock
  private ThirdPartyService service;
  @Mock
  private Model model;
  @Captor
  private ArgumentCaptor<ArrayList<String>> captor;

  @Test
  public void testUglyJavaControllerReturingCorrectCount() {
    final UglyJavaController controller = new UglyJavaController(service);

    final ArrayList<UglyJavaModel> uglyJavaModels = prepareData();
    when(service.onlyWayToGetData()).thenReturn(uglyJavaModels);

    final String view = controller.showSomething(model);

    assertThat(view).isEqualTo("ugly");
    verify(model).addAttribute(eq("countWithBooleanTrue"), eq(1));
    verify(model).addAttribute(eq("topThree"), captor.capture());
    verify(service).onlyWayToGetData();
    verifyNoMoreInteractions(service, model);

    assertThat(captor.getValue()).containsExactly("first", "third", "second");
  }

  // Not the way to do it - but we write this
  private ArrayList<UglyJavaModel> prepareData() {
    ArrayList<UglyJavaModel> uglyJavaModels;
    uglyJavaModels = new ArrayList<>();

    final UglyJavaModel first = mock(UglyJavaModel.class);
    final UglyJavaModelNested firstNested = mock(UglyJavaModelNested.class);
    final UglyJavaModelNestedNested firstNestedNested = mock(UglyJavaModelNestedNested.class);
    final UglyJavaModelNestedNestedNested firstNestedNestedNested = mock(UglyJavaModelNestedNestedNested.class);

    when(first.getNested()).thenReturn(firstNested);
    when(firstNested.getNested()).thenReturn(firstNestedNested);
    when(firstNestedNested.getNested()).thenReturn(firstNestedNestedNested);

    when(firstNested.getSomeMonetaryValue()).thenReturn(BigDecimal.valueOf(10050, 2));
    when(first.getSomeName()).thenReturn("first");
    when(firstNestedNestedNested.getTheAllImportantBoolean()).thenReturn(false);
    uglyJavaModels.add(first);

    final UglyJavaModel second = mock(UglyJavaModel.class);
    final UglyJavaModelNested secondNested = mock(UglyJavaModelNested.class);
    final UglyJavaModelNestedNested secondNestedNested = mock(UglyJavaModelNestedNested.class);
    final UglyJavaModelNestedNestedNested secondNestedNestedNested = mock(UglyJavaModelNestedNestedNested.class);

    when(second.getNested()).thenReturn(secondNested);
    when(secondNested.getNested()).thenReturn(secondNestedNested);
    when(secondNestedNested.getNested()).thenReturn(secondNestedNestedNested);

    when(secondNested.getSomeMonetaryValue()).thenReturn(BigDecimal.valueOf(250, 2));
    when(second.getSomeName()).thenReturn("second");
    when(secondNestedNestedNested.getTheAllImportantBoolean()).thenReturn(false);
    uglyJavaModels.add(second);

    final UglyJavaModel third = mock(UglyJavaModel.class);
    final UglyJavaModelNested thirdNested = mock(UglyJavaModelNested.class);
    final UglyJavaModelNestedNested thirdNestedNested = mock(UglyJavaModelNestedNested.class);
    final UglyJavaModelNestedNestedNested thirdNestedNestedNested = mock(UglyJavaModelNestedNestedNested.class);

    when(third.getNested()).thenReturn(thirdNested);
    when(thirdNested.getNested()).thenReturn(thirdNestedNested);
    when(thirdNestedNested.getNested()).thenReturn(thirdNestedNestedNested);

    when(thirdNested.getSomeMonetaryValue()).thenReturn(BigDecimal.valueOf(9050, 2));
    when(third.getSomeName()).thenReturn("third");
    when(thirdNestedNestedNested.getTheAllImportantBoolean()).thenReturn(true);
    uglyJavaModels.add(third);
    return uglyJavaModels;
  }

}
