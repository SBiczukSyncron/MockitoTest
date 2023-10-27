package org.example.captor;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CaptorTests {

	@Mock
	private NotificationService notificationService;

	@InjectMocks
	private UserService userService;

	@Captor
	private ArgumentCaptor<User> userArgumentCaptor;

	@Test
	public void testNotifyUser() {
		MockitoAnnotations.openMocks(this);
		String message = "Test notification message";
		String username = "testuser";

		userService.notifyUser(message, username);

		verify(notificationService).sendNotification(eq(message), userArgumentCaptor.capture());
		User capturedUser = userArgumentCaptor.getValue();

		assertEquals(username, capturedUser.getUsername());
		assertEquals(username + "@example.com", capturedUser.getEmail());
	}
}
