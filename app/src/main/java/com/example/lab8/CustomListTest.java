package com.example.lab8;

import static org.junit.Assert.*;

import com.example.lab8.CustomList;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void setUp() {
        list = MockCityList();
    }

    public CustomList MockCityList() {
        return new CustomList(null, new ArrayList<>()); // Creates a new CustomList with an empty list of cities
    }

    // Test for adding a city
    @Test
    public void addCityTest() {
        int initialSize = list.getCount(); // Get initial size
        list.addCity(new City("Estevan", "SK")); // Add a city
        assertEquals(initialSize + 1, list.getCount()); // Check size increased by 1
    }

    // Test for checking if a city exists
    @Test
    public void hasCityTest() {
        City city = new City("Estevan", "SK");
        assertFalse(list.hasCity(city)); // Initially, city should not be in the list
        list.addCity(city);
        assertTrue(list.hasCity(city)); // Now, city should be in the list
    }

    // Test for deleting a city
    @Test
    public void deleteCityTest() {
        City city = new City("Estevan", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city)); // City should be in the list after adding
        list.deleteCity(city);
        assertFalse(list.hasCity(city)); // City should no longer be in the list after deletion
    }

    // Test for counting cities
    @Test
    public void countCitiesTest() {
        assertEquals(0, list.getCount()); // Initially, list should be empty
        list.addCity(new City("Estevan", "SK"));
        assertEquals(1, list.getCount()); // After adding a city, count should be 1
        list.addCity(new City("Regina", "SK"));
        assertEquals(2, list.getCount()); // After adding another city, count should be 2
    }
}
