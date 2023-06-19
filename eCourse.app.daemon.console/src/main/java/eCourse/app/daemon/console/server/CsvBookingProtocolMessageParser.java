/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eCourse.app.daemon.console.server;

import eCourse.ListSharedBoardController;
import eapli.framework.csv.util.CsvLineMarshaler;
import eapli.framework.infrastructure.authz.application.Authenticator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

/**
 * The message parser for the Booking protocol.
 *
 * @author Paulo Gandra Sousa 01/06/2020
 */
public class CsvBookingProtocolMessageParser {

	private static final Logger LOGGER = LogManager.getLogger(CsvBookingProtocolMessageParser.class);

	private final ListSharedBoardController controller;
	private final Authenticator authenticationService;

	public CsvBookingProtocolMessageParser(final ListSharedBoardController controller,
			Authenticator authenticationService) {
		this.controller = controller;
		this.authenticationService = authenticationService;
	}

	private ListSharedBoardController getController() {

		return controller;
	}

	/**
	 * Parse and build the request.
	 *
	 * @param inputLine
	 *
	 * @return
	 */
	public BookingProtocolRequest parse(final String inputLine) {
		// as a fallback make sure we return unknown
		BookingProtocolRequest request = new UnknownRequest(inputLine);

		// parse to determine which type of request and if it is syntactically valid
		String[] tokens;
		try {
			tokens = CsvLineMarshaler.tokenize(inputLine).toArray(new String[0]);
			if ("GET_AVAILABLE_MEALS".equals(tokens[0])) {
				request = parseGetAvailableMeals(inputLine, tokens);
			} else if ("BOOK_A_MEAL".equals(tokens[0])) {
				request =  new UnknownRequest(inputLine);
			}
		} catch (final ParseException e) {
			LOGGER.info("Unable to parse request: {}", inputLine);
			request = new BadRequest(inputLine, "Unable to parse request");
		}

		return request;
	}

	private boolean isStringParam(final String string) {
		return string.length() >= 2 && string.charAt(0) == '"' && string.charAt(string.length() - 1) == '"';
	}

	private BookingProtocolRequest parseGetAvailableMeals(final String inputLine, final String[] tokens) {
		BookingProtocolRequest request;
		if (tokens.length != 2) {
			request = new BadRequest(inputLine, "Wrong number of parameters");
		} else if (!isStringParam(tokens[1])) {
			request = new BadRequest(inputLine, "Both date and meal type must be inside quotes");
		} else {
			request = new GetAvailableMealsRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),
					CsvLineMarshaler.unquote(tokens[1]));
		}
		return request;
	}
}
