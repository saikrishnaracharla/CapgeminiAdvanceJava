package com.Calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AgeValidaterTest {
	@Mock
	Database db;
	
	@InjectMocks
	AgeValidater validator;
//	
//	@Test
//	void testAge() {
//		AgeValidater a=new AgeValidater();
//		assertThrows(IllegalArgumentException.class,()->{  a.validator(50);
//		});
//	}
	@Test
	public void testAge() {
		assertThrows(IllegalArgumentException.class,()->{
			validator.validateAge(-1);
		});
		
	}
}
