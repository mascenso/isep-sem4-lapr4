package eCourse.app.manager.console;

import eCourse.app.common.console.BaseApplication;
import eCourse.app.common.console.presentation.authz.LoginAction;
import eCourse.app.student.console.presentation.FrontMenu;
import eCourse.app.student.console.presentation.MainMenu;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.domain.ECoursePasswordPolicy;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
@SpringBootApplication
@ComponentScan({"eCourse"})
public class ManagerApp extends BaseApplication {

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private ManagerApp() {
    }

    public static void main(final String[] args) {
        System.out.println();

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new ECoursePasswordPolicy(),
                new PlainTextEncoder());

        new ManagerApp().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        new FrontMenu().show();
    }

    @Override
    protected String appTitle() {
        return "eCourse [Manager]";
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
