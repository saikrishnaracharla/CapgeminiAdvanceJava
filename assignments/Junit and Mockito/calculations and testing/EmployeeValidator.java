package com.Calculator;

public class EmpValidator {

    public static void valid(Employee e)
            throws EmpNameInvalidException, EmpAgeInvalidException {

        if (e.getName() == null || e.getName().trim().isEmpty()) {
            throw new EmpNameInvalidException("enter valid name");
        }

        if (e.getAge() < 18 || e.getAge() > 50) {
            throw new EmpAgeInvalidException("enter valid age");
        }
    }
}
