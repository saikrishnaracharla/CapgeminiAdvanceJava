package com.Calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmpValidatorTest {

    @Test
    void testValidEmployee() {
        Employee e = new Employee();
        e.setName("Sai");
        e.setAge(30);

        assertDoesNotThrow(() -> EmpValidator.valid(e));
    }

    @Test
    void testInvalidName() {
        Employee e = new Employee();
        e.setName("");
        e.setAge(30);

        assertThrows(EmpNameInvalidException.class,
                () -> EmpValidator.valid(e));
    }

    @Test
    void testInvalidAge() {
        Employee e = new Employee();
        e.setName("Sai");
        e.setAge(55);

        assertThrows(EmpAgeInvalidException.class,
                () -> EmpValidator.valid(e));
    }
}
