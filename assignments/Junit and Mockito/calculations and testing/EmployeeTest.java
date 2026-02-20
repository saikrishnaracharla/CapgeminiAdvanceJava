package com.Calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void testCalculateAnnualSalary() {
        Employee e = new Employee();
        e.setSalary(2000);

        assertEquals(24000, e.calculateAnnualSalary());
    }
}
