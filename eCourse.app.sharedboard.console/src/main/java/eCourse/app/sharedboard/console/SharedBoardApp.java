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
package eCourse.app.sharedboard.console;

import eCourse.app.common.console.BaseApplication;
import eCourse.app.sharedboard.console.console.presentation.FrontMenu;
import eCourse.domain.ECoursePasswordPolicy;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;


@SuppressWarnings("squid:S106")
public final class SharedBoardApp extends BaseApplication {
	/**
	 * Empty constructor is private to avoid instantiation of this class.
	 */
	private SharedBoardApp(){
	}

	public static void main(final String[] args) {
		System.out.println();

		AuthzRegistry.configure(PersistenceContext.repositories().users(), new ECoursePasswordPolicy(),
				new PlainTextEncoder());

		new SharedBoardApp().run(args);
	}

	@Override
	protected void doMain(String[] args) {
		new FrontMenu().show();
	}

	@Override
	protected String appTitle() {
		return "eCourse [Shared Board]";
	}

	@Override
	protected String appGoodbye() {
		return "Signing out";
	}

	@Override
	protected void doSetupEventHandlers(EventDispatcher dispatcher) {
		// TODO setup event handlers for your app
	}

}
