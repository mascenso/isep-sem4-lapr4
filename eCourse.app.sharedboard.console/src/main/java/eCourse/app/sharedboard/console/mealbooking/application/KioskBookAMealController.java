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
package eCourse.app.sharedboard.console.mealbooking.application;

import java.io.IOException;
import java.util.Calendar;

import eCourse.app.sharedboard.console.mealbooking.csvprotocol.client.BookingTokenDTO;
import eCourse.app.sharedboard.console.mealbooking.csvprotocol.client.MealDTO;
import eCourse.app.sharedboard.console.mealbooking.csvprotocol.client.CsvBookingProtocolProxy;
import eCourse.app.sharedboard.console.mealbooking.csvprotocol.client.FailedRequestException;

public class KioskBookAMealController {

	private final CsvBookingProtocolProxy proxy = new CsvBookingProtocolProxy();

	/**
	 * @param theDay
	 * @param mealType
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public Iterable<MealDTO> getAvailableMeals(final Calendar theDay, final String mealType)
			throws IOException, FailedRequestException {

		return proxy.getAvailableMeals(theDay, mealType);
	}

	public BookingTokenDTO bookMealForMe(String username, String password, final MealDTO meal)
			throws IllegalStateException, IOException, FailedRequestException {
		return proxy.bookMeal(username, meal.id, password);
	}
}
