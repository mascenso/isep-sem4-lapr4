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
package eCourse.client;

import eCourse.domain.CreateSharedBoardBuilder;
import eCourse.domain.SBColumn;
import eCourse.domain.SBRow;
import eCourse.domain.SharedBoard;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.ArrayList;
import java.util.List;

/**
 * Marshler/Unmarsheler for the CsvBookingProtocol. It is responsible for
 * marshling the data to create a proper network message and unmarshal the
 * network message to the proper DTO class
 *
 * @author Paulo Gandra de Sousa 2021.05.30
 */
/* package */ class MarshlerUnmarshler {

	private SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());


	public Iterable<MealDTO> parseResponseMessageGetAvailableMeals(final List<String> response)
			throws FailedRequestException {
		checkForErrorMessage(response);

		final List<MealDTO> ret = new ArrayList<>();

		response.remove(0); // removes header
		response.forEach(s -> ret.add(parseResponseMessageLineGetAvailableMeals(s)));
		return ret;
	}

	public Iterable<SharedBoardDTO> parseResponseMessageListBoards(List<String> response)
			throws FailedRequestException {

		checkForErrorMessage(response);

		//hardcoded pq falta traduzir frase em objeto
		// SystemUser pow = userBuilder.with("poweruser", "Password1", "Tom", "Riddle", "horcrux@mail.com").createdOn(CurrentTimeCalendars.now()).build();
		// List<SBColumn> columnList = new ArrayList<>();
		// List<SBRow> rowList = new ArrayList<>();
		// SharedBoard board1 = new CreateSharedBoardBuilder().withTitle(SharedBoardTitle.valueOf("Tuty")).withNumberOfColumns(3).withNumberOfRows(1).withArchive(false).withOwner(pow).withColumns(columnList).withRows(rowList).build();
		//

		final List<SharedBoardDTO> ret = new ArrayList<>();
		//ret.add(board1);

		response.remove(0); // removes header
		response.forEach(s -> ret.add(parseResponseMessageLineListBoards(s)));
		return ret;
	}



	private MealDTO parseResponseMessageLineGetAvailableMeals(final String s) {
		final String[] tokens = s.split(",");
		return new MealDTO(Long.parseLong(tokens[0]), removeDoubleQuotes(tokens[1]), removeDoubleQuotes(tokens[2]),
				Long.parseLong(tokens[3]), Long.parseLong(tokens[4]), Double.parseDouble(tokens[5]));
	}

	private SharedBoardDTO parseResponseMessageLineListBoards(final String s) {
		final String[] tokens = s.split(",");
		return new SharedBoardDTO(removeDoubleQuotes(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),removeDoubleQuotes(tokens[3]), Boolean.parseBoolean(tokens[4]));
		//return new SharedBoard(1,1);
	}



	public BookingTokenDTO parseResponseMessageBookMeal(final List<String> response) throws FailedRequestException {
		checkForErrorMessage(response);

		final String[] tokens = response.get(0).split(",");
		return new BookingTokenDTO(removeDoubleQuotes(tokens[1]));
	}

	private String removeDoubleQuotes(final String token) {
		return token.replace("\"", "").trim();
	}

	private void checkForErrorMessage(final List<String> response) throws FailedRequestException {
		final String[] tokens = response.get(0).split(",");
		final String messageType = tokens[0];

		if (messageType.equals("SERVER_ERROR") || messageType.equals("BAD_REQUEST")
				|| messageType.equals("UNKNOWN_REQUEST") || messageType.equals("ERROR_IN_REQUEST")) {
			throw new FailedRequestException(messageType + ":" + tokens[tokens.length - 1]);
		}
	}

}
