
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.teksystems.schooldatabase.utilities.EmailValidation;

class EmailValidationTest {
	private static EmailValidation ev;

	@BeforeAll
	public static void setUp() {
		ev = new EmailValidation();
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc123@gmail.c2m", "abc123@gmail.c2m", "abc123gmail.com", "abc123@gmail.coms"})
	void invalidEmailValidation(String email) {
		Assertions.assertFalse(ev.isValidEmail(email));
	}
	
	@ParameterizedTest
	@NullSource
	void nullEmailValidation(String email) {
		Assertions.assertFalse(ev.isValidEmail(email));
	}
	
	@ParameterizedTest
	@EmptySource
	void emptyEmailValidation(String email) {
		Assertions.assertFalse(ev.isValidEmail(email));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"9", "555-765-098", "99.456.98799", "786/765/0987"})
	void negativePhoneNumberTest(String phoneNumber) {
		Assertions.assertFalse(ev.isPhoneNumberValid(phoneNumber));
	}
	
	@ParameterizedTest
	@NullSource
	void nullPhoneNumberTest(String phoneNumber) {
		Assertions.assertFalse(ev.isPhoneNumberValid(phoneNumber));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"9......67659-888", "412-765-098", "99.456.9870", "786 765      987", "453..2345...3-6.."})
	void positivePhoneNumberTest(String phoneNumber) {
		Assertions.assertTrue(ev.isPhoneNumberValid(phoneNumber));
	}
}
