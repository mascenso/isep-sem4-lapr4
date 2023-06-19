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
import eCourse.client.SharedBoardDTO;
import eCourse.domain.SharedBoard;
import eCourse.domain.valueobjects.SharedBoardTitle;
import eapli.framework.csv.CsvRecord;
import eapli.framework.time.util.Calendars;

/**
 * @author Paulo Gandra Sousa 01/06/2020
 */
public class GetAvailableMealsRequest extends BookingProtocolRequest {

    private final String type;

    public GetAvailableMealsRequest(final ListSharedBoardController controller, final String request,
                                    final String date, final String mealType) {
        super(controller, request);
        this.type = mealType;
    }

    @Override
    public String execute() {
        SharedBoardTitle mealType;
        try {
            mealType = SharedBoardTitle.valueOf(this.type);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Invalid meal type");
        }

        try {
            final Iterable<SharedBoard> sharedBoards = controller.listBoardsByUser();

            //////////////////////////////////////////////////
            return buildResponse(sharedBoards);
            //////////////////////////////////////////////////
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    private String buildResponse(final Iterable<SharedBoard> sharedBoards)
     {
        final var sb = new StringBuilder();

        // header
        sb.append("\"TITLE\", \"N ROWS\", \"N COL\", \"OWNER\"\n");

        // result rows
        for (final SharedBoard each : sharedBoards) {
            sb.append(
                    CsvRecord.valueOf(new Object[] {
                            each.identity(),
                            each.numberOfRows(),
                            each.numberOfColumns(),
                            each.owner().name(),
                            each.archive()
                    }, new boolean[] { true, false, false, true, true }).toString());
            // end of line
            sb.append("\n");
        }


        // end of message
        sb.append("\n");

        return sb.toString();
    }
}
