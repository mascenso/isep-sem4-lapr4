/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eCourse.app.sharedboard.console.console.presentation.meals;

import java.io.IOException;
import java.util.Calendar;

import eCourse.app.sharedboard.console.mealbooking.application.KioskBookAMealController;
import eCourse.app.sharedboard.console.mealbooking.csvprotocol.client.BookingTokenDTO;
import eCourse.app.sharedboard.console.mealbooking.csvprotocol.client.MealDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eCourse.app.sharedboard.console.authz.CredentialStore;
import eCourse.app.sharedboard.console.mealbooking.csvprotocol.client.FailedRequestException;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.time.util.Calendars;
import eapli.framework.time.util.CurrentTimeCalendars;

/**
 * @author Paulo Gandra de Sousa 2021.05.25
 */
@SuppressWarnings({ "squid:S106" })
public class BookAMealThruKioskUI extends CafeteriaKioskBaseUI {
	private static final Logger LOGGER = LogManager.getLogger(BookAMealThruKioskUI.class);

	private final KioskBookAMealController theController = new KioskBookAMealController();

	@Override
	protected boolean doShow() {

		final Calendar theDay = selectValidDate();
		final var mealType = selectMealType();
		selectMealAndBook(theDay, mealType);
		return false;
	}

	private void selectMealAndBook(final Calendar theDay, final String mealType) {
		final var theMeal = selectPublishedMealsForDayAndType(theDay, mealType);
		//if (theMeal != null)
		{
			try {
				final BookingTokenDTO token = theController.bookMealForMe(CredentialStore.getUsername(),
						CredentialStore.getPassword(), theMeal);
				if (token != null) {
					System.out.println("SUCCESS.");
					System.out.println("»»»» Simulating »»»» Printing token... [" + token + "]");
				} else {
					System.out.println("It was not possible to make your booking");
				}
			} catch (final FailedRequestException e) {
				System.out.println("Problems with request, check message");
			} catch (final ConcurrencyException e) {
				System.out.println("Problems with Data integrity");
			} catch (final IOException e) {
				System.out.println("Problems with network connection");
				LOGGER.debug(e);
			}
		}
	}

	private String selectMealType() {

		System.out.println("Meal Types Available:");
		// avoid this app knowing the domain objects. however this is an enum so no
		// big deal...
		final String[] mealTypes = { "LUNCH", "DINER" };

		for (final String type : mealTypes) {
			System.out.println("\t" + type);
		}

		do {
			try {
				final String type = Console.readLine("Meal Type?");
				return type;
			} catch (final IllegalArgumentException e) {
				System.out.println("Please try again. enter a valid meal type.");
			}
		} while (true);
	}

	// TODO Date should be 12 h
	private Calendar selectValidDate() {
		Calendar theDay;

		System.out.println("Please enter a date in the future");
		do {
			theDay = Console.readCalendar("Meal Date (yyyy-MM-dd):", "yyyy-MM-dd");
			System.out.println("TRACE: " + Calendars.format(theDay));
		} while (!theDay.after(CurrentTimeCalendars.now()));
		return theDay;
	}

	private MealDTO selectPublishedMealsForDayAndType(final Calendar theDay, final String mealType) {
		Iterable<MealDTO> meals;
		try {
			meals = theController.getAvailableMeals(theDay, mealType);
			final SelectWidget<MealDTO> selector = new SelectWidget<>("Available Meals:", meals, new MealDTOPrinter());
			selector.show();
			return selector.selectedElement();
		} catch (final IOException e) {
			System.out.println("Problems with network connection");
			LOGGER.debug(e);
			return null;
		} catch (final FailedRequestException e) {
			System.out.println("Problems with request, check message");
			return null;
		}
	}
}
