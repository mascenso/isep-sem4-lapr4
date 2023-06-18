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
package eCourse.app.backoffice.console;

import eCourse.app.backoffice.console.presentation.MainMenu;
import eCourse.app.common.console.BaseApplication;
import eCourse.app.common.console.presentation.authz.LoginUI;
import eCourse.domain.ECoursePasswordPolicy;
import eCourse.domain.events.NewUserRegisteredFromSignupEvent;
import eCourse.domain.events.SignupAcceptedEvent;
import eCourse.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.application.eventhandlers.SignupAcceptedWatchDog;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

import java.io.IOException;


@SuppressWarnings("squid:S106")
public final class ECourseBackoffice extends BaseApplication {

	/**
	 * avoid instantiation of this class.
	 */
	private ECourseBackoffice() {
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(final String[] args) throws IOException {
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new ECoursePasswordPolicy(),
				new PlainTextEncoder());

		new ECourseBackoffice().run(args);
	}

	@Override
	protected void doMain(final String[] args) {
		// login and go to main menu
		if (new LoginUI().show()) {
			// go to main menu
			final MainMenu menu = new MainMenu();
			menu.mainLoop();
		}
	}

	@Override
	protected String appTitle() {
		return "eCourse Back Office";
	}

	@Override
	protected String appGoodbye() {
		return "eCourse Back Office";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
		dispatcher.subscribe(new NewUserRegisteredFromSignupWatchDog(), NewUserRegisteredFromSignupEvent.class);
		dispatcher.subscribe(new SignupAcceptedWatchDog(), SignupAcceptedEvent.class);
	}





}
