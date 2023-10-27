package org.example.exception;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class ExceptionTests {

	/*
	Non-void return type
	 */
	@Test
	public void givenNonVoidReturnType_whenUsingWhenThen_thenExceptionIsThrown() {
		MyDictionary dictMock = mock(MyDictionary.class);
		when(dictMock.getMeaning(anyString())).thenThrow(NullPointerException.class);

		assertThrows(NullPointerException.class, () -> dictMock.getMeaning("word"));
	}

	/*
	Void return type
	 */
	@Test
	public void givenVoidReturnType_whenUsingDoThrow_thenExceptionIsThrown() {
		MyDictionary dictMock = mock(MyDictionary.class);
		doThrow(IllegalStateException.class).when(dictMock)
				.add(anyString(), anyString());

		assertThrows(IllegalStateException.class, () -> dictMock.add("word", "meaning"));
	}

	/*
	Exception as an object
	 */
	@Test
	public void givenNonVoidReturnType_whenUsingWhenThenAndExeceptionAsNewObject_thenExceptionIsThrown() {
		MyDictionary dictMock = mock(MyDictionary.class);
		when(dictMock.getMeaning(anyString())).thenThrow(new NullPointerException("Error occurred"));

		assertThrows(NullPointerException.class, () -> dictMock.getMeaning("word"));
	}

	@Test
	public void givenNonVoidReturnType_whenUsingDoThrowAndExeceptionAsNewObject_thenExceptionIsThrown() {
		MyDictionary dictMock = mock(MyDictionary.class);
		doThrow(new IllegalStateException("Error occurred")).when(dictMock)
				.add(anyString(), anyString());

		assertThrows(IllegalStateException.class, () -> dictMock.add("word", "meaning"));
	}

	/*
	Spy
	 */
	@Test
	public void givenSpyAndNonVoidReturnType_whenUsingWhenThen_thenExceptionIsThrown() {
		MyDictionary dict = new MyDictionary();
		MyDictionary spy = Mockito.spy(dict);
		when(spy.getMeaning(anyString())).thenThrow(NullPointerException.class);

		assertThrows(NullPointerException.class, () -> spy.getMeaning("word"));
	}
}
