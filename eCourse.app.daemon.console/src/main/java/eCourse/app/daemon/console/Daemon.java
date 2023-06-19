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
package eCourse.app.daemon.console;
import eCourse.ListSharedBoardController;
import eCourse.app.daemon.console.presentation.ProtocolServer;
import eCourse.app.daemon.console.server.CsvBookingProtocolMessageParser;
import eCourse.domain.ECoursePasswordPolicy;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
@ComponentScan({"eCourse"})
public class Daemon  {

	// TODO read port number from property file
	private static final int BOOKING_PORT = 8890;

	private static final Logger LOGGER = LogManager.getLogger(Daemon.class);

	/**
	 * Avoid instantiation of this class.
	 */
	private Daemon() {
	}


	public static void main(final String[] args) {
		LOGGER.info("Configuring the daemon");

		AuthzRegistry.configure(
				PersistenceContext.repositories().users(),
				new ECoursePasswordPolicy(),
				new PlainTextEncoder());

		LOGGER.info("Starting the server socket on port {}", BOOKING_PORT);
		final var server = new ProtocolServer(buildServerDependencies());
		server.start(BOOKING_PORT, true);

		LOGGER.info("Exiting the daemon");
		System.exit(0);
	}

	private static CsvBookingProtocolMessageParser buildServerDependencies() {
		return new CsvBookingProtocolMessageParser(
				new ListSharedBoardController(),
				AuthzRegistry.authenticationService());
	}
}
