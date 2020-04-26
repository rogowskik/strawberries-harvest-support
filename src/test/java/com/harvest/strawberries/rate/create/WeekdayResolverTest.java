package com.harvest.strawberries.rate.create;


import com.harvest.strawberries.rate.domain.weekday.CustomDayOfWeekView;
import com.harvest.strawberries.rate.domain.weekday.Weekday;
import com.harvest.strawberries.rate.domain.weekday.WeekdayResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
class WeekdayResolverTest {


    @Test
    public void contains_exactly_7_days() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);

        //WHEN
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(LocalDate.now());
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertEquals(7, customDayOfWeekViews.size());
    }

    @Test
    public void contains_correct_border_value_for_monday() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);
        //WHEN
        LocalDate monday = LocalDate.now().withMonth(4).withDayOfMonth(27).withYear(2020);
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(monday);
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertTrue(customDayOfWeekViews.size() > 0);
        assertEquals(7, customDayOfWeekViews.size());
        assertEquals(Weekday.SATURDAY, customDayOfWeekViews.get(0).getDayOfWeek());
        assertEquals(Weekday.FRIDAY, customDayOfWeekViews.get(customDayOfWeekViews.size() - 1).getDayOfWeek());
    }

    @Test
    public void contains_correct_border_value_for_tuesday() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);
        //WHEN
        LocalDate tuesday = LocalDate.now().withMonth(4).withDayOfMonth(28).withYear(2020);
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(tuesday);
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertTrue(customDayOfWeekViews.size() > 0);
        assertEquals(7, customDayOfWeekViews.size());
        assertEquals(Weekday.SATURDAY, customDayOfWeekViews.get(0).getDayOfWeek());
        assertEquals(Weekday.FRIDAY, customDayOfWeekViews.get(customDayOfWeekViews.size() - 1).getDayOfWeek());
    }

    @Test
    public void contains_correct_border_value_for_wendsday() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);
        //WHEN
        LocalDate wendsday = LocalDate.now().withMonth(4).withDayOfMonth(29).withYear(2020);
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(wendsday);
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertTrue(customDayOfWeekViews.size() > 0);
        assertEquals(7, customDayOfWeekViews.size());
        assertEquals(Weekday.SATURDAY, customDayOfWeekViews.get(0).getDayOfWeek());
        assertEquals(Weekday.FRIDAY, customDayOfWeekViews.get(customDayOfWeekViews.size() - 1).getDayOfWeek());
    }

    @Test
    public void contains_correct_border_value_for_thurdsday() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);
        //WHEN
        LocalDate monday = LocalDate.now().withMonth(4).withDayOfMonth(30).withYear(2020);
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(monday);
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertTrue(customDayOfWeekViews.size() > 0);
        assertEquals(7, customDayOfWeekViews.size());
        assertEquals(Weekday.SATURDAY, customDayOfWeekViews.get(0).getDayOfWeek());
        assertEquals(Weekday.FRIDAY, customDayOfWeekViews.get(customDayOfWeekViews.size() - 1).getDayOfWeek());
    }

    @Test
    public void contains_correct_border_value_for_friday() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);
        //WHEN
        LocalDate friday = LocalDate.now().withMonth(5).withDayOfMonth(1).withYear(2020);
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(friday);
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertTrue(customDayOfWeekViews.size() > 0);
        assertEquals(Weekday.SATURDAY, customDayOfWeekViews.get(0).getDayOfWeek());
        assertEquals(7, customDayOfWeekViews.size());
        assertEquals(Weekday.FRIDAY, customDayOfWeekViews.get(customDayOfWeekViews.size() - 1).getDayOfWeek());
    }

    @Test
    public void contains_correct_border_value_for_saturday() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);
        //WHEN
        LocalDate monday = LocalDate.now().withMonth(5).withDayOfMonth(2).withYear(2020);
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(monday);
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertTrue(customDayOfWeekViews.size() > 0);
        assertEquals(Weekday.SATURDAY, customDayOfWeekViews.get(0).getDayOfWeek());
        assertEquals(7, customDayOfWeekViews.size());
        assertEquals(Weekday.FRIDAY, customDayOfWeekViews.get(customDayOfWeekViews.size() - 1).getDayOfWeek());
    }

    @Test
    public void contains_correct_border_value_for_sanday() {
        //GIVEN
        WeekdayResolver weekdayResolver = mock(WeekdayResolver.class, CALLS_REAL_METHODS);
        //WHEN
        LocalDate monday = LocalDate.now().withMonth(5).withDayOfMonth(3).withYear(2020);
        when(weekdayResolver.getStartingPointForLastWeek()).thenReturn(monday);
        List<CustomDayOfWeekView> customDayOfWeekViews = weekdayResolver.resolveDateRange();
        //THEN
        assertTrue(customDayOfWeekViews.size() > 0);
        assertEquals(Weekday.SATURDAY, customDayOfWeekViews.get(0).getDayOfWeek());
        assertEquals(7, customDayOfWeekViews.size());
        assertEquals(Weekday.FRIDAY, customDayOfWeekViews.get(customDayOfWeekViews.size() - 1).getDayOfWeek());
    }



}